package de.cosmicit.kvr.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tbl_user")
public class User {

    public enum Gender {
        FEMALE,
        MALE;

        @JsonValue
        public String value() {
            return this.name().toLowerCase();
        }
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_username")
    private String userName;

    @Column(name = "user_firstname")
    private String firstName;

    @Column(name = "user_lastname")
    private String lastName;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "user_gender")
    private Gender gender;

    @Column(name = "user_street")
    private String street;

    @Column(name = "user_housenumber")
    private String houseNumber;

    @Column(name = "user_zipcode")
    private String zipcode;

    @Column(name = "user_city")
    private String city;

    @Column(name = "user_country")
    private String country;

    public Long getId() {
        return this.id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
