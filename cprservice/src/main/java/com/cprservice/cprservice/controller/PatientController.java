package com.cprservice.cprservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cprservice.cprservice.PatientService;
import com.cprservice.cprservice.AuditLogService;
import com.cprservice.cprservice.Patient;
import com.cprservice.cprservice.AuditLog;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/getPatient")
    public Patient getPatientById(@RequestParam String patientID) {
        // Log the API call
        auditLogService.logApiCall("/getPatient", "patientID=" + patientID, LocalDateTime.now());

        // Retrieve and return the patient
        return patientService.findPatientById(patientID);
    }

    @GetMapping("/auditlog")
    public List<AuditLog> getAuditLog() {
        // Retrieve and return all audit logs
        return auditLogService.getAllLogs();
    }
}
