package org.veupathdb.lib.blast.deltablast.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagWordSize
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUInt


private const val Def = UInt.MAX_VALUE


internal fun ParseWordSizeDelta(js: ObjectNode) =
  js[FlagWordSize]?.let { WordSizeDelta(it.reqUInt(FlagWordSize)) }
    ?: WordSizeDelta()


@JvmInline
value class WordSizeDelta(val value: UInt = Def) : BlastField {
  init {
    if (value < 2u)
      throw IllegalArgumentException("$FlagWordSize must be >= 2")
  }

  override val isDefault get() = value == 0u

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagWordSize, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagWordSize, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagWordSize, value)
}