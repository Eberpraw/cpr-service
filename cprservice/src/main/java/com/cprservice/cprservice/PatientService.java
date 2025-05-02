package com.cprservice.cprservice;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class PatientService {

    private static final String CSV_FILE_PATH = "src/main/resources/test-patients.csv";

    public Patient findPatientById(String patientID) {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assuming CSV is comma-separated
                if (values[0].equals(patientID)) { // Assuming patientID is in the first column
                    Patient patient = new Patient();

                    // Set resourceType
                    patient.setResourceType("Patient");

                    // Create and set Identifier object
                    Identifier identifier = new Identifier();
                    identifier.setId(values[0]); 
                    identifier.setSystem(values[1]); 
                    patient.setIdentifier(identifier);

                    // Set active status
                    patient.setActive(Boolean.parseBoolean(values[2])); 

                    // Create and set Name object
                    Name name = new Name();
                    name.setFamily(values[3]); 
                    name.setGiven(Arrays.asList(values[4].split("\\|"))); 
                    patient.setName(name);

                    // Set gender
                    patient.setGender(values[5]);

                    // Set birthDate
                    patient.setBirthDate(values[6]); 

                    // Set deceasedBoolean
                    patient.setDeceasedBoolean(Boolean.parseBoolean(values[7])); 

                    // Create and set Address object
                    Address address = new Address();
                    address.setLine(values[8]); 
                    address.setCity(values[9]); 
                    address.setPostalCode(values[10]); 
                    address.setCountry(values[11]);
                    patient.setAddress(address);

                    return patient;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if no match is found
    }
}