package org.veupathdb.lib.blast.blastp

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.blastp.field.*
import org.veupathdb.lib.blast.common.BlastQueryWithIPGImpl
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.err.ErrorMap

internal class BlastPImpl(
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
  seqIDListFile:            SeqIDList                = SeqIDList(),
  negativeSeqIDListFile:    NegativeSeqIDList        = NegativeSeqIDList(),
  taxIDListFile:            TaxIDList                = TaxIDList(),
  negativeTaxIDListFile:    NegativeTaxIDList        = NegativeTaxIDList(),
  taxIds:                   TaxIDs                   = TaxIDs(),
  negativeTaxIds:           NegativeTaxIDs           = NegativeTaxIDs(),
  ipgListFile:              IPGList                  = IPGList(),
  negativeIPGListFile:      NegativeIPGList          = NegativeIPGList(),

  override var task:                         BlastPTask                   = BlastPTask(),
  override var wordSize:                     WordSizeP                    = WordSizeP(),
  override var gapOpen:                      GapOpen                      = GapOpen(),
  override var gapExtend:                    GapExtend                    = GapExtend(),
  override var matrix:                       ScoringMatrixP               = ScoringMatrixP(),
  override var threshold:                    Threshold                    = Threshold(),
  override var compBasedStats:               CompBasedStatsP              = CompBasedStatsP(),
  override var subjectFile:                  SubjectFile                  = SubjectFile(),
  override var subjectLocation:              SubjectLocation              = SubjectLocation(),
  override var seg:                          SegP                         = NoSegP,
  override var dbSoftMask:                   DBSoftMask                   = DBSoftMask(),
  override var dbHardMask:                   DBHardMask                   = DBHardMask(),
  override var cullingLimit:                 CullingLimit                 = CullingLimit(),
  override var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped = ExtensionDropoffPrelimGapped(),
  override var extensionDropoffFinalGapped:  ExtensionDropoffFinalGapped  = ExtensionDropoffFinalGapped(),
  override var ungappedAlignmentsOnly:       UngappedAlignmentsOnly       = UngappedAlignmentsOnly(),
  override var numCPUCores:                  NumCPUCores                  = NumCPUCores(),
  override var useSmithWatermanTraceback:    UseSmithWatermanTraceback    = UseSmithWatermanTraceback(),
  override var bestHitOverhang:              BestHitOverhang              = BestHitOverhang(),
  override var bestHitScoreEdge:             BestHitScoreEdge             = BestHitScoreEdge(),
  override var subjectBestHit:               SubjectBestHit               = SubjectBestHit(),
  override var softMasking:                  SoftMaskingP                 = SoftMaskingP()
) : BlastP, BlastQueryWithIPGImpl(
  BlastTool.BlastP,
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
  seqIDListFile,
  negativeSeqIDListFile,
  taxIDListFile,
  negativeTaxIDListFile,
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
    ParseSeqIDList(js),
    ParseNegSeqIDList(js),
    ParseTaxIDList(js),
    ParseNegTaxIDList(js),
    ParseTaxIDs(js),
    ParseNegTaxIDs(js),
    ParseIPGList(js),
    ParseNegativeIPGList(js),
    ParseBlastPTask(js),
    ParseWordSizeP(js),
    ParseGapOpen(js),
    ParseGapExtend(js),
    ParseScoringMatrixP(js),
    ParseThreshold(js),
    ParseCompBasedStatsP(js),
    ParseSubjectFile(js),
    ParseSubjectLocation(js),
    ParseSegP(js),
    ParseDBSoftMask(js),
    ParseDBHardMask(js),
    ParseCullingLimit(js),
    ParseXDropGap(js),
    ParseXDropGapFinal(js),
    ParseUngappedAlignmentsOnly(js),
    ParseNumCPUCores(js),
    ParseUseSWTBack(js),
    ParseBestHitOverhang(js),
    ParseBestHitScoreEdge(js),
    ParseSubjectBestHit(js),
    ParseSoftMaskingP(js),
  )

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    task.appendJson(js)
    wordSize.appendJson(js)
    gapOpen.appendJson(js)
    gapExtend.appendJson(js)
    matrix.appendJson(js)
    threshold.appendJson(js)
    compBasedStats.appendJson(js)
    subjectFile.appendJson(js)
    subjectLocation.appendJson(js)
    seg.appendJson(js)
    dbSoftMask.appendJson(js)
    dbHardMask.appendJson(js)
    cullingLimit.appendJson(js)
    extensionDropoffPrelimGapped.appendJson(js)
    extensionDropoffFinalGapped.appendJson(js)
    ungappedAlignmentsOnly.appendJson(js)
    numCPUCores.appendJson(js)
    useSmithWatermanTraceback.appendJson(js)
    bestHitOverhang.appendJson(js)
    bestHitScoreEdge.appendJson(js)
    subjectBestHit.appendJson(js)
    softMasking.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    task.appendCliSegment(sb)
    wordSize.appendCliSegment(sb)
    gapOpen.appendCliSegment(sb)
    gapExtend.appendCliSegment(sb)
    matrix.appendCliSegment(sb)
    threshold.appendCliSegment(sb)
    compBasedStats.appendCliSegment(sb)
    subjectFile.appendCliSegment(sb)
    subjectLocation.appendCliSegment(sb)
    seg.appendCliSegment(sb)
    dbSoftMask.appendCliSegment(sb)
    dbHardMask.appendCliSegment(sb)
    cullingLimit.appendCliSegment(sb)
    extensionDropoffPrelimGapped.appendCliSegment(sb)
    extensionDropoffFinalGapped.appendCliSegment(sb)
    ungappedAlignmentsOnly.appendCliSegment(sb)
    numCPUCores.appendCliSegment(sb)
    useSmithWatermanTraceback.appendCliSegment(sb)
    bestHitOverhang.appendCliSegment(sb)
    bestHitScoreEdge.appendCliSegment(sb)
    subjectBestHit.appendCliSegment(sb)
    softMasking.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    task.appendCliParts(cli)
    wordSize.appendCliParts(cli)
    gapOpen.appendCliParts(cli)
    gapExtend.appendCliParts(cli)
    matrix.appendCliParts(cli)
    threshold.appendCliParts(cli)
    compBasedStats.appendCliParts(cli)
    subjectFile.appendCliParts(cli)
    subjectLocation.appendCliParts(cli)
    seg.appendCliParts(cli)
    dbSoftMask.appendCliParts(cli)
    dbHardMask.appendCliParts(cli)
    cullingLimit.appendCliParts(cli)
    extensionDropoffPrelimGapped.appendCliParts(cli)
    extensionDropoffFinalGapped.appendCliParts(cli)
    ungappedAlignmentsOnly.appendCliParts(cli)
    numCPUCores.appendCliParts(cli)
    useSmithWatermanTraceback.appendCliParts(cli)
    bestHitOverhang.appendCliParts(cli)
    bestHitScoreEdge.appendCliParts(cli)
    subjectBestHit.appendCliParts(cli)
    softMasking.appendCliParts(cli)
  }

  override fun validate(errs: ErrorMap) {
    super.validate(errs)

    errs.incompatible(subjectFile, dbFile, giListFile, seqIDListFile,
      negativeGIListFile, negativeSeqIDListFile, taxIDs, taxIDListFile,
      negativeTaxIDs, negativeTaxIDListFile, ipgListFile, negativeIPGListFile,
      dbSoftMask, dbHardMask)
    errs.incompatible(subjectLocation, dbFile, giListFile, seqIDListFile,
      negativeGIListFile, negativeSeqIDListFile, taxIDs, taxIDListFile,
      negativeTaxIDs, negativeTaxIDListFile, ipgListFile, negativeIPGListFile,
      dbSoftMask, dbHardMask, remote)
    errs.incompatible(dbSoftMask, dbHardMask)
    errs.incompatible(cullingLimit, bestHitOverhang, bestHitScoreEdge)
    errs.incompatible(numCPUCores, remote)
  }
}