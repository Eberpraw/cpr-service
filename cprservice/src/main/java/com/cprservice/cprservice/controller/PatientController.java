package com.cprservice.cprservice.controller;

import com.cprservice.Patient;
import com.cprservice.cprservice.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public Patient getPatient(@RequestParam String patientID, @RequestParam String doctorID) {
        // Hent patienten baseret på patientID 
        Patient patient = patientService.findPatientById(patientID);  // Find patienten
        
        return patient;
    }

    // Andre endpoints kan implementeres her
}
