package de.cosmicit.kvr.model.entities;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tbl_contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "address_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "mobile_number")
    private String mobileNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
