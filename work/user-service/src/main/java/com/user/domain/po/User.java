package com.user.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull
    private Integer id;
    @Size(min = 4,max = 15,message = "用户名不得小于3个字符大于10个字符")
    private String username;
    @Size(min = 4,max = 15,message = "密码不得小于3个字符大于10个字符")
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime deletedTime;
    private Integer transactionsTotal;
}
