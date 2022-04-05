package org.veupathdb.lib.blast.common.fields

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.veupathdb.lib.blast.common.FlagQueryCoverageHSPPercent
import org.veupathdb.lib.jackson.Json

@DisplayName(FlagQueryCoverageHSPPercent)
internal class QueryCoverageHSPPercentTest {

  @Nested
  @DisplayName("ParseQueryCoverageHSPPercent()")
  inner class Parse {

    @Nested
    @DisplayName("when given a JSON object containing a non-number value")
    inner class NonString {

      @Test
      @DisplayName("throws an exception")
      fun t1() {
        assertThrows<IllegalArgumentException> {
          ParseQueryCoverageHSPPercent(Json.new { put(FlagQueryCoverageHSPPercent, "yodeling") })
        }
      }
    }

    @Nested
    @DisplayName("when given a JSON object with no db file value")
    inner class Absent {

      @Test
      @DisplayName("returns a defaulted QueryCoverageHSPPercent instance")
      fun t1() {
        assertTrue(ParseQueryCoverageHSPPercent(Json.new {}).isDefault)
      }
    }

    @Nested
    @DisplayName("when given a JSON object containing a text value")
    inner class Present {

      @Test
      @DisplayName("returns a QueryCoverageHSPPercent instance wrapping")
      fun t1() {
        val inp = Json.newObject { put(FlagQueryCoverageHSPPercent, 32.32) }
        assertEquals(32.32, ParseQueryCoverageHSPPercent(inp).value)
      }
    }
  }

  @Nested
  @DisplayName("QueryCoverageHSPPercent()")
  inner class Type {

    @Nested
    @DisplayName("when constructed with no arguments")
    inner class NoArg {

      @Test
      @DisplayName("default == true")
      fun t1() {
        assertTrue(QueryCoverageHSPPercent().isDefault)
      }

      @Test
      @DisplayName("appendJson() does nothing")
      fun t2() {
        val inp = Json.newObject()
        QueryCoverageHSPPercent().appendJson(inp)
        assertEquals(0, inp.size())
      }

      @Test
      @DisplayName("appendCliSegment() does nothing")
      fun t3() {
        val inp = StringBuilder(0)
        QueryCoverageHSPPercent().appendCliSegment(inp)
        assertEquals("", inp.toString())
      }

      @Test
      @DisplayName("appendCliParts() does nothing")
      fun t4() {
        val inp = ArrayList<String>(0)
        QueryCoverageHSPPercent().appendCliParts(inp)
        assertTrue(inp.isEmpty())
      }
    }

    @Nested
    @DisplayName("when constructed with an argument")
    inner class Arg {

      @Test
      @DisplayName("isDefault == false")
      fun t1() {
        assertFalse(QueryCoverageHSPPercent(99.0).isDefault)
      }

      @Test
      @DisplayName("appendJson() appends the flag to the JSON object input.")
      fun t2() {
        val inp = Json.newObject()
        QueryCoverageHSPPercent(3.3).appendJson(inp)
        assertEquals("""{"$FlagQueryCoverageHSPPercent":3.3}""", inp.toString())
      }

      @Test
      @DisplayName("appendCliSegment() appends the flag to the StringBuilder input.")
      fun t3() {
        val inp = StringBuilder(32)
        QueryCoverageHSPPercent(69.25).appendCliSegment(inp)
        assertEquals(" $FlagQueryCoverageHSPPercent 69.25", inp.toString())
      }

      @Test
      @DisplayName("appendCliParts() appends the flag to the List input.")
      fun t4() {
        val inp = ArrayList<String>(2)
        QueryCoverageHSPPercent(42.5).appendCliParts(inp)
        assertEquals(2, inp.size)
        assertEquals(FlagQueryCoverageHSPPercent, inp[0])
        assertEquals("42.5", inp[1])
      }
    }
  }
  

}