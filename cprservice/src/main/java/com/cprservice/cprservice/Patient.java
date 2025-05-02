package com.cprservice;

import com.cprservice.cprservice.Address;
import com.cprservice.cprservice.Identifier;
import com.cprservice.cprservice.Name; // Correct import

public class Patient {
    private String resourceType;
    private Identifier identifier;
    private Boolean active;
    private Name name; // Use the correct Name class
    private String gender;
    private String birthDate;
    private boolean deceasedBoolean;
    private Address address;

    // Getters and Setters
    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
    public Identifier getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public boolean isDeceasedBoolean() {
        return deceasedBoolean;
    }
    public void setDeceasedBoolean(boolean deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
