package app.domain.services;

import app.domain.model.Medication;
import app.domain.model.Procedure;
import app.domain.model.DiagnosticAid;
import app.domain.port.out.MedicationRepository;
import app.domain.port.out.ProcedureRepository;
import app.domain.port.out.DiagnosticAidRepository;
import app.domain.port.out.UserRepository;
import app.domain.valueobject.Id;
import app.domain.valueobject.UserId;
import app.domain.valueobject.Password;
import java.util.Optional;

public class InformationSupportService {

    private final MedicationRepository medicationRepository;
    private final ProcedureRepository procedureRepository;
    private final DiagnosticAidRepository diagnosticAidRepository;
    private final UserRepository userRepository;

    public InformationSupportService(MedicationRepository medicationRepository,
                                     ProcedureRepository procedureRepository,
                                     DiagnosticAidRepository diagnosticAidRepository,
                                     UserRepository userRepository) {
        this.medicationRepository = medicationRepository;
        this.procedureRepository = procedureRepository;
        this.diagnosticAidRepository = diagnosticAidRepository;
        this.userRepository = userRepository;
    }

    public void addMedication(Medication medication) {
        medicationRepository.save(medication);
    }

    public void updateMedication(Id medicationId, Medication updated) {
        Optional<Medication> existing = medicationRepository.findById(medicationId);
        if (existing.isPresent()) {
            Medication med = existing.get();
            med.updateInfo(updated.getName(), updated.getDosage(), updated.getStock());
            medicationRepository.save(med);
        } else {
            throw new IllegalArgumentException("Medicamento no encontrado: " + medicationId.getValue());
        }
    }

    public void deleteMedication(Id medicationId) {
        medicationRepository.delete(medicationId);
    }

    public void addProcedure(Procedure procedure) {
        procedureRepository.save(procedure);
    }

    public void addDiagnosticAid(DiagnosticAid aid) {
        diagnosticAidRepository.save(aid);
    }

    public void assistUser(UserId userId, String issue) {
        userRepository.findById(userId)
            .ifPresentOrElse(
                user -> System.out.println("Brindando soporte a: " + user.getUsername() + ": " + issue),
                () -> { throw new IllegalArgumentException("Usuario no encontrado: " + userId.getValue()); }
            );
    }

    public void resetUserAccess(UserId userId, Password newPassword) {
        userRepository.findById(userId).ifPresent(user -> {
            user.changePassword(newPassword);
            userRepository.save(user);
        });
    }
}
