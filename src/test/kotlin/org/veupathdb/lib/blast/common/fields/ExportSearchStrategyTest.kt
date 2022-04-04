package org.veupathdb.lib.blast.common.fields

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.veupathdb.lib.blast.common.FlagExportSearchStrategy
import org.veupathdb.lib.jackson.Json

@DisplayName(FlagExportSearchStrategy)
internal class ExportSearchStrategyTest {

  @Nested
  @DisplayName("ParseExportSearchStrategy()")
  inner class Parse {

    @Nested
    @DisplayName("when given a JSON object containing a non-text value")
    inner class NonString {

      @Test
      @DisplayName("throws an exception")
      fun t1() {
        assertThrows<IllegalArgumentException> {
          ParseExportSearchStrategy(Json.new { put(FlagExportSearchStrategy, 40) })
        }
      }
    }

    @Nested
    @DisplayName("when given a JSON object with no db file value")
    inner class Absent {

      @Test
      @DisplayName("returns a defaulted ExportSearchStrategy instance")
      fun t1() {
        assertTrue(ParseExportSearchStrategy(Json.new {}).isDefault)
      }
    }

    @Nested
    @DisplayName("when given a JSON object containing a text value")
    inner class Present {

      @Test
      @DisplayName("returns a ExportSearchStrategy instance wrapping")
      fun t1() {
        val inp = Json.newObject { put(FlagExportSearchStrategy, "bunny") }
        assertEquals("bunny", ParseExportSearchStrategy(inp).file)
      }
    }
  }

  @Nested
  @DisplayName("ExportSearchStrategy()")
  inner class Type {

    @Nested
    @DisplayName("when constructed with no arguments")
    inner class NoArg {

      @Test
      @DisplayName("default == true")
      fun t1() {
        assertTrue(ExportSearchStrategy().isDefault)
      }

      @Test
      @DisplayName("appendJson() does nothing")
      fun t2() {
        val inp = Json.newObject()
        ExportSearchStrategy().appendJson(inp)
        assertEquals(0, inp.size())
      }

      @Test
      @DisplayName("appendCliSegment() does nothing")
      fun t3() {
        val inp = StringBuilder(0)
        ExportSearchStrategy().appendCliSegment(inp)
        assertEquals("", inp.toString())
      }

      @Test
      @DisplayName("appendCliParts() does nothing")
      fun t4() {
        val inp = ArrayList<String>(0)
        ExportSearchStrategy().appendCliParts(inp)
        assertTrue(inp.isEmpty())
      }
    }

    @Nested
    @DisplayName("when constructed with an argument")
    inner class Arg {

      @Test
      @DisplayName("isDefault == false")
      fun t1() {
        assertFalse(ExportSearchStrategy("bye.db").isDefault)
      }

      @Test
      @DisplayName("appendJson() appends the flag to the JSON object input.")
      fun t2() {
        val inp = Json.newObject()
        ExportSearchStrategy("goop.txt").appendJson(inp)
        assertEquals("""{"$FlagExportSearchStrategy":"goop.txt"}""", inp.toString())
      }

      @Test
      @DisplayName("appendCliSegment() appends the flag to the StringBuilder input.")
      fun t3() {
        val inp = StringBuilder(32)
        ExportSearchStrategy("nope.nope.nope").appendCliSegment(inp)
        assertEquals(" $FlagExportSearchStrategy 'nope.nope.nope'", inp.toString())
      }

      @Test
      @DisplayName("appendCliParts() appends the flag to the List input.")
      fun t4() {
        val inp = ArrayList<String>(2)
        ExportSearchStrategy("yup.yup.yup").appendCliParts(inp)
        assertEquals(2, inp.size)
        assertEquals(FlagExportSearchStrategy, inp[0])
        assertEquals("yup.yup.yup", inp[1])
      }
    }
  }
  

}