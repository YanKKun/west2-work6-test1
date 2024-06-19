package com.transaction.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Transaction {
    private Integer id;
    private Integer createUserId;
    @Size(min = 2,max = 15,message = "标题不得小于2个字符大于15个字符")
    private String title;
    @Size(min = 1,message = "内容不得小于3个字符")
    private String content;
    private Integer type;
    private LocalDateTime createdTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime deletedTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer isDeleted;
}
