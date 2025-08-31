package app.domain.services;

import app.domain.model.HumanResourcesMember;
import app.domain.valueobject.Email;
import app.domain.valueobject.Phone;
import app.domain.port.out.HumanResourcesRepository;

import java.util.Optional;

public class StaffInformationService {
    private final HumanResourcesRepository hrRepository;

    public StaffInformationService(HumanResourcesRepository hrRepository) {
        this.hrRepository = hrRepository;
    }

    public void updateEmail(Long hrId, Email newEmail) {
        Optional<HumanResourcesMember> memberOpt = hrRepository.findById(hrId);
        if (memberOpt.isPresent()) {
            HumanResourcesMember member = memberOpt.get();
            member.setEmail(newEmail);
            hrRepository.save(member);
        } else {
            throw new IllegalArgumentException("HR Member not found with id: " + hrId);
        }
    }

    public void updatePhone(Long hrId, Phone newPhone) {
        Optional<HumanResourcesMember> memberOpt = hrRepository.findById(hrId);
        if (memberOpt.isPresent()) {
            HumanResourcesMember member = memberOpt.get();
            member.setPhone(newPhone);
            hrRepository.save(member);
        } else {
            throw new IllegalArgumentException("HR Member not found with id: " + hrId);
        }
    }
}
