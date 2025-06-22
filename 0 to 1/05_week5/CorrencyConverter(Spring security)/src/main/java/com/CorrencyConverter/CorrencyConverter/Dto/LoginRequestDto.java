package com.CorrencyConverter.CorrencyConverter.Dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequestDto {

    private String email;
    private String password;

}
