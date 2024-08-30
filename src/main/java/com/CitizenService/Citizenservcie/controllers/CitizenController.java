package com.CitizenService.Citizenservcie.controllers;

import com.CitizenService.Citizenservcie.CitizenNotFoundException;
import com.CitizenService.Citizenservcie.entity.Citizen;
import com.CitizenService.Citizenservcie.services.CitizenService;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @Autowired
    MessageSource messageSource;

   // String context = MessageSource

    @GetMapping
    public String getCitizen(){
      return "Citizen created";
    }

   /* want to create a restEndpoint who will give me all the detailed information of citizen
      when whenever id is given
       want to create this end point such that once the particular vaccination centre id is given
       it should return me all the citizens associated with that vaccination centre*/

 /*
    @RequestMapping("/id/{id}")
    public ResponseEntity<String> getById(@PathVariable Integer id){
        List<Citizen> citizenList =
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public List<Citizen> getCitizenById(@PathVariable Integer id){
        return citizenService.getCitizenByVaccinationCentreId(id);

        List<Citizen> citizenList = citizenService.getCitizenByVaccinationCentreId(id);
        return citizenList;
    } */

    @GetMapping("/id/{id}")
    public List<Citizen> getCitizenById(@PathVariable Integer id) {
        List<Citizen> citizenList = citizenService.getCitizenByVaccinationCentreId(id);

        if (citizenList.isEmpty()) {
            throw new CitizenNotFoundException(
                    messageSource.getMessage(
                            "com.CitizenService.Citizenservcie.controllers",
                            null,
                            LocaleContextHolder.getLocale()
                    )
            );
        }
        return citizenList;
    }

    //Get citizen by citizen id

    // Get a  citizen by citizen id
    @GetMapping("/{id}")
    public Citizen getCitizen(@PathVariable int id) {
        return citizenService.getCitizen(id);
    }

    // Get list of citizen
    @GetMapping("/getAllCitizen")
    public List<Citizen> getAllCitizen(){
        return citizenService.getAllCitizen();
    }

    // Add citizen
    @PostMapping("/addCitizen")
    public Citizen addCitizen(@RequestBody Citizen citizen){
        return citizenService.addCitizen(citizen);
    }
}