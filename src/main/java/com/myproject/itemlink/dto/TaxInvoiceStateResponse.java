package com.myproject.itemlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TaxInvoiceStateResponse {

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

        @JsonProperty("TOTCNT")
        private Integer totCnt;

        @JsonProperty("LIST")
        private List<StateItem> list;
    }

    @Getter
    @Setter
    public static class StateItem {

        @JsonProperty("ERP_USER_MAKE_ID")
        private String erpUserMakeId;

        @JsonProperty("MAKE_ID")
        private String makeId;

        @JsonProperty("ISSUE_ID")
        private String issueId;

        @JsonProperty("DOC_STATE")
        private String docState;

        @JsonProperty("DOC_ST_DATE")
        private String docStDate;

        @JsonProperty("DOC_STATE_DATE")
        private String docStateDate;

        @JsonProperty("RESULT_CODE")
        private String resultCode;

        @JsonProperty("DEL_FLAG")
        private String delFlag;

        @JsonProperty("ISSUE_DATE")
        private String issueDate;

        @JsonProperty("CONF_DATE")
        private String confDate;

        @JsonProperty("ECCT_RESULT_CODE")
        private String ecctResultCode;

        @JsonProperty("ECCT_RESEND_DATE")
        private String ecctResendDate;

        @JsonProperty("DOC_STATE_NM")
        private String docStateNm;

        @JsonProperty("RESULT_MSG")
        private String resultMsg;
    }
}
