package com.myproject.itemlink.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KaccountingResponse {

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
    }
}
