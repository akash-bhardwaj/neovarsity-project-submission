package com.scaler.neovarsityproject.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Gate {

    private String location;
    private OperatorDetails operator;
}
