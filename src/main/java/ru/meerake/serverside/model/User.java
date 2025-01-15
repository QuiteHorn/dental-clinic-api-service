package ru.meerake.serverside.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "User", schema = "DentalClinic")
public class User {
    @Id
    private Long id;

    private String username;
    private String password;
    private String role;
    private LocalDateTime lastlogin;
}
