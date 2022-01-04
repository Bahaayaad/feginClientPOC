package com.example.feginclientpoc.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class User {


    Long id;

    String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String password;

    @JsonFormat(pattern = "dd MMM yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate dateOfBirth;

    @JsonFormat(pattern = "dd MMM yyyy hh:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime lastLogin;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSSXXX", locale = "en_SG", timezone = "Asia/Singapore")
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    ZonedDateTime zonedDateTime;

}