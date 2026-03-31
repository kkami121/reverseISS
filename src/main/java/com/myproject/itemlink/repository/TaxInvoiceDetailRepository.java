package com.myproject.itemlink.repository;

import com.myproject.itemlink.entity.TaxInvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxInvoiceDetailRepository extends JpaRepository<TaxInvoiceDetail, Long> {
}
