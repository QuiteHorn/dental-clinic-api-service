package ru.meerake.serverside.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "Patient", schema = "DentalClinic")
public class Patient {
    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String phonenumber;
    private String address;
    private String email;
}
