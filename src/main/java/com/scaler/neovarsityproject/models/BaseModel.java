package com.scaler.neovarsityproject.models;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Data
@SuperBuilder
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
