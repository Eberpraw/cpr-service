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
                    identifier.setId(values[0]); // Assuming id is in the first column
                    identifier.setSystem(values[1]); // Assuming system is in the second column
                    patient.setIdentifier(identifier);

                    // Set active status
                    patient.setActive(Boolean.parseBoolean(values[2])); // Assuming active is in the third column

                    // Create and set Name object
                    Name name = new Name();
                    name.setFamily(values[3]); // Assuming family name is in the fourth column
                    name.setGiven(Arrays.asList(values[4].split("\\|"))); // Assuming given names are pipe-separated
                    patient.setName(name);

                    // Set gender
                    patient.setGender(values[5]); // Assuming gender is in the sixth column

                    // Set birthDate
                    patient.setBirthDate(values[6]); // Assuming birthDate is in the seventh column

                    // Set deceasedBoolean
                    patient.setDeceasedBoolean(Boolean.parseBoolean(values[7])); // Assuming deceasedBoolean is in the eighth column

                    // Create and set Address object
                    Address address = new Address();
                    address.setLine(values[8]); // Assuming address line is in the ninth column
                    address.setCity(values[9]); // Assuming city is in the tenth column
                    address.setPostalCode(values[10]); // Assuming postalCode is in the eleventh column
                    address.setCountry(values[11]); // Assuming country is in the twelfth column
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