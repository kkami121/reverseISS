package com.myproject.itemlink.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaxInvoiceRequest {

    private String corpBizNo;

    // IT_HEADER
    private String erpUserMakeId;
    private String documentType;
    private String modReason;
    private String oriIssueId;
    private String targetLevel;
    private String taxType;
    private String makeDate;
    private String tranType;
    private String cashAmt;
    private String checkAmt;
    private String billAmt;
    private String uncollectAmt;
    private String taxAmt;
    private String supplyAmt;
    private String totalAmt;
    private String compRegisterNo;
    private String compSubId;
    private String compName;
    private String compRepresent;
    private String compBizState;
    private String compBizCategory;
    private String compZipCode;
    private String compAddress1;
    private String compAddress2;
    private String memberNm;
    private String memberTelNo1;
    private String memberTelNo2;
    private String memberTelNo3;
    private String memberEmail;
    private String memberPost;
    private String custKind;
    private String custRegisterNo;
    private String custSubId;
    private String custName;
    private String custRepresent;
    private String custBizState;
    private String custBizCategory;
    private String custZipCode;
    private String custAddress1;
    private String custAddress2;
    private String managerNm;
    private String managerTelNo1;
    private String managerTelNo2;
    private String managerTelNo3;
    private String managerEmail;
    private String managerPost;
    private String manager2Nm;
    private String manager2TelNo1;
    private String manager2TelNo2;
    private String manager2TelNo3;
    private String manager2Email;
    private String manager2Post;
    private String bigo;
    private String bookNo1;
    private String bookNo2;
    private String serialNo;
    private String smsGb;

    // IT_ITEMLIST
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
