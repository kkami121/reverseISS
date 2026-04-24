package com.myproject.itemlink.repository;

import com.myproject.itemlink.entity.EmpInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {

    EmpInfo findByUserId(String userId);
}
