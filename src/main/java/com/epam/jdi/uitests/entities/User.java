package com.epam.jdi.uitests.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public static User PETER = new User("epam", "1234");
    String name;
    String password;
}

