package com.joe.bookshop.security.jwtFilters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UsernamePasswordAuthRequest {

    private String username;
    private String password;

}
