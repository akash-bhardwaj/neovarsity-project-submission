package com.scaler.neovarsityproject.models;

import lombok.Data;
import java.sql.Date;

@Data
public class BaseModel {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
