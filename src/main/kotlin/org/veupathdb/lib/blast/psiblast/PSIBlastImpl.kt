package org.veupathdb.lib.blast.psiblast

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.common.BlastQueryWithIPGImpl
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.field.NegativeTaxIdList
import org.veupathdb.lib.blast.field.ParseNegTaxIdList
import org.veupathdb.lib.blast.psiblast.fields.*

internal class PSIBlastImpl(
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
  taxIdListFile:            TaxIdList                = TaxIdList(),
  negativeTaxIdListFile:    NegativeTaxIdList        = NegativeTaxIdList(),
  taxIds:                   TaxIDs                   = TaxIDs(),
  negativeTaxIds:           NegativeTaxIDs           = NegativeTaxIDs(),
  ipgListFile:              IPGList                  = IPGList(),
  negativeIPGListFile:      NegativeIPGList          = NegativeIPGList(),

  override var wordSize:                     WordSizePSI                  = WordSizePSI(),
  override var gapOpen:                      GapOpen                      = GapOpen(),
  override var gapExtend:                    GapExtend                    = GapExtend(),
  override var matrix:                       MatrixPSI                    = MatrixPSI(),
  override var threshold:                    Threshold                    = Threshold(),
  override var compBasedStats:               CompBasedStatsPSI            = CompBasedStatsPSI(),
  override var subjectFile:                  SubjectFile                  = SubjectFile(),
  override var subjectLocation:              SubjectLocation              = SubjectLocation(),
  override var seg:                          SegPSI                       = NoSeg,
  override var softMasking:                  SoftMaskingPSI               = SoftMaskingPSI(),
  override var queryCoverageHSPPercent:      QueryCoverageHSPPercent      = QueryCoverageHSPPercent(),
  override var cullingLimit:                 CullingLimit                 = CullingLimit(),
  override var bestHitOverhang:              BestHitOverhang              = BestHitOverhang(),
  override var bestHitScoreEdge:             BestHitScoreEdge             = BestHitScoreEdge(),
  override var subjectBestHit:               SubjectBestHit               = SubjectBestHit(),
  override var sumStats:                     SumStats                     = SumStats(),
  override var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped = ExtensionDropoffPrelimGapped(),
  override var extensionDropoffFinalGapped:  ExtensionDropoffFinalGapped  = ExtensionDropoffFinalGapped(),
  override var gapTrigger:                   GapTrigger                   = GapTrigger(),
  override var numCPUCores:                  NumCPUCores                  = NumCPUCores(),
  override var useSmithWatermanTraceback:    UseSmithWatermanTraceback    = UseSmithWatermanTraceback(),
  override var numIterations:                NumIterations                = NumIterations(),
  override var outPSSMFile:                  OutPSSMFile                  = OutPSSMFile(),
  override var outASCIIPSSMFile:             OutASCIIPSSMFile             = OutASCIIPSSMFile(),
  override var savePSSMAfterLastRound:       SavePSSMAfterLastRound       = SavePSSMAfterLastRound(),
  override var saveEachPSSM:                 SaveEachPSSM                 = SaveEachPSSM(),
  override var inMSAFile:                    InMSAFile                    = InMSAFile(),
  override var msaMasterIndex:               MSAMasterIndex               = MSAMasterIndex(),
  override var ignoreMSAMaster:              IgnoreMSAMaster              = IgnoreMSAMaster(),
  override var inPSSMFile:                   InPSSMFile                   = InPSSMFile(),
  override var pseudoCount:                  PseudoCount                  = PseudoCount(),
  override var inclusionEValueThreshold:     InclusionEValueThreshold     = InclusionEValueThreshold(),
  override var phiPatternFile:               PhiPatternFile               = PhiPatternFile(),
) : PSIBlast, BlastQueryWithIPGImpl(
  BlastTool.PSIBlast,
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
    ParseSeqIDList(js),
    ParseNegSeqIdList(js),
    ParseTaxIdList(js),
    ParseNegTaxIdList(js),
    ParseTaxIDs(js),
    ParseNegTaxIDs(js),
    ParseIPGList(js),
    ParseNegativeIPGList(js),
    ParseWordSizePSI(js),
    ParseGapOpen(js),
    ParseGapExtend(js),
    ParseMatrixPSI(js),
    ParseThreshold(js),
    ParseCompBasedStatsPSI(js),
    ParseSubjectFile(js),
    ParseSubjectLocation(js),
    ParseSegPSI(js),
    ParseSoftMaskingPSI(js),
    ParseQueryCoverageHSPPercent(js),
    ParseCullingLimit(js),
    ParseBestHitOverhang(js),
    ParseBestHitScoreEdge(js),
    ParseSubjectBestHit(js),
    ParseSumStats(js),
    ParseXDropGap(js),
    ParseXDropGapFinal(js),
    ParseGapTrigger(js),
    ParseNumCPUCores(js),
    ParseUseSWTBack(js),
    ParseNumIterations(js),
    ParseOutPSSMFile(js),
    ParseOutASCIIPSSMFile(js),
    ParseSavePSSMAfterLastRound(js),
    ParseSaveEachPSSM(js),
    ParseInMSA(js),
    ParseMSAMasterIndex(js),
    ParseIgnoreMSAMaster(js),
    ParseInPSSM(js),
    ParsePseudoCount(js),
    ParseInclusionEValueThreshold(js),
    ParsePhiPatternFile(js)
  )

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    wordSize.appendJson(js)
    gapOpen.appendJson(js)
    gapExtend.appendJson(js)
    matrix.appendJson(js)
    threshold.appendJson(js)
    compBasedStats.appendJson(js)
    subjectFile.appendJson(js)
    subjectLocation.appendJson(js)
    seg.appendJson(js)
    softMasking.appendJson(js)
    queryCoverageHSPPercent.appendJson(js)
    cullingLimit.appendJson(js)
    bestHitOverhang.appendJson(js)
    bestHitScoreEdge.appendJson(js)
    subjectBestHit.appendJson(js)
    sumStats.appendJson(js)
    extensionDropoffPrelimGapped.appendJson(js)
    extensionDropoffFinalGapped.appendJson(js)
    gapTrigger.appendJson(js)
    numCPUCores.appendJson(js)
    useSmithWatermanTraceback.appendJson(js)
    numIterations.appendJson(js)
    outPSSMFile.appendJson(js)
    outASCIIPSSMFile.appendJson(js)
    savePSSMAfterLastRound.appendJson(js)
    saveEachPSSM.appendJson(js)
    inMSAFile.appendJson(js)
    msaMasterIndex.appendJson(js)
    ignoreMSAMaster.appendJson(js)
    inPSSMFile.appendJson(js)
    pseudoCount.appendJson(js)
    inclusionEValueThreshold.appendJson(js)
    phiPatternFile.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    wordSize.appendCliSegment(sb)
    gapOpen.appendCliSegment(sb)
    gapExtend.appendCliSegment(sb)
    matrix.appendCliSegment(sb)
    threshold.appendCliSegment(sb)
    compBasedStats.appendCliSegment(sb)
    subjectFile.appendCliSegment(sb)
    subjectLocation.appendCliSegment(sb)
    seg.appendCliSegment(sb)
    softMasking.appendCliSegment(sb)
    queryCoverageHSPPercent.appendCliSegment(sb)
    cullingLimit.appendCliSegment(sb)
    bestHitOverhang.appendCliSegment(sb)
    bestHitScoreEdge.appendCliSegment(sb)
    subjectBestHit.appendCliSegment(sb)
    sumStats.appendCliSegment(sb)
    extensionDropoffPrelimGapped.appendCliSegment(sb)
    extensionDropoffFinalGapped.appendCliSegment(sb)
    gapTrigger.appendCliSegment(sb)
    numCPUCores.appendCliSegment(sb)
    useSmithWatermanTraceback.appendCliSegment(sb)
    numIterations.appendCliSegment(sb)
    outPSSMFile.appendCliSegment(sb)
    outASCIIPSSMFile.appendCliSegment(sb)
    savePSSMAfterLastRound.appendCliSegment(sb)
    saveEachPSSM.appendCliSegment(sb)
    inMSAFile.appendCliSegment(sb)
    msaMasterIndex.appendCliSegment(sb)
    ignoreMSAMaster.appendCliSegment(sb)
    inPSSMFile.appendCliSegment(sb)
    pseudoCount.appendCliSegment(sb)
    inclusionEValueThreshold.appendCliSegment(sb)
    phiPatternFile.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    wordSize.appendCliParts(cli)
    gapOpen.appendCliParts(cli)
    gapExtend.appendCliParts(cli)
    matrix.appendCliParts(cli)
    threshold.appendCliParts(cli)
    compBasedStats.appendCliParts(cli)
    subjectFile.appendCliParts(cli)
    subjectLocation.appendCliParts(cli)
    seg.appendCliParts(cli)
    softMasking.appendCliParts(cli)
    queryCoverageHSPPercent.appendCliParts(cli)
    cullingLimit.appendCliParts(cli)
    bestHitOverhang.appendCliParts(cli)
    bestHitScoreEdge.appendCliParts(cli)
    subjectBestHit.appendCliParts(cli)
    sumStats.appendCliParts(cli)
    extensionDropoffPrelimGapped.appendCliParts(cli)
    extensionDropoffFinalGapped.appendCliParts(cli)
    gapTrigger.appendCliParts(cli)
    numCPUCores.appendCliParts(cli)
    useSmithWatermanTraceback.appendCliParts(cli)
    numIterations.appendCliParts(cli)
    outPSSMFile.appendCliParts(cli)
    outASCIIPSSMFile.appendCliParts(cli)
    savePSSMAfterLastRound.appendCliParts(cli)
    saveEachPSSM.appendCliParts(cli)
    inMSAFile.appendCliParts(cli)
    msaMasterIndex.appendCliParts(cli)
    ignoreMSAMaster.appendCliParts(cli)
    inPSSMFile.appendCliParts(cli)
    pseudoCount.appendCliParts(cli)
    inclusionEValueThreshold.appendCliParts(cli)
    phiPatternFile.appendCliParts(cli)
  }
}