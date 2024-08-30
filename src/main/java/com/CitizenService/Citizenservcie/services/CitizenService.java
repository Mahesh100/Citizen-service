package com.CitizenService.Citizenservcie.services;

import com.CitizenService.Citizenservcie.entity.Citizen;
import com.CitizenService.Citizenservcie.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    public Citizen addCitizen(Citizen citizen){
        return citizenRepository.save(citizen);
    }

    public List<Citizen> getCitizenByVaccinationCentreId(int vaccinationCentreId){
        return citizenRepository.findByVaccinationCentreId(vaccinationCentreId);
    }

    public Citizen getCitizen(int id){
        return citizenRepository.findById(id).orElse(null);
    }

    public List<Citizen> getAllCitizen(){
        return citizenRepository.findAll();
    }
}
