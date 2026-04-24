package com.myproject.itemlink.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class EmpInfo implements Serializable {

    private String nmKor;
    private String email;
    private String empId;
}
