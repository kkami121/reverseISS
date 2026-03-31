package com.myproject.itemlink.controller;

import com.myproject.itemlink.dto.KaccountingResponse;
import com.myproject.itemlink.dto.TaxInvoiceRequest;
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

    @PostMapping("/issue")
    public ResponseEntity<KaccountingResponse> issue(@RequestBody TaxInvoiceRequest request) {
        KaccountingResponse response = taxInvoiceService.issue(request);
        return ResponseEntity.ok(response);
    }
}
