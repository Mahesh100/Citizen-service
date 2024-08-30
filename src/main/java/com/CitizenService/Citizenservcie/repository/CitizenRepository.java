package com.CitizenService.Citizenservcie.repository;

import com.CitizenService.Citizenservcie.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

    List<Citizen> findByVaccinationCentreId(int vaccinationCentreId);
}
