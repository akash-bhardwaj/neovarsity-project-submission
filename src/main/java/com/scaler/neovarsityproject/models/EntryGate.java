package com.scaler.neovarsityproject.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EntryGate extends Gate {
    private DisplayBoard displayBoard;
}
