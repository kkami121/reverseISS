package com.myproject.itemlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaxInvoiceListResponse {

    @JsonProperty("errCode")
    private String errCode;

    @JsonProperty("errMsg")
    private String errMsg;

    @JsonProperty("result")
    private String result;

    @JsonProperty("data")
    private Data data;

    @Getter
    @Setter
    public static class Data {

        @JsonProperty("RTN")
        private String rtn;

        @JsonProperty("ERR_CODE")
        private String errCode;

        @JsonProperty("ERR_MSG")
        private String errMsg;

        @JsonProperty("ROW_CNT")
        private Integer rowCnt;

        @JsonProperty("ROW_REST_CNT")
        private Integer rowRestCnt;

        @JsonProperty("IS_NEXT")
        private String isNext;

        @JsonProperty("LIST")
        private List<TaxItem> list;
    }

    @Getter
    @Setter
    public static class TaxItem {

        @JsonProperty("HIST_ROW_KEY")
        private String histRowKey;

        @JsonProperty("CORP_BIZ_NO")
        private String corpBizNo;

        @JsonProperty("CATEGORY")
        private String category;

        @JsonProperty("CATEGORY_NM")
        private String categoryNm;

        @JsonProperty("DOC_TYPE")
        private String docType;

        @JsonProperty("DOC_TYPE_NM")
        private String docTypeNm;

        @JsonProperty("MAKE_DD")
        private String makeDd;

        @JsonProperty("ISSUE_DD")
        private String issueDd;

        @JsonProperty("SEND_DD")
        private String sendDd;

        @JsonProperty("APPR_NO")
        private String apprNo;

        @JsonProperty("AMT_TOT")
        private Long amtTot;

        @JsonProperty("AMT_SUPPLY")
        private Long amtSupply;

        @JsonProperty("AMT_TAX")
        private Long amtTax;

        @JsonProperty("ISSUE_TYPE")
        private String issueType;

        @JsonProperty("ISSUE_TYPE_NM")
        private String issueTypeNm;

        @JsonProperty("ISSUE_TYPE_DTL")
        private String issueTypeDtl;

        @JsonProperty("ISSUE_TYPE_DTL_NM")
        private String issueTypeDtlNm;

        @JsonProperty("ISSUE_CLASS")
        private String issueClass;

        @JsonProperty("ISSUE_CLASS_NM")
        private String issueClassNm;

        @JsonProperty("ISSUE_KIND")
        private String issueKind;

        @JsonProperty("ISSUE_KIND_NM")
        private String issueKindNm;

        @JsonProperty("REMARK1")
        private String remark1;

        @JsonProperty("COMP_BIZ_NO")
        private String compBizNo;

        @JsonProperty("COMP_SUB_NO")
        private String compSubNo;

        @JsonProperty("COMP_NM")
        private String compNm;

        @JsonProperty("COMP_CEO")
        private String compCeo;

        @JsonProperty("COMP_ADDR")
        private String compAddr;

        @JsonProperty("COMP_MNG_EMAIL")
        private String compMngEmail;

        @JsonProperty("CUST_BIZ_NO")
        private String custBizNo;

        @JsonProperty("CUST_SUB_NO")
        private String custSubNo;

        @JsonProperty("CUST_NM")
        private String custNm;

        @JsonProperty("CUST_CEO")
        private String custCeo;

        @JsonProperty("CUST_ADDR")
        private String custAddr;

        @JsonProperty("CUST_MNG_EMAIL")
        private String custMngEmail;

        @JsonProperty("CUST_MNG_SUB_EMAIL")
        private String custMngSubEmail;

        @JsonProperty("CONSIGN_BIZ_NO")
        private String consignBizNo;

        @JsonProperty("CONSIGN_NM")
        private String consignNm;

        @JsonProperty("ITEM_DD")
        private String itemDd;

        @JsonProperty("ITEM_NM")
        private String itemNm;

        @JsonProperty("ITEM_SPEC")
        private String itemSpec;

        @JsonProperty("ITEM_CNT")
        private Double itemCnt;

        @JsonProperty("ITEM_AMT_UNIT")
        private Long itemAmtUnit;

        @JsonProperty("ITEM_AMT_SUPPLY")
        private Long itemAmtSupply;

        @JsonProperty("ITEM_AMT_TAX")
        private Long itemAmtTax;

        @JsonProperty("ITEM_REMARK")
        private String itemRemark;

        @JsonProperty("INRP_TYPE")
        private String inrpType;

        @JsonProperty("INRP_SORT")
        private String inrpSort;

        @JsonProperty("INRP_DEPT_NAME")
        private String inrpDeptName;

        @JsonProperty("INRP_STAFF_NAME")
        private String inrpStaffName;

        @JsonProperty("INEP_TYPE")
        private String inepType;

        @JsonProperty("INEP_SORT")
        private String inepSort;

        @JsonProperty("INEP_1ST_DEPT_NAME")
        private String inep1stDeptName;

        @JsonProperty("INEP_1ST_STAF_NAME")
        private String inep1stStafName;

        @JsonProperty("BRRP_CEO_NAME")
        private String brrpCeoName;

        @JsonProperty("BRRP_ADDR")
        private String brrpAddr;

        @JsonProperty("BRRP_TYPE")
        private String brrpType;

        @JsonProperty("BRRP_SORT")
        private String brrpSort;

        @JsonProperty("BRRP_WORK_EMAIL")
        private String brrpWorkEmail;

        @JsonProperty("MOD_RESN_CD")
        private String modResnCd;

        @JsonProperty("ORI_ISSUE_ID")
        private String oriIssueId;

        @JsonProperty("BRRP_WORK_SUBID")
        private String brrpWorkSubid;

        @JsonProperty("BRRP_WORK_DEPT")
        private String brrpWorkDept;

        @JsonProperty("BRRP_WORK_TEL")
        private String brrpWorkTel;

        @JsonProperty("CORP_GUID")
        private String corpGuid;

        @JsonProperty("ITEM_LIST")
        private List<ItemDetail> itemList;
    }

    @Getter
    @Setter
    public static class ItemDetail {

        @JsonProperty("SEQ")
        private Integer seq;

        @JsonProperty("ITEM_DD")
        private String itemDd;

        @JsonProperty("ITEM_NM")
        private String itemNm;

        @JsonProperty("ITEM_SPEC")
        private String itemSpec;

        @JsonProperty("ITEM_CNT")
        private Double itemCnt;

        @JsonProperty("ITEM_AMT_UNIT")
        private Long itemAmtUnit;

        @JsonProperty("ITEM_AMT_SUPPLY")
        private Long itemAmtSupply;

        @JsonProperty("ITEM_AMT_TAX")
        private Long itemAmtTax;

        @JsonProperty("ITEM_REMARK")
        private String itemRemark;
    }
}
