package com.mybatis.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

    boolean success;
    String jobId;
    String jobGroup;
    String message;
    List<String> resultMessage;

    public MessageResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


}
