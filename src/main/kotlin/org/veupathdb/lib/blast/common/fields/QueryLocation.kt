package org.veupathdb.lib.blast.common.fields

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.common.FlagQueryLocation
import org.veupathdb.lib.blast.serial.BlastField
import org.veupathdb.lib.blast.util.add
import org.veupathdb.lib.blast.util.append
import org.veupathdb.lib.blast.util.reqUInt
import org.veupathdb.lib.blast.util.requireObject


private const val KeyStart = "start"
private const val KeyStop  = "stop"
private const val DefStart = 0u
private const val DefStop  = 0u


internal fun ParseQueryLocation(js: ObjectNode): QueryLocation {
  val obj = js[FlagQueryLocation]?.requireObject(FlagQueryLocation)
    ?: return QueryLocation()

  return QueryLocation(
    obj[KeyStart]?.reqUInt { "$FlagQueryLocation.$KeyStart" } ?: DefStart,
    obj[KeyStop]?.reqUInt { "$FlagQueryLocation.$KeyStop" } ?: DefStop
  )
}


data class QueryLocation(val start: UInt = DefStart, val stop: UInt = DefStop)
  : BlastField
{
  override val isDefault get() = start == DefStart && stop == DefStop

  override fun appendJson(js: ObjectNode) {
    with(js.putObject(FlagQueryLocation)) {
      put(KeyStart, start.toLong())
      put(KeyStop, stop.toLong())
    }
  }

  override fun appendCliSegment(cli: StringBuilder) =
    cli.append(isDefault, FlagQueryLocation) { "$start-$stop" }

  override fun appendCliParts(cli: MutableList<String>) =
    cli.add(isDefault, FlagQueryLocation) { "$start-$stop" }
}