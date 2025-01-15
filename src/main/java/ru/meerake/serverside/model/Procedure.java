package ru.meerake.serverside.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "Procedure", schema = "DentalClinic")
public class Procedure {
    @Id
    private Long id;

    private String name;
    private Integer price;
}
