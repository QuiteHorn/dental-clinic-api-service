CREATE TABLE IF NOT EXISTS "DentalClinic"."Dentist" (
    Id                  serial              PRIMARY KEY,
    FirstName           text                NOT NULL,
    LastName            text                NOT NULL,
    BirthDate           date                NOT NULL,
    PhoneNumber         text                NOT NULL,
    Address             text                NULL,
    Email               text                NULL,
    Experience          integer             NOT NULL,
    IsAble              boolean             NOT NULL
);