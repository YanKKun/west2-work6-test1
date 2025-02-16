package com.transaction.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Integer type;
    private Integer createUserId;
    private Integer pageNum;
    private Integer pageSize;
    private String keyword;
}
