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
    private String corpBizNo;

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

        @JsonProperty("COMP_SUB_ID")
        private String compSubId;

        @JsonProperty("COMP_NAME")
        private String compName;

        @JsonProperty("COMP_REPRESENT")
        private String compRepresent;

        @JsonProperty("COMP_BIZ_STATE")
        private String compBizState;

        @JsonProperty("COMP_BIZ_CATEGORY")
        private String compBizCategory;

        @JsonProperty("COMP_ZIP_CODE")
        private String compZipCode;

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

        @JsonProperty("MEMBER_POST")
        private String memberPost;

        @JsonProperty("CUST_KIND")
        private String custKind;

        @JsonProperty("CUST_REGISTER_NO")
        private String custRegisterNo;

        @JsonProperty("CUST_SUB_ID")
        private String custSubId;

        @JsonProperty("CUST_NAME")
        private String custName;

        @JsonProperty("CUST_REPRESENT")
        private String custRepresent;

        @JsonProperty("CUST_BIZ_STATE")
        private String custBizState;

        @JsonProperty("CUST_BIZ_CATEGORY")
        private String custBizCategory;

        @JsonProperty("CUST_ZIP_CODE")
        private String custZipCode;

        @JsonProperty("CUST_ADDRESS1")
        private String custAddress1;

        @JsonProperty("CUST_ADDRESS2")
        private String custAddress2;

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

        @JsonProperty("MANAGER_POST")
        private String managerPost;

        @JsonProperty("MANAGER2_NM")
        private String manager2Nm;

        @JsonProperty("MANAGER2_TEL_NO1")
        private String manager2TelNo1;

        @JsonProperty("MANAGER2_TEL_NO2")
        private String manager2TelNo2;

        @JsonProperty("MANAGER2_TEL_NO3")
        private String manager2TelNo3;

        @JsonProperty("MANAGER2_EMAIL")
        private String manager2Email;

        @JsonProperty("MANAGER2_POST")
        private String manager2Post;

        @JsonProperty("BIGO")
        private String bigo;

        @JsonProperty("BOOK_NO1")
        private String bookNo1;

        @JsonProperty("BOOK_NO2")
        private String bookNo2;

        @JsonProperty("SERIAL_NO")
        private String serialNo;

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
