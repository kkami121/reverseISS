package com.myproject.itemlink.service;

import com.myproject.itemlink.dto.KaccountingRequest;
import com.myproject.itemlink.dto.KaccountingResponse;
import com.myproject.itemlink.dto.TaxInvoiceListRequest;
import com.myproject.itemlink.dto.TaxInvoiceListResponse;
import com.myproject.itemlink.dto.TaxInvoiceRequest;
import com.myproject.itemlink.dto.TaxInvoiceStateRequest;
import com.myproject.itemlink.dto.TaxInvoiceStateResponse;
import com.myproject.itemlink.entity.TaxInvoiceDetail;
import com.myproject.itemlink.entity.TaxInvoiceMaster;
import com.myproject.itemlink.repository.TaxInvoiceDetailMapper;
import com.myproject.itemlink.repository.TaxInvoiceMasterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaxInvoiceService {

    private final RestClient kaccountingRestClient;
    private final TaxInvoiceMasterMapper masterMapper;
    private final TaxInvoiceDetailMapper detailMapper;

    public TaxInvoiceStateResponse state(TaxInvoiceStateRequest req) {
        return kaccountingRestClient.post()
                .uri("/EXTERNAL/TAX/GetIssueStateTaxInvoice")
                .body(req)
                .retrieve()
                .body(TaxInvoiceStateResponse.class);
    }

    public TaxInvoiceListResponse list(TaxInvoiceListRequest req) {
        return kaccountingRestClient.post()
                .uri("/API/HTX/GetHtxTaxListSync")
                .body(req)
                .retrieve()
                .body(TaxInvoiceListResponse.class);
    }

    @Transactional
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
        header.setCompName(req.getCompName());
        header.setCompRepresent(req.getCompRepresent());
        header.setCompAddress1(req.getCompAddress1());
        header.setCompAddress2(req.getCompAddress2());
        header.setMemberNm(req.getMemberNm());
        header.setMemberTelNo1(req.getMemberTelNo1());
        header.setMemberTelNo2(req.getMemberTelNo2());
        header.setMemberTelNo3(req.getMemberTelNo3());
        header.setMemberEmail(req.getMemberEmail());
        header.setCustRegisterNo(req.getCustRegisterNo());
        header.setCustName(req.getCustName());
        header.setCustRepresent(req.getCustRepresent());
        header.setCustZipCode(req.getCustZipCode());
        header.setCustAddress1(req.getCustAddress1());
        header.setManagerNm(req.getManagerNm());
        header.setManagerTelNo1(req.getManagerTelNo1());
        header.setManagerTelNo2(req.getManagerTelNo2());
        header.setManagerTelNo3(req.getManagerTelNo3());
        header.setManagerEmail(req.getManagerEmail());
        header.setBigo(req.getBigo());
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

        master.setErpUserMakeId(req.getErpUserMakeId());
        master.setDocumentType(req.getDocumentType());
        master.setModReason(req.getModReason());
        master.setOriIssueId(req.getOriIssueId());
        master.setTargetLevel(req.getTargetLevel());
        master.setTaxType(req.getTaxType());
        master.setMakeDate(req.getMakeDate());
        master.setTranType(req.getTranType());
        master.setCashAmt(req.getCashAmt());
        master.setCheckAmt(req.getCheckAmt());
        master.setBillAmt(req.getBillAmt());
        master.setUncollectAmt(req.getUncollectAmt());
        master.setTaxAmt(req.getTaxAmt());
        master.setSupplyAmt(req.getSupplyAmt());
        master.setTotalAmt(req.getTotalAmt());
        master.setCompRegisterNo(req.getCompRegisterNo());
        master.setCompName(req.getCompName());
        master.setCompRepresent(req.getCompRepresent());
        master.setCompAddress1(req.getCompAddress1());
        master.setCompAddress2(req.getCompAddress2());
        master.setMemberNm(req.getMemberNm());
        master.setMemberTelNo1(req.getMemberTelNo1());
        master.setMemberTelNo2(req.getMemberTelNo2());
        master.setMemberTelNo3(req.getMemberTelNo3());
        master.setMemberEmail(req.getMemberEmail());
        master.setCustRegisterNo(req.getCustRegisterNo());
        master.setCustName(req.getCustName());
        master.setCustRepresent(req.getCustRepresent());
        master.setCustZipCode(req.getCustZipCode());
        master.setCustAddress1(req.getCustAddress1());
        master.setManagerNm(req.getManagerNm());
        master.setManagerTelNo1(req.getManagerTelNo1());
        master.setManagerTelNo2(req.getManagerTelNo2());
        master.setManagerTelNo3(req.getManagerTelNo3());
        master.setManagerEmail(req.getManagerEmail());
        master.setBigo(req.getBigo());
        master.setSmsGb(req.getSmsGb());
        master.setCreatedAt(LocalDateTime.now());

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

        masterMapper.insert(master);

        if (req.getItems() != null) {
            for (TaxInvoiceRequest.Item i : req.getItems()) {
                TaxInvoiceDetail detail = new TaxInvoiceDetail();
                detail.setMasterId(master.getId());
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
                detailMapper.insert(detail);
            }
        }
    }
}
