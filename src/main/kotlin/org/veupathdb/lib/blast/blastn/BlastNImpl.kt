package org.veupathdb.lib.blast.blastn

import com.fasterxml.jackson.databind.node.ObjectNode
import org.veupathdb.lib.blast.BlastTool
import org.veupathdb.lib.blast.blastn.fields.*
import org.veupathdb.lib.blast.common.BlastQueryWithListsImpl
import org.veupathdb.lib.blast.common.fields.*
import org.veupathdb.lib.blast.err.ErrorMap
import org.veupathdb.lib.blast.tblastn.fields.TBlastNTaskValue

internal class BlastNImpl(
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
  giList:                   GIList                   = GIList(),
  negativeGIList:           NegativeGIList           = NegativeGIList(),
  seqIdList:                SeqIDList                = SeqIDList(),
  negativeSeqIdList:        NegativeSeqIDList        = NegativeSeqIDList(),
  taxIdList:                TaxIDList                = TaxIDList(),
  negativeTaxIdList:        NegativeTaxIDList        = NegativeTaxIDList(),
  taxIds:                   TaxIDs                   = TaxIDs(),
  negativeTaxIds:           NegativeTaxIDs           = NegativeTaxIDs(),

  override var strand:                       Strand                       = Strand(),
  override var task:                         BlastNTask                   = BlastNTask(),
  override var gapOpen:                      GapOpen                      = GapOpen(),
  override var gapExtend:                    GapExtend                    = GapExtend(),
  override var penalty:                      Penalty                      = Penalty(),
  override var reward:                       Reward                       = Reward(),
  override var useIndex:                     UseIndex                     = UseIndex(),
  override var indexName:                    IndexName                    = IndexName(),
  override var subjectFile:                  SubjectFile                  = SubjectFile(),
  override var subjectLocation:              SubjectLocation              = SubjectLocation(),
  override var dust:                         Dust                         = ValDust(),
  override var filteringDBFile:              FilteringDB                  = FilteringDB(),
  override var windowMaskerTaxID:            WindowMaskerTaxID            = WindowMaskerTaxID(),
  override var windowMaskerDBFile:           WindowMaskerDB               = WindowMaskerDB(),
  override var dbSoftMask:                   DBSoftMask                   = DBSoftMask(),
  override var dbHardMask:                   DBHardMask                   = DBHardMask(),
  override var percentIdentity:              PercentIdentity              = PercentIdentity(),
  override var cullingLimit:                 CullingLimit                 = CullingLimit(),
  override var templateType:                 TemplateType                 = TemplateType(),
  override var templateLength:               TemplateLength               = TemplateLength(),
  override var sumStats:                     SumStats                     = SumStats(),
  override var extensionDropoffPrelimGapped: ExtensionDropoffPrelimGapped = ExtensionDropoffPrelimGapped(),
  override var extensionDropoffFinalGapped:  ExtensionDropoffFinalGapped  = ExtensionDropoffFinalGapped(),
  override var nonGreedy:                    NonGreedy                    = NonGreedy(),
  override var minRawGappedScore:            MinRawGappedScore            = MinRawGappedScore(),
  override var ungappedAlignmentsOnly:       UngappedAlignmentsOnly       = UngappedAlignmentsOnly(),
  override var offDiagonalRange:             OffDiagonalRange             = OffDiagonalRange(),
  override var numCPUCores:                  NumCPUCores                  = NumCPUCores(),
  override var bestHitOverhang:              BestHitOverhang              = BestHitOverhang(),
  override var bestHitScoreEdge:             BestHitScoreEdge             = BestHitScoreEdge(),
  override var subjectBestHit:               SubjectBestHit               = SubjectBestHit(),
  override var softMasking:                  SoftMaskingN                 = SoftMaskingN()
) : BlastN, BlastQueryWithListsImpl(
  BlastTool.BlastN,
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
  giList,
  negativeGIList,
  seqIdList,
  negativeSeqIdList,
  taxIdList,
  negativeTaxIdList,
  taxIds,
  negativeTaxIds,
) {
  constructor(js: ObjectNode) : this(
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
    ParseStrand(js),
    ParseBlastNTask(js),
    ParseGapOpen(js),
    ParseGapExtend(js),
    ParsePenalty(js),
    ParseReward(js),
    ParseUseIndex(js),
    ParseIndexName(js),
    ParseSubjectFile(js),
    ParseSubjectLocation(js),
    ParseDust(js),
    ParseFilteringDB(js),
    ParseWindowMaskerTaxID(js),
    ParseWindowMaskerDB(js),
    ParseDBSoftMask(js),
    ParseDBHardMask(js),
    ParsePercentIdentity(js),
    ParseCullingLimit(js),
    ParseTemplateType(js),
    ParseTemplateLength(js),
    ParseSumStats(js),
    ParseXDropGap(js),
    ParseXDropGapFinal(js),
    ParseNonGreedy(js),
    ParseMinRawGappedScore(js),
    ParseUngappedAlignmentsOnly(js),
    ParseOffDiagonalRange(js),
    ParseNumCPUCores(js),
    ParseBestHitOverhang(js),
    ParseBestHitScoreEdge(js),
    ParseSubjectBestHit(js),
    ParseSoftMaskingN(js),
  )

  override fun appendJson(js: ObjectNode) {
    super.appendJson(js)

    strand.appendJson(js)
    task.appendJson(js)
    gapOpen.appendJson(js)
    gapExtend.appendJson(js)
    penalty.appendJson(js)
    reward.appendJson(js)
    useIndex.appendJson(js)
    indexName.appendJson(js)
    subjectFile.appendJson(js)
    subjectLocation.appendJson(js)
    dust.appendJson(js)
    filteringDBFile.appendJson(js)
    windowMaskerTaxID.appendJson(js)
    windowMaskerDBFile.appendJson(js)
    dbSoftMask.appendJson(js)
    dbHardMask.appendJson(js)
    percentIdentity.appendJson(js)
    cullingLimit.appendJson(js)
    templateType.appendJson(js)
    templateLength.appendJson(js)
    sumStats.appendJson(js)
    extensionDropoffPrelimGapped.appendJson(js)
    extensionDropoffFinalGapped.appendJson(js)
    nonGreedy.appendJson(js)
    minRawGappedScore.appendJson(js)
    ungappedAlignmentsOnly.appendJson(js)
    offDiagonalRange.appendJson(js)
    numCPUCores.appendJson(js)
    bestHitOverhang.appendJson(js)
    bestHitScoreEdge.appendJson(js)
    subjectBestHit.appendJson(js)
    softMasking.appendJson(js)
  }

  override fun appendCli(sb: StringBuilder) {
    super.appendCli(sb)

    strand.appendCliSegment(sb)
    task.appendCliSegment(sb)
    gapOpen.appendCliSegment(sb)
    gapExtend.appendCliSegment(sb)
    penalty.appendCliSegment(sb)
    reward.appendCliSegment(sb)
    useIndex.appendCliSegment(sb)
    indexName.appendCliSegment(sb)
    subjectFile.appendCliSegment(sb)
    subjectLocation.appendCliSegment(sb)
    dust.appendCliSegment(sb)
    filteringDBFile.appendCliSegment(sb)
    windowMaskerTaxID.appendCliSegment(sb)
    windowMaskerDBFile.appendCliSegment(sb)
    dbSoftMask.appendCliSegment(sb)
    dbHardMask.appendCliSegment(sb)
    percentIdentity.appendCliSegment(sb)
    cullingLimit.appendCliSegment(sb)
    templateType.appendCliSegment(sb)
    templateLength.appendCliSegment(sb)
    sumStats.appendCliSegment(sb)
    extensionDropoffPrelimGapped.appendCliSegment(sb)
    extensionDropoffFinalGapped.appendCliSegment(sb)
    nonGreedy.appendCliSegment(sb)
    minRawGappedScore.appendCliSegment(sb)
    ungappedAlignmentsOnly.appendCliSegment(sb)
    offDiagonalRange.appendCliSegment(sb)
    numCPUCores.appendCliSegment(sb)
    bestHitOverhang.appendCliSegment(sb)
    bestHitScoreEdge.appendCliSegment(sb)
    subjectBestHit.appendCliSegment(sb)
    softMasking.appendCliSegment(sb)
  }

  override fun appendCli(cli: MutableList<String>) {
    super.appendCli(cli)

    strand.appendCliParts(cli)
    task.appendCliParts(cli)
    gapOpen.appendCliParts(cli)
    gapExtend.appendCliParts(cli)
    penalty.appendCliParts(cli)
    reward.appendCliParts(cli)
    useIndex.appendCliParts(cli)
    indexName.appendCliParts(cli)
    subjectFile.appendCliParts(cli)
    subjectLocation.appendCliParts(cli)
    dust.appendCliParts(cli)
    filteringDBFile.appendCliParts(cli)
    windowMaskerTaxID.appendCliParts(cli)
    windowMaskerDBFile.appendCliParts(cli)
    dbSoftMask.appendCliParts(cli)
    dbHardMask.appendCliParts(cli)
    percentIdentity.appendCliParts(cli)
    cullingLimit.appendCliParts(cli)
    templateType.appendCliParts(cli)
    templateLength.appendCliParts(cli)
    sumStats.appendCliParts(cli)
    extensionDropoffPrelimGapped.appendCliParts(cli)
    extensionDropoffFinalGapped.appendCliParts(cli)
    nonGreedy.appendCliParts(cli)
    minRawGappedScore.appendCliParts(cli)
    ungappedAlignmentsOnly.appendCliParts(cli)
    offDiagonalRange.appendCliParts(cli)
    numCPUCores.appendCliParts(cli)
    bestHitOverhang.appendCliParts(cli)
    bestHitScoreEdge.appendCliParts(cli)
    subjectBestHit.appendCliParts(cli)
    softMasking.appendCliParts(cli)
  }

  override fun validate(errs: ErrorMap) {
    super.validate(errs)

    if (task.value != BlastNTaskType.Megablast) {
      if (!useIndex.isDefault)
        errs.addError(useIndex.name, "Requires task type ${BlastNTaskType.Megablast.value}")
      if (!indexName.isDefault)
        errs.addError(indexName.name, "Requires task type ${BlastNTaskType.Megablast.value}")
    }

    if (task.value != BlastNTaskType.DiscontiguousMegablast) {
      if (!templateType.isDefault)
        errs.addError(templateType.name, "Requires task type ${BlastNTaskType.DiscontiguousMegablast.value}")
      if (!templateLength.isDefault)
        errs.addError(templateLength.name, "Requires task type ${BlastNTaskType.DiscontiguousMegablast.value}")
    }

    errs.incompatible(subjectFile, dbFile, giListFile, seqIDListFile,
      negativeGIListFile, negativeSeqIDListFile, taxIDs, taxIDListFile,
      negativeTaxIDs, negativeTaxIDListFile, dbSoftMask, dbHardMask)
    errs.incompatible(subjectLocation, dbFile, giListFile, seqIDListFile,
      negativeGIListFile, negativeSeqIDListFile, taxIDs, taxIDListFile,
      negativeTaxIDs, negativeTaxIDListFile, dbSoftMask, dbHardMask, remote)
    errs.incompatible(dbSoftMask, dbHardMask)
    errs.incompatible(cullingLimit, bestHitOverhang, bestHitScoreEdge)
    errs.incompatible(numCPUCores, remote)
  }
}
