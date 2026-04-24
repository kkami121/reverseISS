package com.myproject.itemlink.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaxInvoiceDetail {

    private Long id;
    private Long masterId;

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
