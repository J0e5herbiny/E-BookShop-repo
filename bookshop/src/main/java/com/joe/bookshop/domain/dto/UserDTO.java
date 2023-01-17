package com.joe.bookshop.domain.dto;

import com.joe.bookshop.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;

}
