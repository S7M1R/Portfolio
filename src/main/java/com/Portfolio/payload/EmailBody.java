package com.Portfolio.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailBody {
    private String senderName;
    private String senderEmail;
    private String message;
    private Integer HitId;
}
