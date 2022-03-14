package org.veupathdb.lib.blast.blastx

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.blastx.field.*
import org.veupathdb.lib.blast.common.BlastQueryWithIPGImpl
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.*

internal class BlastXImpl(
  shortHelp:                HelpShort                = HelpShort(),
  longHelp:                 HelpLong                 = HelpLong(),
  version:                  Version                  = Version(),
  outFile:                  OutFile                  = OutFile(),
  outFormat:                OutFormat                = OutFormat(),
  showGIs:                  ShowGIs                  = ShowGIs(),
  numDescriptions:          NumDescriptions          = NumDescriptions(),
  numAlignments:            NumAlignments            = NumAlignments(),
  lineLength:               LineLength               = LineLength(),
  html:                     HTML                     = HTML(),
  sortHits:                 SortHits                 = SortHits(),
  sortHSPs:                 SortHSPs                 = SortHSPs(),
  maxTargetSeqs:            MaxTargetSeqs            = MaxTargetSeqs(),
  parseDefLines:            ParseDefLines            = ParseDefLines(),
  queryFile:                QueryFile                = QueryFile(),
  queryLocation:            QueryLocation            = QueryLocation(),
  dbFile:                   DBFile                   = DBFile(),
  expectValue:              ExpectValue              = ExpectValue(),
  lowercaseMasking:         LowercaseMasking         = LowercaseMasking(),
  entrezQuery:              EntrezQuery              = EntrezQuery(),
  maxHSPs:                  MaxHSPs                  = MaxHSPs(),
  dbSize:                   DBSize                   = DBSize(),
  searchSpace:              SearchSpace              = SearchSpace(),
  importSearchStrategy:     ImportSearchStrategy     = ImportSearchStrategy(),
  exportSearchStrategy:     ExportSearchStrategy     = ExportSearchStrategy(),
  extensionDropoffUngapped: ExtensionDropoffUngapped = ExtensionDropoffUngapped(),
  windowSize:               WindowSize               = WindowSize(),
  remote:                   Remote                   = Remote(),
  giListFile:               GIList                   = GIList(),
  negativeGIListFile:       NegativeGIList           = NegativeGIList(),
  seqIdListFile:            SeqIdList                = SeqIdList(),
  negativeSeqIdListFile:    NegativeSeqIdList        = NegativeSeqIdList(),
  taxIdListFile:            TaxIdList                = TaxIdList(),
  negativeTaxIdListFile:    NegativeTaxIdList        = NegativeTaxIdList(),
  taxIds:                   TaxIDs                   = TaxIDs(),
  negativeTaxIds:           NegativeTaxIDs           = NegativeTaxIDs(),
  ipgListFile:              IPGList                  = IPGList(),
  negativeIPGListFile:      NegativeIPGList          = NegativeIPGList(),

  override var strand:                       Strand                       = Strand(),
  override var queryGenCode:                 QueryGenCode                 = QueryGenCode(),
  override var task:                         BlastXTask                   = BlastXTask(),
  override var wordSize:                     WordSizeX                    = WordSizeX(),
  override var gapOpen:                      GapOpen                      = GapOpen(),
  override var gapExtend:                    GapExtend                    = GapExtend(),
  override var maxIntronLength:              MaxIntronLength              = MaxIntronLength(),
  override var matrix:                       ScoringMatrixX               = ScoringMatrixX(),
  override var threshold:                    Threshold                    = Threshold(),
  override var compBasedStats:               CompBasedStatsX              = CompBasedStatsX(),
  override var subjectFile:                  SubjectFile                  = SubjectFile(),
  override var subjectLocation:              SubjectLocation              = SubjectLocation(),
  override var seg:                          SegX                         = ValSeg(),
  override var dbSoftMask:                   DBSoftMask                   = DBSoftMask(),
  override var dbHardMask:                   DBHardMask                   = DBHardMask(),
  override var cullingLimit:                 CullingLimit                 = CullingLimit(),
  override var sumStats:                     SumStats                     = SumStats(),
  override var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped = ExtensionDropoffPrelimGapped(),
  override var extensionDropoffFinalGapped:  ExtensionDropoffFinalGapped  = ExtensionDropoffFinalGapped(),
  override var ungappedAlignmentsOnly:       UngappedAlignmentsOnly       = UngappedAlignmentsOnly(),
  override var numCPUCores:                  NumCPUCores                  = NumCPUCores(),
  override var useSmithWatermanTraceback:    UseSmithWatermanTraceback    = UseSmithWatermanTraceback(),
  override var bestHitOverhang:              BestHitOverhang              = BestHitOverhang(),
  override var bestHitScoreEdge:             BestHitScoreEdge             = BestHitScoreEdge(),
  override var subjectBestHit:               SubjectBestHit               = SubjectBestHit(),
  override var softMasking:                  SoftMaskingX                 = SoftMaskingX()
) : BlastX, BlastQueryWithIPGImpl(
  BlastTool.BlastX,
  shortHelp,
  longHelp,
  version,
  outFile,
  outFormat,
  showGIs,
  numDescriptions,
  numAlignments,
  lineLength,
  html,
  sortHits,
  sortHSPs,
  maxTargetSeqs,
  parseDefLines,
  queryFile,
  queryLocation,
  dbFile,
  expectValue,
  lowercaseMasking,
  entrezQuery,
  maxHSPs,
  dbSize,
  searchSpace,
  importSearchStrategy,
  exportSearchStrategy,
  extensionDropoffUngapped,
  windowSize,
  remote,
  giListFile,
  negativeGIListFile,
  seqIdListFile,
  negativeSeqIdListFile,
  taxIdListFile,
  negativeTaxIdListFile,
  taxIds,
  negativeTaxIds,
  ipgListFile,
  negativeIPGListFile,
) {
  constructor(js: ObjectNode) : this (
    ParseHelpShort(js),
    ParseHelpLong(js),
    ParseVersion(js),
    ParseOutFile(js),
    ParseOutFormat(js),
    ParseShowGIs(js),
    ParseNumDescriptions(js),
    ParseNumAlignments(js),
    ParseLineLength(js),
    ParseHTML(js),
    ParseSortHits(js),
    ParseSortHSPs(js),
    ParseMaxTargetSeqs(js),
    ParseParseDefLines(js),
    ParseQueryFile(js),
    ParseQueryLocation(js),
    ParseDBFile(js),
    ParseEValue(js),
    ParseLowercaseMasking(js),
    ParseEntrezQuery(js),
    ParseMaxHSPs(js),
    ParseDBSize(js),
    ParseSearchSpace(js),
    ParseImportSearchStrategy(js),
    ParseExportSearchStrategy(js),
    ParseXDropUngap(js),
    ParseWindowSize(js),
    ParseRemote(js),
    ParseGIList(js),
    ParseNegGIList(js),
    ParseSeqIdList(js),
    ParseNegSeqIdList(js),
    ParseTaxIdList(js),
    ParseNegTaxIdList(js),
    ParseTaxIDs(js),
    ParseNegTaxIDs(js),
    ParseIPGList(js),
    ParseNegativeIPGList(js),
    ParseStrand(js),
    ParseQueryGenCode(js),
    ParseBlastXTask(js),
    ParseWordSizeX(js),
    ParseGapOpen(js),
    ParseGapExtend(js),
    ParseMaxIntronLength(js),
    ParseScoringMatrixX(js),
    ParseThreshold(js),
    ParseCompBasedStatsX(js),
    ParseSubjectFile(js),
    ParseSubjectLocation(js),
    ParseSegX(js),
    ParseDBSoftMask(js),
    ParseDBHardMask(js),
    ParseCullingLimit(js),
    ParseSumStats(js),
    ParseXDropGap(js),
    ParseXDropGapFinal(js),
    ParseUngappedAlignmentsOnly(js),
    ParseNumCPUCores(js),
    ParseUseSWTBack(js),
    ParseBestHitOverhang(js),
    ParseBestHitScoreEdge(js),
    ParseSubjectBestHit(js),
    ParseSoftMaskingX(js),
  )

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    strand.appendJson(js)
    queryGenCode.appendJson(js)
    task.appendJson(js)
    wordSize.appendJson(js)
    gapOpen.appendJson(js)
    gapExtend.appendJson(js)
    maxIntronLength.appendJson(js)
    matrix.appendJson(js)
    threshold.appendJson(js)
    compBasedStats.appendJson(js)
    subjectFile.appendJson(js)
    subjectLocation.appendJson(js)
    seg.appendJson(js)
    dbSoftMask.appendJson(js)
    dbHardMask.appendJson(js)
    cullingLimit.appendJson(js)
    sumStats.appendJson(js)
    extensionDropoffPrelimGapped.appendJson(js)
    extensionDropoffFinalGapped.appendJson(js)
    ungappedAlignmentsOnly.appendJson(js)
    numCPUCores.appendJson(js)
    useSmithWatermanTraceback.appendJson(js)
    bestHitOverhang.appendJson(js)
    bestHitScoreEdge.appendJson(js)
    subjectBestHit.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    strand.appendCliSegment(sb)
    queryGenCode.appendCliSegment(sb)
    task.appendCliSegment(sb)
    wordSize.appendCliSegment(sb)
    gapOpen.appendCliSegment(sb)
    gapExtend.appendCliSegment(sb)
    maxIntronLength.appendCliSegment(sb)
    matrix.appendCliSegment(sb)
    threshold.appendCliSegment(sb)
    compBasedStats.appendCliSegment(sb)
    subjectFile.appendCliSegment(sb)
    subjectLocation.appendCliSegment(sb)
    seg.appendCliSegment(sb)
    dbSoftMask.appendCliSegment(sb)
    dbHardMask.appendCliSegment(sb)
    cullingLimit.appendCliSegment(sb)
    sumStats.appendCliSegment(sb)
    extensionDropoffPrelimGapped.appendCliSegment(sb)
    extensionDropoffFinalGapped.appendCliSegment(sb)
    ungappedAlignmentsOnly.appendCliSegment(sb)
    numCPUCores.appendCliSegment(sb)
    useSmithWatermanTraceback.appendCliSegment(sb)
    bestHitOverhang.appendCliSegment(sb)
    bestHitScoreEdge.appendCliSegment(sb)
    subjectBestHit.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    strand.appendCliParts(cli)
    queryGenCode.appendCliParts(cli)
    task.appendCliParts(cli)
    wordSize.appendCliParts(cli)
    gapOpen.appendCliParts(cli)
    gapExtend.appendCliParts(cli)
    maxIntronLength.appendCliParts(cli)
    matrix.appendCliParts(cli)
    threshold.appendCliParts(cli)
    compBasedStats.appendCliParts(cli)
    subjectFile.appendCliParts(cli)
    subjectLocation.appendCliParts(cli)
    seg.appendCliParts(cli)
    dbSoftMask.appendCliParts(cli)
    dbHardMask.appendCliParts(cli)
    cullingLimit.appendCliParts(cli)
    sumStats.appendCliParts(cli)
    extensionDropoffPrelimGapped.appendCliParts(cli)
    extensionDropoffFinalGapped.appendCliParts(cli)
    ungappedAlignmentsOnly.appendCliParts(cli)
    numCPUCores.appendCliParts(cli)
    useSmithWatermanTraceback.appendCliParts(cli)
    bestHitOverhang.appendCliParts(cli)
    bestHitScoreEdge.appendCliParts(cli)
    subjectBestHit.appendCliParts(cli)
  }
}