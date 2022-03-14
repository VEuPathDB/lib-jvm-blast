package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqUByte


private const val Key: String = "-query_gencode"
private const val Def: UByte  = 1u


internal fun ParseQueryGenCode(js: ObjectNode) =
  js[Key]?.let { QueryGenCode(it.reqUByte(Key)) } ?: QueryGenCode()


@JvmInline
value class QueryGenCode(val value: UByte = Def) : BlastField {
  init {
    when {
      inRange(value, 1u, 6u)   -> {}
      inRange(value, 9u, 16u)  -> {}
      inRange(value, 21u, 31u) -> {}
      value == 33u.toUByte()   -> {}
      else                     ->
        throw IllegalArgumentException("$Key must be an int value equal to 33 or in one of the following ranges: 1-6, 9-16, 21-31")
    }
  }

  override val isDefault get() = value == Def

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, Key, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, Key, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, Key, value)
}


@Suppress("NOTHING_TO_INLINE")
private inline fun inRange(v: UByte, n: UByte, x: UByte) = (v in n .. x)