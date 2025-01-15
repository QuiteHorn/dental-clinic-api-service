package ru.meerake.serverside.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "Dentist", schema = "DentalClinic")
public class Dentist {
    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String phonenumber;
    private String address;
    private String email;

    private Integer experience;
    private Boolean isable;
}
