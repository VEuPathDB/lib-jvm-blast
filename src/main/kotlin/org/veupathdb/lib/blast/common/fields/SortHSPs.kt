package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSortHSPs
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


internal fun ParseSortHSPs(js: ObjectNode) =
  js[FlagSortHSPs]?.let { SortHSPs(parseEnum(it)) } ?: SortHSPs()


@JvmInline
value class SortHSPs(val value: HSPSorting = HSPSorting.None) : BlastField {
  override val isDefault get() = value == HSPSorting.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSortHSPs, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSortHSPs, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSortHSPs, value.value)
}


////////////////////////////////////////////////////////////////////////////////


@Suppress("NOTHING_TO_INLINE")
private inline fun parseEnum(js: JsonNode): HSPSorting {
  val i = js.reqInt(FlagSortHSPs)

  try {
    return HSPSorting.values()[i]
  } catch (e: IndexOutOfBoundsException) {
    throw IllegalArgumentException("Invalid $FlagSortHSPs value: $i")
  }
}

enum class HSPSorting {
  ByHSPExpectValue,
  ByHSPScore,
  ByHSPQueryStart,
  ByHSPPercentIdentity,
  ByHSPSubjectStart,
  None;

  inline val value get() = ordinal
}