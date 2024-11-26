package com.bank.atm.monitor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDTO {
    private String mediaType;
    private String filePath;
    private String timestamp;
    private int atmId;

}

