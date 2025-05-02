package com.cprservice.cprservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void logApiCall(String endpoint, String parameters, LocalDateTime timestamp) {
        System.out.println("Logging API call: " + endpoint + ", " + parameters + ", " + timestamp);
        AuditLog log = new AuditLog();
        log.setEndpoint(endpoint);
        log.setParameters(parameters);
        log.setTimestamp(timestamp);
        auditLogRepository.save(log);
    }

    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }
}