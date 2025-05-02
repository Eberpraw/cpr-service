package com.cprservice.cprservice;

import com.cprservice.Patient;
import com.cprservice.cprservice.Name; // Correct import
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

                    // Create and set Identifier object
                    Identifier identifier = new Identifier();
                    identifier.setId(values[0]); // Assuming id is in the first column
                    identifier.setSystem(values[1]); // Assuming system is in the second column
                    patient.setIdentifier(identifier);

                    // Create and set Name object
                    Name name = new Name(); // Use the correct Name class
                    name.setFamily(values[2]); // Assuming family name is in the third column
                    name.setGiven(Arrays.asList(values[3].split("\\|"))); // Assuming given names are pipe-separated
                    patient.setName(name);

                    patient.setGender(values[4]); // Assuming gender is in the fifth column
                    patient.setBirthDate(values[5]); // Assuming birthDate is in the sixth column
                    // Set other fields as needed
                    return patient;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if no match is found
    }
}