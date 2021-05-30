package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDetailResponse {
    
    private String status;
    private String message;
    private String name;
    private String referenceURL;
    private long activeMemberCount;
}
