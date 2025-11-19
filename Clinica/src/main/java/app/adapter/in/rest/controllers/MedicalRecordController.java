package app.adapter.in.rest.controllers;
 
import app.application.usecases.MedicalRecordUseCase;
import app.domain.model.MedicalRecord;
import app.domain.valueobject.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import app.application.exceptions.EntityNotFoundException;
 
@RestController
@RequestMapping("/api/medical-record")
@PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE') or hasRole('ADMINISTRATIVE_STAFF')")
public class MedicalRecordController {
 
    @Autowired
    private MedicalRecordUseCase medicalRecordUseCase;
 
    @PostMapping
    public ResponseEntity<Void> createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        // Construir Id a partir del patientId del medicalRecord
        Id id = new Id(String.valueOf(medicalRecord.getPatientId()));
        medicalRecordUseCase.CreateMedicalRecord(id, medicalRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
 
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<MedicalRecord>> getMedicalRecordByPatient(@PathVariable("id") long id) {
        List<MedicalRecord> records = medicalRecordUseCase.SearchMedicalRecord(id, null);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedicalRecord(@PathVariable("id") long id, @RequestBody MedicalRecord medicalRecord) {
        try {
            medicalRecordUseCase.UpdateMedicalRecord(id, medicalRecord);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicalRecord(@PathVariable("id") long id) {
        try {
            medicalRecordUseCase.DeleteMedicalRecord(id, null);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException enf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}