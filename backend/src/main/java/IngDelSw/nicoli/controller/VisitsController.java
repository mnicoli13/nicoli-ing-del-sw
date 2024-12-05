package IngDelSw.nicoli.controller;

import IngDelSw.nicoli.model.Visit;
import IngDelSw.nicoli.services.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit")
public class VisitsController {

    private final VisitService visitService;

    public VisitsController(VisitService visitService){
        this.visitService = visitService;
    }

    @PostMapping("/store")
    public ResponseEntity<?> storeVisit(@RequestBody Visit visitRequest) {
        try {
            Visit visit = visitService.storeVisit(
                    visitRequest.getPatientId(),
                    visitRequest.getTreatmentId(),
                    visitRequest.getMedicId(),
                    visitRequest.getDate(),
                    visitRequest.getVisitType(),
                    visitRequest.getLocalizationId(),
                    visitRequest.getNotes()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(visit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVisitById(@PathVariable int id) {
        try {
            Visit visit = visitService.getVisit(id);

            return ResponseEntity.ok(visit);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateVisit(@RequestBody Visit visitRequest) {
        try {
            Visit visit = visitService.updateVisit(
                    visitRequest.getId(),
                    visitRequest.getPatientId(),
                    visitRequest.getTreatmentId(),
                    visitRequest.getMedicId(),
                    visitRequest.getDate(),
                    visitRequest.getVisitType(),
                    visitRequest.getLocalizationId(),
                    visitRequest.getNotes()
            );

            return ResponseEntity.ok(visit);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteVisit(@PathVariable int id) {
        try {
            visitService.deleteVisit(id);

            return ResponseEntity.ok("patient deleted successfully");  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }


}
