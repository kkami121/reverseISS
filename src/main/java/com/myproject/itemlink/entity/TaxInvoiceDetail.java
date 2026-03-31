package com.myproject.itemlink.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tax_invoice_detail")
@Getter
@Setter
@NoArgsConstructor
public class TaxInvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id")
    private TaxInvoiceMaster master;

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
