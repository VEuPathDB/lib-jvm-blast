package org.veupathdb.lib.blast.blastx.field

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagTask
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


private val Def = BlastXTaskType.BlastX


internal fun ParseBlastXTask(js: ObjectNode) =
  js[FlagTask]?.let { BlastXTask(parseEnum(it.reqString(FlagTask))) } ?: BlastXTask()


/**
 * -task `<String>`
 *
 * Permissible values:
 * * blastx
 * * blastx-fast
 *
 * Task to execute
 *
 * Default = `blastx`
 */
@JvmInline
value class BlastXTask(val value: BlastXTaskType = Def) : BlastField {
  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagTask, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagTask, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagTask, value.value)
}


private fun parseEnum(value: String) =
  when(value.lowercase()) {
    "blastx"      -> BlastXTaskType.BlastX
    "blastx-fast" -> BlastXTaskType.BlastXFast
    else          -> throw IllegalArgumentException("Invalid value for $FlagTask: $value")
  }

enum class BlastXTaskType {
  BlastX,
  BlastXFast;

  val value get() = when(this) {
    BlastX     -> "blastx"
    BlastXFast -> "blastx-fast"
  }
}