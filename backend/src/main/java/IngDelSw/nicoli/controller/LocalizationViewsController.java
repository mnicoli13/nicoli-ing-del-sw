package IngDelSw.nicoli.controller;

import IngDelSw.nicoli.model.LocalizationView;
import IngDelSw.nicoli.services.LocalizationViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localization-view")
public class LocalizationViewsController {

    private final LocalizationViewService localizationViewService;

    public LocalizationViewsController(LocalizationViewService localizationViewService){
        this.localizationViewService = localizationViewService;
    }

    @PostMapping("/store")
    public ResponseEntity<?> storeLocalizationView(@RequestBody LocalizationView localizationViewRequest) {
        try {
            LocalizationView localizationView = localizationViewService.storeLocalizationView(
                    localizationViewRequest.getLocalizationId(),
                    localizationViewRequest.getName(),
                    localizationViewRequest.getOrder()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(localizationView);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocalizationViewById(@PathVariable int id) {
        try {
            LocalizationView localizationView = localizationViewService.getLocalizationView(id);

            return ResponseEntity.ok(localizationView);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocalizationView(@RequestBody LocalizationView localizationViewRequest) {
        try {
            LocalizationView localizationView = localizationViewService.updateLocalizationView(
                    localizationViewRequest.getId(),
                    localizationViewRequest.getLocalizationId(),
                    localizationViewRequest.getName(),
                    localizationViewRequest.getOrder()
            );

            return ResponseEntity.ok(localizationView);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteLocalizationView(@PathVariable int id) {
        try {
            localizationViewService.deleteLocalizationView(id);

            return ResponseEntity.ok("patient deleted successfully");  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }


}
