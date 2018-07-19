package com.aws.devops.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_contact_info")
public class EmailContactInfo extends ContactInfo {
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmailContactInfo() {

    }
}
