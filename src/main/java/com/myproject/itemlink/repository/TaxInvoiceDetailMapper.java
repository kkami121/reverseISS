package com.myproject.itemlink.repository;

import com.myproject.itemlink.entity.TaxInvoiceDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaxInvoiceDetailMapper {

    void insert(TaxInvoiceDetail detail);
}
