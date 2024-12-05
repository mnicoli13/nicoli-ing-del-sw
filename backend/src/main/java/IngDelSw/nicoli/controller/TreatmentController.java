package IngDelSw.nicoli.controller;

import IngDelSw.nicoli.model.Patient;
import IngDelSw.nicoli.model.Treatment;
import IngDelSw.nicoli.services.PatientService;
import IngDelSw.nicoli.services.TreatmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatment")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService){
        this.treatmentService = treatmentService;
    }

    @PostMapping("/store")
    public ResponseEntity<?> storeTreatment(@RequestBody Treatment treatmentRequest) {
        try {
            Treatment treatment = treatmentService.storeTreatment(
                    treatmentRequest.getPatientId(),
                    treatmentRequest.getMotivationTitle(),
                    treatmentRequest.getMotivationDesc(),
                    treatmentRequest.getLocalizationId()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(treatment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTreatmentById(@PathVariable int id) {
        try {
            Treatment treatment = treatmentService.getTreatment(id);

            return ResponseEntity.ok(treatment);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTreatment(@RequestBody Treatment treatmentRequest) {
        try {
            Treatment treatment = treatmentService.updateTreatment(
                    treatmentRequest.getId(),
                    treatmentRequest.getPatientId(),
                    treatmentRequest.getMotivationTitle(),
                    treatmentRequest.getMotivationDesc(),
                    treatmentRequest.getLocalizationId()
            );

            return ResponseEntity.ok(treatment);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteTreatment(@PathVariable int id) {
        try {
            treatmentService.deleteTreatment(id);

            return ResponseEntity.ok("patient deleted successfully");  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @GetMapping("/listByPatient/{id}")
    public ResponseEntity<?> getPatientsByPatientId(@PathVariable Integer id) {
        try {
            List<Treatment> treatments = treatmentService.getTreatmentsByPatientsId(id);

            return ResponseEntity.ok(treatments);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }
}
