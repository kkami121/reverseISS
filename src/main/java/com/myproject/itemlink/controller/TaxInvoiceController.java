package com.myproject.itemlink.controller;

import com.myproject.itemlink.dto.KaccountingResponse;
import com.myproject.itemlink.dto.TaxInvoiceListRequest;
import com.myproject.itemlink.dto.TaxInvoiceListResponse;
import com.myproject.itemlink.dto.TaxInvoiceRequest;
import com.myproject.itemlink.dto.TaxInvoiceStateRequest;
import com.myproject.itemlink.dto.TaxInvoiceStateResponse;
import com.myproject.itemlink.service.TaxInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax-invoice")
@RequiredArgsConstructor
public class TaxInvoiceController {

    private final TaxInvoiceService taxInvoiceService;

    // 역발행 세금계산서 발행
    @PostMapping("/issue")
    public ResponseEntity<KaccountingResponse> issue(@RequestBody TaxInvoiceRequest request) {
        KaccountingResponse response = taxInvoiceService.issue(request);
        return ResponseEntity.ok(response);
    }

    // 역발행 세금계산서 조회
    @PostMapping("/list")
    public ResponseEntity<TaxInvoiceListResponse> list(@RequestBody TaxInvoiceListRequest request) {
        TaxInvoiceListResponse response = taxInvoiceService.list(request);
        return ResponseEntity.ok(response);
    }

    // 역발행 세금계산서 상태 조회
    @PostMapping("/state")
    public ResponseEntity<TaxInvoiceStateResponse> state(@RequestBody TaxInvoiceStateRequest request) {
        TaxInvoiceStateResponse response = taxInvoiceService.state(request);
        return ResponseEntity.ok(response);
    }
}
