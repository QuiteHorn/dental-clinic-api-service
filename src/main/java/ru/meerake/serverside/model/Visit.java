package ru.meerake.serverside.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "History", schema = "DentalClinic")
public class Visit {
    @Id
    private Long id;

    private Long patientid;
    private Long dentistid;
    private Long procedureid;
    private LocalDate visitdate;
}
