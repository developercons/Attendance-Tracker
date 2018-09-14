package com.attendance_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Owner")
@Table(name = "owner")
public class Owner extends User {

    // region PROPERTIES
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    // endregion

    // region GETTERS / SETTERS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}
