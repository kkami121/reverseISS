package com.myproject.itemlink.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaxInvoiceRequest {

    private String erpUserMakeId;
    private String documentType;
    private String modReason;
    private String oriIssueId;
    private String targetLevel;
    private String taxType;
    private String makeDate;
    private String tranType;

    // 금액
    private String cashAmt;
    private String checkAmt;
    private String billAmt;
    private String uncollectAmt;
    private String taxAmt;
    private String supplyAmt;
    private String totalAmt;

    // 공급처
    private String compRegisterNo;
    private String compName;
    private String compRepresent;
    private String compAddress1;
    private String compAddress2;

    // 공급 담당자
    private String memberNm;
    private String memberTelNo1;
    private String memberTelNo2;
    private String memberTelNo3;
    private String memberEmail;

    // 매입처
    private String custRegisterNo;
    private String custName;
    private String custRepresent;
    private String custZipCode;
    private String custAddress1;

    // 매입 담당자
    private String managerNm;
    private String managerTelNo1;
    private String managerTelNo2;
    private String managerTelNo3;
    private String managerEmail;

    private String bigo;
    private String smsGb;

    private List<Item> items;

    @Getter
    @Setter
    public static class Item {
        private String erpUserMakeId;
        private String detailNo;
        private String year;
        private String month;
        private String day;
        private String articleNm;
        private String standard;
        private String quantity;
        private String unitAmt;
        private String supplyAmt;
        private String taxAmt;
        private String bigo;
    }
}
