package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagBestHitScoreEdge
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put


private const val Def = -1.0


internal fun ParseBestHitScoreEdge(js: ObjectNode): BestHitScoreEdge {
  val tmp = js[FlagBestHitScoreEdge] ?: return BestHitScoreEdge()

  if (!tmp.isNumber)
    throw IllegalArgumentException("$FlagBestHitScoreEdge must be a numeric value > 0 and < 0.5")

  return BestHitScoreEdge(js.doubleValue())
}


@JvmInline
value class BestHitScoreEdge(val value: Double = Def) : BlastField {
  init {
    if (value != Def && (value <= 0 || value >= 0.5))
      throw IllegalArgumentException("$FlagBestHitScoreEdge must be (>0 and <0.5)")
  }

  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagBestHitScoreEdge, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagBestHitScoreEdge, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagBestHitScoreEdge, value)
}