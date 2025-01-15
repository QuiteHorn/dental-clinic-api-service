CREATE TABLE IF NOT EXISTS "DentalClinic"."History" (
    Id                      serial              PRIMARY KEY,
    PatientId               integer             NOT NULL,
    DentistId               integer             NOT NULL,
    ProcedureId             integer             NOT NULL,
    VisitDate               date                NOT NULL,
    CONSTRAINT fk_patient FOREIGN KEY (PatientId) REFERENCES "DentalClinic"."Patient"(Id),
    CONSTRAINT fk_dentist FOREIGN KEY (DentistId) REFERENCES "DentalClinic"."Dentist"(Id),
    CONSTRAINT fk_procedure FOREIGN KEY (ProcedureId) REFERENCES "DentalClinic"."Procedure"(Id)
);