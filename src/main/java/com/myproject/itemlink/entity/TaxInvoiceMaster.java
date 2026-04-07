package com.myproject.itemlink.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tax_invoice_master")
@Getter
@Setter
@NoArgsConstructor
public class TaxInvoiceMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String erpUserMakeId;
    private String documentType;
    private String modReason;
    private String oriIssueId;
    private String targetLevel;
    private String taxType;
    private String makeDate;
    private String tranType;

    // 금액
    private String cashAmt;
    private String checkAmt;
    private String billAmt;
    private String uncollectAmt;
    private String taxAmt;
    private String supplyAmt;
    private String totalAmt;

    // 공급처
    private String compRegisterNo;
    private String compName;
    private String compRepresent;
    private String compAddress1;
    private String compAddress2;

    // 공급 담당자
    private String memberNm;
    private String memberTelNo1;
    private String memberTelNo2;
    private String memberTelNo3;
    private String memberEmail;

    // 매입처
    private String custRegisterNo;
    private String custName;
    private String custRepresent;
    private String custZipCode;
    private String custAddress1;

    // 매입 담당자
    private String managerNm;
    private String managerTelNo1;
    private String managerTelNo2;
    private String managerTelNo3;
    private String managerEmail;

    private String bigo;
    private String smsGb;

    // 발행 결과
    private String status;
    private String errCode;
    private String errMsg;
    private String rtn;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaxInvoiceDetail> details = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
