package com.ct.ghospital.patient.serviceimpl;

import com.ct.ghospital.patient.model.DiagnosisDetails;
import com.ct.ghospital.patient.repo.DiagnosisDetailsRepo;
import com.ct.ghospital.patient.service.DiagnosisDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisDetailsServiceImpl implements DiagnosisDetailsService {

    @Autowired
    DiagnosisDetailsRepo diagnosisDetailsRepo;

    @Override
    public List<DiagnosisDetails> getAllDiagnosisDetails() {
        return new ArrayList<>(diagnosisDetailsRepo.findAll());
    }

    @Override
    public DiagnosisDetails getDiagnosisDetails(Integer diagnosisid) throws Exception {
        Optional<DiagnosisDetails> diagnosisDetailsOptional = diagnosisDetailsRepo.findById(diagnosisid);
        if (diagnosisDetailsOptional.isPresent()) {
            return diagnosisDetailsOptional.get();
        } else {
            throw new Exception("Diagnosis is not Present");
        }
    }

    @Override
    public DiagnosisDetails saveDiagnosisDetails(DiagnosisDetails diagnosisDetails) {
        return diagnosisDetailsRepo.save(diagnosisDetails);
    }

    @Override
    public DiagnosisDetails updateDiagnosisDetails(Integer diagnosisid, DiagnosisDetails diagnosisDetails) throws Exception {
        DiagnosisDetails pDiagnosisDetails = getDiagnosisDetails(diagnosisid);
        pDiagnosisDetails.setDiagnosisIsDeprecated(diagnosisDetails.getDiagnosisIsDeprecated());
        pDiagnosisDetails.setDiagnosisCode(diagnosisDetails.getDiagnosisCode());
        pDiagnosisDetails.setDiagnosisDescription(diagnosisDetails.getDiagnosisDescription());
        return diagnosisDetailsRepo.save(pDiagnosisDetails);
    }

    @Override
    public void deleteDiagnosisDetails(Integer diagnosisid) throws Exception {
        DiagnosisDetails diagnosisDetails = getDiagnosisDetails(diagnosisid);
        diagnosisDetailsRepo.delete(diagnosisDetails);
    }
}
