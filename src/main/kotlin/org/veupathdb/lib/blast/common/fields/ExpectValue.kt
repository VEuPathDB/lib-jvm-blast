package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagExpectValue
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private const val Def = "10"

private val Rgx = Regex("^\\d+$")


internal fun ParseEValue(j: ObjectNode) =
  j[FlagExpectValue]?.let { ExpectValue(it.reqString(FlagExpectValue)) } ?:
    ExpectValue()


@JvmInline
value class ExpectValue(val value: String = Def): BlastField {

  init {
    if (!Rgx.matches(value))
      throw IllegalArgumentException("$FlagExpectValue must be a numeric string.")
  }

  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagExpectValue, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagExpectValue, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagExpectValue, value)
}