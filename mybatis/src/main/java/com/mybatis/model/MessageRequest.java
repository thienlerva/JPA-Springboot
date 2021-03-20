package com.mybatis.model;


import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    String message;
    LocalDateTime dateTime;
    List<BigInteger> groupId;
}
