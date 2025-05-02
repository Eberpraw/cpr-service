package com.cprservice.cprservice;

public class Patient {
    private String resourceType;
    private Identifier identifier;
    private boolean active;
    private Name name;
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
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
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
