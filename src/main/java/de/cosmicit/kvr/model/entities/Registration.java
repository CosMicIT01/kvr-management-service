package de.cosmicit.kvr.model.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.cosmicit.kvr.model.deserializers.ReferenceDeserializer;
import de.cosmicit.kvr.model.deserializers.UTCDateTimeDeserializer;
import de.cosmicit.kvr.model.serializers.UTCDateTimeSerializer;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tbl_registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @Column(name = "registrationdate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"), @org.hibernate.annotations.Parameter(name = "javaZone", value = "jvm")})
    @JsonDeserialize(using = UTCDateTimeDeserializer.class)
    @JsonSerialize(using = UTCDateTimeSerializer.class)
    private DateTime registrationDate;

    @Column(name = "lastregistrationdate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"), @org.hibernate.annotations.Parameter(name = "javaZone", value = "jvm")})
    @JsonDeserialize(using = UTCDateTimeDeserializer.class)
    @JsonSerialize(using = UTCDateTimeSerializer.class)
    private DateTime lastRegistrationDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifiedby")
    private String modifiedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currentaddress")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonDeserialize(using = ReferenceDeserializer.class)
    private Address currentAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "previousaddress")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonDeserialize(using = ReferenceDeserializer.class)
    private Address previousAddress;


    @Column(name = "createddate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"), @org.hibernate.annotations.Parameter(name = "javaZone", value = "jvm")})
    @JsonDeserialize(using = UTCDateTimeDeserializer.class)
    @JsonSerialize(using = UTCDateTimeSerializer.class)
    private DateTime createdDate;


    @Column(name = "modifieddate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"), @org.hibernate.annotations.Parameter(name = "javaZone", value = "jvm")})
    @JsonDeserialize(using = UTCDateTimeDeserializer.class)
    @JsonSerialize(using = UTCDateTimeSerializer.class)
    private DateTime modifiedDate;

//    @Column(name = "registered_person")
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "registration")
//    @JsonSerialize(using = CollectionSerializer.class)
//    @JsonDeserialize(using = CollectionDeserializer.class)
//    private Set<Person> registeredPersons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getLastRegistrationDate() {
        return lastRegistrationDate;
    }

    public void setLastRegistrationDate(DateTime lastRegistrationDate) {
        this.lastRegistrationDate = lastRegistrationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public Address getPreviousAddress() {
        return previousAddress;
    }

    public void setPreviousAddress(Address previousAddress) {
        this.previousAddress = previousAddress;
    }

    //    public Set<Person> getRegisteredPersons() {
//        return registeredPersons;
//    }
//
//    public void setRegisteredPersons(Set<Person> registeredPersons) {
//        if (!this.registeredPersons.isEmpty()) {
//            this.registeredPersons.forEach((Person registeredUser) -> registeredUser.setRegistration(null));
//            this.registeredPersons.clear();
//        }
//        registeredPersons.forEach((Person registeredUser) -> registeredUser.setRegistration(this));
//        this.registeredPersons.addAll(registeredPersons);
//    }
//
//    public void addRegisteredPerson(Person registeredPerson) {
//        if (!this.registeredPersons.contains(registeredPerson)) {
//            this.registeredPersons.add(registeredPerson);
//        }
//    }


    public DateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(DateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public DateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(DateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
