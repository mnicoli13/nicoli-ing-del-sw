package IngDelSw.nicoli.controller;

import IngDelSw.nicoli.model.Patient;
import IngDelSw.nicoli.services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientsController {

    private final PatientService patientService;

    public PatientsController (PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/store")
    public ResponseEntity<?> storePatient(@RequestBody Patient patientRequest) {
        try {
            Patient patient = patientService.registerPatient(
                    patientRequest.getFirstName(),
                    patientRequest.getLastName(),
                    patientRequest.getEmail(),
                    patientRequest.getPassword(),
                    patientRequest.getGender(),
                    patientRequest.getCreatedBy(),
                    patientRequest.getDateOfBirth(),
                    patientRequest.getEthnicity(),
                    patientRequest.getPreviousHistory()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(patient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Integer id) {
        try {
            Patient patient = patientService.getPatient(id);

            return ResponseEntity.ok(patient);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @GetMapping("/listByDoctor/{id}")
    public ResponseEntity<?> getPatientsByDoctorId(@PathVariable Integer id) {
        try {
            List<Patient> patients = patientService.getPatientsByDoctorId(id);

            return ResponseEntity.ok(patients);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> getPatientsByDoctorId(@RequestBody Patient patientRequest) {
        try {
            Patient patient = patientService.updatePatient(
                    patientRequest.getId(),
                    patientRequest.getFirstName(),
                    patientRequest.getLastName(),
                    patientRequest.getEmail(),
                    patientRequest.getGender(),
                    patientRequest.getDateOfBirth(),
                    patientRequest.getEthnicity(),
                    patientRequest.getPreviousHistory()
            );

            return ResponseEntity.ok(patient);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id) {
        try {
            patientService.deletePatient(id);

            return ResponseEntity.ok("patient deleted successfully");  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }
}
