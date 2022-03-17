package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagIPGList
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.put
import org.veupathdb.lib.blast.util.reqString


internal fun ParseIPGList(js: ObjectNode) =
  js[FlagIPGList]?.let { IPGList(it.reqString(FlagIPGList)) } ?: IPGList()


@JvmInline
value class IPGList(val value: String = "") : BlastField {
  override val isDefault get() = value.isBlank()

  override fun appendJson(js: ObjectNode) =
    js.put(isDefault, FlagIPGList, value)

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagIPGList, value)

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagIPGList, value)
}