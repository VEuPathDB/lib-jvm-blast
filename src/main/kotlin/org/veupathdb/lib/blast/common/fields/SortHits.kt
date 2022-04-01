package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagSortHits
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqInt


internal fun ParseSortHits(js: ObjectNode) =
  js[FlagSortHits]?.let {
    SortHits(HitSorting.values()[it.reqInt(FlagSortHits)])
  }
    ?: SortHits()


/**
 * -sorthits `<Integer, (>=0 and =<4)>`
 *
 * Sorting option for hits.
 *
 * Alignment view options:
 * * `0` = Sort by evalue
 * * `1` = Sort by bit score
 * * `2` = Sort by total score
 * * `3` = Sort by percent identity
 * * `4` = Sort by query coverage
 *
 * Not applicable for -outfmt > `4`
 */
@JvmInline
value class SortHits(val value: HitSorting = HitSorting.None) : BlastField {
  override val isDefault get() = value == HitSorting.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagSortHits, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagSortHits, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagSortHits, value.value)
}


////////////////////////////////////////////////////////////////////////////////


enum class HitSorting {
  ByExpectValue,
  ByBitScore,
  ByTotalScore,
  ByPercentIdentity,
  ByQueryCoverage,
  None;

  val value = ordinal
}