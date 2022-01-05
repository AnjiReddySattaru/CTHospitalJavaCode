package com.ct.ghospital.patient.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AddressException.class)
    private ResponseEntity<ErrorResponse> handleAddressNotFoundException(AddressException addressException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, addressException.getMessage()));
    }

    @ExceptionHandler(AllergyDetailsException.class)
    private ResponseEntity<ErrorResponse> handleAllergyDetailsNotFoundException(AllergyDetailsException allergyDetailsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, allergyDetailsException.getMessage()));
    }

    @ExceptionHandler(DiagnosisDetailsException.class)
    private ResponseEntity<ErrorResponse> handleDiagnosisNotFoundException(DiagnosisDetailsException diagnosisDetailsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, diagnosisDetailsException.getMessage()));
    }

    @ExceptionHandler(EmergencyContactException.class)
    private ResponseEntity<ErrorResponse> handleEmergencyContactNotFoundException(EmergencyContactException emergencyContactException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, emergencyContactException.getMessage()));
    }

    @ExceptionHandler(MedicationDetailsException.class)
    private ResponseEntity<ErrorResponse> handleMedicationDetailsNotFoundException(MedicationDetailsException medicationDetailsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, medicationDetailsException.getMessage()));
    }

    @ExceptionHandler(PatientAllergicDetailsException.class)
    private ResponseEntity<ErrorResponse> handlePatientAllergicDetailsNotFoundException(PatientAllergicDetailsException patientAllergicDetailsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, patientAllergicDetailsException.getMessage()));
    }

    @ExceptionHandler(PatientDetailsExceptions.class)
    private ResponseEntity<ErrorResponse> handlePatientDetailsNotFoundException(PatientDetailsExceptions patientDetailsExceptions) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, patientDetailsExceptions.getMessage()));
    }

    @ExceptionHandler(PatientExceptions.class)
    private ResponseEntity<ErrorResponse> handlePatientNotFoundException(PatientExceptions patientExceptions) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, patientExceptions.getMessage()));
    }

    @ExceptionHandler(ProcedureDetailsException.class)
    private ResponseEntity<ErrorResponse> handleProcedureDetailsNotFoundException(ProcedureDetailsException procedureDetailsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, procedureDetailsException.getMessage()));
    }

    @ExceptionHandler(VitalSignsException.class)
    private ResponseEntity<ErrorResponse> handleVitalSignsNotFoundException(VitalSignsException vitalSignsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, vitalSignsException.getMessage()));
    }
    
    @ExceptionHandler(PatientVisitDetailsException.class)
    private ResponseEntity<ErrorResponse> handlePatientVisitDetailsException(PatientVisitDetailsException patientVisitDetailsException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(111, patientVisitDetailsException.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400, "Arguments Missing"));
    }
}
