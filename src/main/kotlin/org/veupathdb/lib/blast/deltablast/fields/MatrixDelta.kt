package org.veupathdb.lib.blast.deltablast.fields

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagMatrix
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseMatrixDelta(js: ObjectNode) =
  js[FlagMatrix]?.let { MatrixDelta(parseEnum(it)) } ?: MatrixDelta()


@JvmInline
value class MatrixDelta(val value: MatrixDeltaType = MatrixDeltaType.None)
  : BlastField
{
  override val isDefault get() = value == MatrixDeltaType.None

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagMatrix, value.value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagMatrix, value.value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagMatrix, value.value)
}


private inline fun parseEnum(js: JsonNode): MatrixDeltaType {
  val tmp = js.reqString(FlagMatrix).uppercase()

  for (v in MatrixDeltaType.values())
    if (tmp == v.value)
      return v

  throw IllegalArgumentException("Invalid $FlagMatrix value: $tmp")
}


enum class MatrixDeltaType {
  Blosum45,
  Blosum50,
  Blosum62,
  Blosum80,
  Blosum90,
  Pam30,
  Pam70,
  Pam250,
  None;

  val value = name.uppercase()
}