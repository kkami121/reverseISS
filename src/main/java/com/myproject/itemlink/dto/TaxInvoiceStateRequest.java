package com.myproject.itemlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxInvoiceStateRequest {

    @JsonProperty("CHANNEL")
    private String channel = "SHINWON";

    @JsonProperty("CORP_BIZ_NO")
    private String corpBizNo;

    @JsonProperty("DATA")
    private Data data;

    @Getter
    @Setter
    public static class Data {

        @JsonProperty("DATE_TYPE")
        private String dateType;

        @JsonProperty("START_DATE")
        private String startDate;

        @JsonProperty("END_DATE")
        private String endDate;

        @JsonProperty("ERP_USER_MAKE_ID")
        private String erpUserMakeId;
    }
}
