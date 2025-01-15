CREATE TABLE IF NOT EXISTS "DentalClinic"."Procedure" (
    Id                  serial              PRIMARY KEY,
    Name                text                NOT NULL,
    Price               integer             NOT NULL
);