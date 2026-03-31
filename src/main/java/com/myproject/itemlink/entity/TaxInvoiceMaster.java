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

    // 기본
    private String corpBizNo;
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

    // 공급자
    private String compRegisterNo;
    private String compSubId;
    private String compName;
    private String compRepresent;
    private String compBizState;
    private String compBizCategory;
    private String compZipCode;
    private String compAddress1;
    private String compAddress2;

    // 담당자 (공급자측)
    private String memberNm;
    private String memberTelNo1;
    private String memberTelNo2;
    private String memberTelNo3;
    private String memberEmail;
    private String memberPost;

    // 공급받는자
    private String custKind;
    private String custRegisterNo;
    private String custSubId;
    private String custName;
    private String custRepresent;
    private String custBizState;
    private String custBizCategory;
    private String custZipCode;
    private String custAddress1;
    private String custAddress2;

    // 수신담당자1
    private String managerNm;
    private String managerTelNo1;
    private String managerTelNo2;
    private String managerTelNo3;
    private String managerEmail;
    private String managerPost;

    // 수신담당자2
    private String manager2Nm;
    private String manager2TelNo1;
    private String manager2TelNo2;
    private String manager2TelNo3;
    private String manager2Email;
    private String manager2Post;

    // 기타
    private String bigo;
    private String bookNo1;
    private String bookNo2;
    private String serialNo;
    private String smsGb;

    // 발행 결과
    private String status;
    private String errCode;
    private String errMsg;
    private String rtn;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "master", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaxInvoiceDetail> details = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
