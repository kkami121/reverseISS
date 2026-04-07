package com.myproject.itemlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KaccountingRequest {

    @JsonProperty("CHANNEL")
    private String channel = "SHINWON";

    @JsonProperty("CORP_BIZ_NO")
    private String corpBizNo = "1058111908";

    @JsonProperty("IT_HEADER")
    private List<ItHeader> itHeader;

    @JsonProperty("IT_ITEMLIST")
    private List<ItItem> itItemList;

    @Getter
    @Setter
    public static class ItHeader {

        @JsonProperty("ERP_USER_MAKE_ID")
        private String erpUserMakeId;

        @JsonProperty("DOCUMENT_TYPE")
        private String documentType;

        @JsonProperty("MOD_REASON")
        private String modReason;

        @JsonProperty("ORI_ISSUE_ID")
        private String oriIssueId;

        @JsonProperty("TARGET_LEVEL")
        private String targetLevel;

        @JsonProperty("TAX_TYPE")
        private String taxType;

        @JsonProperty("MAKE_DATE")
        private String makeDate;

        @JsonProperty("TRAN_TYPE")
        private String tranType;

        @JsonProperty("CASH_AMT")
        private String cashAmt;

        @JsonProperty("CHECK_AMT")
        private String checkAmt;

        @JsonProperty("BILL_AMT")
        private String billAmt;

        @JsonProperty("UNCOLLECT_AMT")
        private String uncollectAmt;

        @JsonProperty("TAX_AMT")
        private String taxAmt;

        @JsonProperty("SUPPLY_AMT")
        private String supplyAmt;

        @JsonProperty("TOTAL_AMT")
        private String totalAmt;

        @JsonProperty("COMP_REGISTER_NO")
        private String compRegisterNo;

        @JsonProperty("COMP_NAME")
        private String compName;

        @JsonProperty("COMP_REPRESENT")
        private String compRepresent;

        @JsonProperty("COMP_ADDRESS1")
        private String compAddress1;

        @JsonProperty("COMP_ADDRESS2")
        private String compAddress2;

        @JsonProperty("MEMBER_NM")
        private String memberNm;

        @JsonProperty("MEMBER_TEL_NO1")
        private String memberTelNo1;

        @JsonProperty("MEMBER_TEL_NO2")
        private String memberTelNo2;

        @JsonProperty("MEMBER_TEL_NO3")
        private String memberTelNo3;

        @JsonProperty("MEMBER_EMAIL")
        private String memberEmail;

        @JsonProperty("CUST_REGISTER_NO")
        private String custRegisterNo;

        @JsonProperty("CUST_NAME")
        private String custName;

        @JsonProperty("CUST_REPRESENT")
        private String custRepresent;

        @JsonProperty("CUST_ZIP_CODE")
        private String custZipCode;

        @JsonProperty("CUST_ADDRESS1")
        private String custAddress1;

        @JsonProperty("MANAGER_NM")
        private String managerNm;

        @JsonProperty("MANAGER_TEL_NO1")
        private String managerTelNo1;

        @JsonProperty("MANAGER_TEL_NO2")
        private String managerTelNo2;

        @JsonProperty("MANAGER_TEL_NO3")
        private String managerTelNo3;

        @JsonProperty("MANAGER_EMAIL")
        private String managerEmail;

        @JsonProperty("BIGO")
        private String bigo;

        @JsonProperty("SMS_GB")
        private String smsGb;
    }

    @Getter
    @Setter
    public static class ItItem {

        @JsonProperty("ERP_USER_MAKE_ID")
        private String erpUserMakeId;

        @JsonProperty("DETAIL_NO")
        private String detailNo;

        @JsonProperty("YEAR")
        private String year;

        @JsonProperty("MONTH")
        private String month;

        @JsonProperty("DAY")
        private String day;

        @JsonProperty("ARTICLE_NM")
        private String articleNm;

        @JsonProperty("STANDARD")
        private String standard;

        @JsonProperty("QUANTITY")
        private String quantity;

        @JsonProperty("UNIT_AMT")
        private String unitAmt;

        @JsonProperty("SUPPLY_AMT")
        private String supplyAmt;

        @JsonProperty("TAX_AMT")
        private String taxAmt;

        @JsonProperty("BIGO")
        private String bigo;
    }
}
