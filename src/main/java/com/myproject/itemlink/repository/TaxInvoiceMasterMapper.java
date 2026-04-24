package com.myproject.itemlink.repository;

import com.myproject.itemlink.entity.TaxInvoiceMaster;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaxInvoiceMasterMapper {

    void insert(TaxInvoiceMaster master);
}
