package com.yunusemre.springsecurity.user.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {

    @Email
    @Length(min = 5, max = 50)
    private String email;

    @Length(min = 5, max = 10)
    private String password;
}
