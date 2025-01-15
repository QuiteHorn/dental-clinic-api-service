CREATE TABLE IF NOT EXISTS "DentalClinic"."User" (
            Id                      serial              PRIMARY KEY,
            Username                text                NOT NULL,
            Password                text                NOT NULL,
            Role                    text                NOT NULL,
            LastLogin               timestamp           NULL
);