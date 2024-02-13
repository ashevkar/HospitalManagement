/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.ashevkar.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author ashevkar
 */
public class PatientValidationTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void validateName() {
        Patient patient = new Patient("John", LocalDate.of(1990, 5, 15), PatientGender.MALE);

        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        assertTrue(violations.isEmpty(), "Name should not have violations");
    }

    @Test
    public void validateInvalidName() {
        Patient patient = new Patient("", LocalDate.of(1990, 5, 15), PatientGender.MALE);

        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        assertFalse(violations.isEmpty(), "Empty name should result in violations");
    }

    @Test
    public void validateBirthDate() {
        Patient patient = new Patient("Alice", LocalDate.of(1995, 10, 20), PatientGender.FEMALE);

        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        assertTrue(violations.isEmpty(), "Birth date should not have violations");
    }

    @Test
    public void validateFutureBirthDate() {
        Patient patient = new Patient("Bob", LocalDate.now().plusDays(1), PatientGender.MALE);

        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        assertFalse(violations.isEmpty(), "Future birth date should result in violations");
    }

    // Sunny-day test for other constraints
    @Test
    public void validateValidPatient() {
        Patient patient = new Patient("Eva", LocalDate.of(1980, 3, 25), PatientGender.FEMALE);

        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        assertTrue(violations.isEmpty(), "A valid patient should not have violations");
    }

    // Rainy-day test for other constraints
    @Test
    public void validateInvalidPatient() {
        Patient patient = new Patient("", LocalDate.now().minusDays(1), null);

        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        assertFalse(violations.isEmpty(), "An invalid patient should result in violations");
    }
}