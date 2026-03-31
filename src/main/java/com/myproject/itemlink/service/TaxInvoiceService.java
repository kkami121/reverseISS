package com.myproject.itemlink.service;

import com.myproject.itemlink.dto.KaccountingRequest;
import com.myproject.itemlink.dto.KaccountingResponse;
import com.myproject.itemlink.dto.TaxInvoiceRequest;
import com.myproject.itemlink.entity.TaxInvoiceDetail;
import com.myproject.itemlink.entity.TaxInvoiceMaster;
import com.myproject.itemlink.repository.TaxInvoiceMasterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaxInvoiceService {

    private final RestClient kaccountingRestClient;
    private final TaxInvoiceMasterRepository masterRepository;

    public KaccountingResponse issue(TaxInvoiceRequest req) {
        KaccountingRequest body = buildRequest(req);

        KaccountingResponse response = kaccountingRestClient.post()
                .uri("/EXTERNAL/TAX/RegIssueTaxInvoice")
                .body(body)
                .retrieve()
                .body(KaccountingResponse.class);

        save(req, response);
        return response;
    }

    private KaccountingRequest buildRequest(TaxInvoiceRequest req) {
        KaccountingRequest request = new KaccountingRequest();
        request.setCorpBizNo(req.getCorpBizNo());

        KaccountingRequest.ItHeader header = new KaccountingRequest.ItHeader();
        header.setErpUserMakeId(req.getErpUserMakeId());
        header.setDocumentType(req.getDocumentType());
        header.setModReason(req.getModReason());
        header.setOriIssueId(req.getOriIssueId());
        header.setTargetLevel(req.getTargetLevel());
        header.setTaxType(req.getTaxType());
        header.setMakeDate(req.getMakeDate());
        header.setTranType(req.getTranType());
        header.setCashAmt(req.getCashAmt());
        header.setCheckAmt(req.getCheckAmt());
        header.setBillAmt(req.getBillAmt());
        header.setUncollectAmt(req.getUncollectAmt());
        header.setTaxAmt(req.getTaxAmt());
        header.setSupplyAmt(req.getSupplyAmt());
        header.setTotalAmt(req.getTotalAmt());
        header.setCompRegisterNo(req.getCompRegisterNo());
        header.setCompSubId(req.getCompSubId());
        header.setCompName(req.getCompName());
        header.setCompRepresent(req.getCompRepresent());
        header.setCompBizState(req.getCompBizState());
        header.setCompBizCategory(req.getCompBizCategory());
        header.setCompZipCode(req.getCompZipCode());
        header.setCompAddress1(req.getCompAddress1());
        header.setCompAddress2(req.getCompAddress2());
        header.setMemberNm(req.getMemberNm());
        header.setMemberTelNo1(req.getMemberTelNo1());
        header.setMemberTelNo2(req.getMemberTelNo2());
        header.setMemberTelNo3(req.getMemberTelNo3());
        header.setMemberEmail(req.getMemberEmail());
        header.setMemberPost(req.getMemberPost());
        header.setCustKind(req.getCustKind());
        header.setCustRegisterNo(req.getCustRegisterNo());
        header.setCustSubId(req.getCustSubId());
        header.setCustName(req.getCustName());
        header.setCustRepresent(req.getCustRepresent());
        header.setCustBizState(req.getCustBizState());
        header.setCustBizCategory(req.getCustBizCategory());
        header.setCustZipCode(req.getCustZipCode());
        header.setCustAddress1(req.getCustAddress1());
        header.setCustAddress2(req.getCustAddress2());
        header.setManagerNm(req.getManagerNm());
        header.setManagerTelNo1(req.getManagerTelNo1());
        header.setManagerTelNo2(req.getManagerTelNo2());
        header.setManagerTelNo3(req.getManagerTelNo3());
        header.setManagerEmail(req.getManagerEmail());
        header.setManagerPost(req.getManagerPost());
        header.setManager2Nm(req.getManager2Nm());
        header.setManager2TelNo1(req.getManager2TelNo1());
        header.setManager2TelNo2(req.getManager2TelNo2());
        header.setManager2TelNo3(req.getManager2TelNo3());
        header.setManager2Email(req.getManager2Email());
        header.setManager2Post(req.getManager2Post());
        header.setBigo(req.getBigo());
        header.setBookNo1(req.getBookNo1());
        header.setBookNo2(req.getBookNo2());
        header.setSerialNo(req.getSerialNo());
        header.setSmsGb(req.getSmsGb());
        request.setItHeader(List.of(header));

        if (req.getItems() != null) {
            List<KaccountingRequest.ItItem> itemList = req.getItems().stream().map(i -> {
                KaccountingRequest.ItItem item = new KaccountingRequest.ItItem();
                item.setErpUserMakeId(i.getErpUserMakeId());
                item.setDetailNo(i.getDetailNo());
                item.setYear(i.getYear());
                item.setMonth(i.getMonth());
                item.setDay(i.getDay());
                item.setArticleNm(i.getArticleNm());
                item.setStandard(i.getStandard());
                item.setQuantity(i.getQuantity());
                item.setUnitAmt(i.getUnitAmt());
                item.setSupplyAmt(i.getSupplyAmt());
                item.setTaxAmt(i.getTaxAmt());
                item.setBigo(i.getBigo());
                return item;
            }).toList();
            request.setItItemList(itemList);
        }

        return request;
    }

    private void save(TaxInvoiceRequest req, KaccountingResponse response) {
        TaxInvoiceMaster master = new TaxInvoiceMaster();

        // 기본
        master.setCorpBizNo(req.getCorpBizNo());
        master.setErpUserMakeId(req.getErpUserMakeId());
        master.setDocumentType(req.getDocumentType());
        master.setModReason(req.getModReason());
        master.setOriIssueId(req.getOriIssueId());
        master.setTargetLevel(req.getTargetLevel());
        master.setTaxType(req.getTaxType());
        master.setMakeDate(req.getMakeDate());
        master.setTranType(req.getTranType());

        // 금액
        master.setCashAmt(req.getCashAmt());
        master.setCheckAmt(req.getCheckAmt());
        master.setBillAmt(req.getBillAmt());
        master.setUncollectAmt(req.getUncollectAmt());
        master.setTaxAmt(req.getTaxAmt());
        master.setSupplyAmt(req.getSupplyAmt());
        master.setTotalAmt(req.getTotalAmt());

        // 공급자
        master.setCompRegisterNo(req.getCompRegisterNo());
        master.setCompSubId(req.getCompSubId());
        master.setCompName(req.getCompName());
        master.setCompRepresent(req.getCompRepresent());
        master.setCompBizState(req.getCompBizState());
        master.setCompBizCategory(req.getCompBizCategory());
        master.setCompZipCode(req.getCompZipCode());
        master.setCompAddress1(req.getCompAddress1());
        master.setCompAddress2(req.getCompAddress2());

        // 담당자 (공급자측)
        master.setMemberNm(req.getMemberNm());
        master.setMemberTelNo1(req.getMemberTelNo1());
        master.setMemberTelNo2(req.getMemberTelNo2());
        master.setMemberTelNo3(req.getMemberTelNo3());
        master.setMemberEmail(req.getMemberEmail());
        master.setMemberPost(req.getMemberPost());

        // 공급받는자
        master.setCustKind(req.getCustKind());
        master.setCustRegisterNo(req.getCustRegisterNo());
        master.setCustSubId(req.getCustSubId());
        master.setCustName(req.getCustName());
        master.setCustRepresent(req.getCustRepresent());
        master.setCustBizState(req.getCustBizState());
        master.setCustBizCategory(req.getCustBizCategory());
        master.setCustZipCode(req.getCustZipCode());
        master.setCustAddress1(req.getCustAddress1());
        master.setCustAddress2(req.getCustAddress2());

        // 수신담당자1
        master.setManagerNm(req.getManagerNm());
        master.setManagerTelNo1(req.getManagerTelNo1());
        master.setManagerTelNo2(req.getManagerTelNo2());
        master.setManagerTelNo3(req.getManagerTelNo3());
        master.setManagerEmail(req.getManagerEmail());
        master.setManagerPost(req.getManagerPost());

        // 수신담당자2
        master.setManager2Nm(req.getManager2Nm());
        master.setManager2TelNo1(req.getManager2TelNo1());
        master.setManager2TelNo2(req.getManager2TelNo2());
        master.setManager2TelNo3(req.getManager2TelNo3());
        master.setManager2Email(req.getManager2Email());
        master.setManager2Post(req.getManager2Post());

        // 기타
        master.setBigo(req.getBigo());
        master.setBookNo1(req.getBookNo1());
        master.setBookNo2(req.getBookNo2());
        master.setSerialNo(req.getSerialNo());
        master.setSmsGb(req.getSmsGb());

        // 발행 결과
        if (response != null) {
            master.setStatus(response.getResult());
            master.setErrCode(response.getErrCode());
            master.setErrMsg(response.getErrMsg());
            if (response.getData() != null) {
                master.setRtn(response.getData().getRtn());
            }
        } else {
            master.setStatus("FAIL");
        }

        // IT_ITEMLIST → detail
        if (req.getItems() != null) {
            req.getItems().forEach(i -> {
                TaxInvoiceDetail detail = new TaxInvoiceDetail();
                detail.setMaster(master);
                detail.setErpUserMakeId(i.getErpUserMakeId());
                detail.setDetailNo(i.getDetailNo());
                detail.setYear(i.getYear());
                detail.setMonth(i.getMonth());
                detail.setDay(i.getDay());
                detail.setArticleNm(i.getArticleNm());
                detail.setStandard(i.getStandard());
                detail.setQuantity(i.getQuantity());
                detail.setUnitAmt(i.getUnitAmt());
                detail.setSupplyAmt(i.getSupplyAmt());
                detail.setTaxAmt(i.getTaxAmt());
                detail.setBigo(i.getBigo());
                master.getDetails().add(detail);
            });
        }

        masterRepository.save(master);
    }
}
