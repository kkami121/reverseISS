package com.myproject.itemlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxInvoiceListRequest {

    @JsonProperty("CHANNEL")
    private String channel = "SHINWON";

    @JsonProperty("CORP_BIZ_NO")
    private String corpBizNo;

    @JsonProperty("CATEGORY")
    private String category;

    @JsonProperty("DOC_TYPE")
    private String docType;

    @JsonProperty("ISSUE_TYPE")
    private String issueType;

    @JsonProperty("ITEM_LIST")
    private String itemList;
}
