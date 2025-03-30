package com.email.emailManageSystem.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author userlzy
 * @version 1.0
 * @description: Email实体类
 * @date 2025/3/9 16:28
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {

    private Long emailId; // 主键（自增）
    private Integer emailReceiveUserId; // 收件人id
    private Integer emailSendUserId; // 发件人id
    private String emailSubject; // 主题
    private String emailText; // 正文（展示时复杂，全文检索问题）
    private Boolean emailAnnexUrl; // 附件（0：无附件，1：有附件）
    private Boolean emailRead; // 邮件已读/未读（0：未读，1：已读）
    private Boolean emailStar; // 星标邮件（0：未标星，1：已标星）
    private Boolean emailNeedBack; // 是否需要回复（0：不需要，1：需要）
    private Boolean emailBack; // 是否已经回复（0：未回复，1：已回复）
    private Boolean emailSend; // 是否发送成功（0：未成功，1：成功）
    private Boolean emailDraft; // 是否发送（0：草稿，1：已发送）
    private LocalDateTime emailSendTime; // 发件时间
    private LocalDateTime emailReadTime; // 已读时间
    private Boolean emailNeedRead; // 是否开启已读未读功能（0：关闭，1：开启）

}