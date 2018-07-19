package com.aws.devops.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phone_contact_info")
public class PhoneContactInfo extends ContactInfo {
    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneContactInfo() {
    }
}
