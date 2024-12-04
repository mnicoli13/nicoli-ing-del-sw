package IngDelSw.nicoli.services;

import IngDelSw.nicoli.model.Visit;
import IngDelSw.nicoli.model.enums.VisitType;
import IngDelSw.nicoli.repository.VisitRepository;
import IngDelSw.nicoli.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final UserRepository userRepository;

    public VisitService(VisitRepository visitRepository, UserRepository userRepository) {
        this.visitRepository = visitRepository;
        this.userRepository = userRepository;
    }

    public Visit storeVisit(Integer patientId, Integer treatmentId, Integer medicId, LocalDate date, VisitType visitType, Integer localizationId, String notes) {

        // Crea un nuovo trattamento
        Visit visit = new Visit();
        visit.setPatientId(patientId);
        visit.setTreatmentId(treatmentId);
        visit.setMedicId(medicId);
        visit.setDate(date);
        visit.setVisitType(visitType);
        visit.setLocalizationId(localizationId);
        visit.setNotes(notes);

        return visitRepository.save(visit);
    }

    public Visit getVisit(Integer id) {
        return visitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Visit not found with id " + id));
    }

    public Visit updateVisit(Integer id, Integer patientId, Integer treatmentId, Integer medicId, LocalDate date, VisitType visitType, Integer localizationId, String notes) {
        // Verifica se il paziente esiste
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found"));

        // Aggiorna i campi desiderati
        visit.setPatientId(patientId != null ? patientId : visit.getPatientId());
        visit.setTreatmentId(treatmentId != null ? treatmentId : visit.getTreatmentId());
        visit.setMedicId(medicId != null ? medicId : visit.getMedicId());
        visit.setDate(date != null ? date : visit.getDate());
        visit.setVisitType(visitType != null ? visitType : visit.getVisitType());
        visit.setLocalizationId(localizationId != null ? localizationId : visit.getLocalizationId());
        visit.setNotes(notes != null ? notes : visit.getNotes());

        return visitRepository.save(visit);
    }

    public void deleteVisit(Integer visitId) {

        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found"));

        visitRepository.delete(visit);
    }



}

