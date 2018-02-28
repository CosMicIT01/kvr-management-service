package de.cosmicit.kvr.model.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.cosmicit.kvr.model.deserializers.CollectionDeserializer;
import de.cosmicit.kvr.model.deserializers.UTCDateTimeDeserializer;
import de.cosmicit.kvr.model.serializers.CollectionSerializer;
import de.cosmicit.kvr.model.serializers.UTCDateTimeSerializer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tbl_registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "registration_id", unique = true, nullable = false)
    private Long id;


    @Column(name = "last_registration_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@org.hibernate.annotations.Parameter(name = "databaseZone", value = "UTC"), @org.hibernate.annotations.Parameter(name = "javaZone", value = "jvm")})
    @JsonDeserialize(using = UTCDateTimeDeserializer.class)
    @JsonSerialize(using = UTCDateTimeSerializer.class)
    private LocalDate lastRegistrationDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Address address;

    @Column(name = "registered_person")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "registration")
    @JsonSerialize(using = CollectionSerializer.class)
    @JsonDeserialize(using = CollectionDeserializer.class)
    private Set<Person> registeredPersons = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLastRegistrationDate() {
        return lastRegistrationDate;
    }

    public void setLastRegistrationDate(LocalDate lastRegistrationDate) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Person> getRegisteredPersons() {
        return registeredPersons;
    }

    public void setRegisteredPersons(Set<Person> registeredPersons) {
        if (!this.registeredPersons.isEmpty()) {
            this.registeredPersons.forEach((Person registeredUser) -> registeredUser.setRegistration(null));
            this.registeredPersons.clear();
        }
        registeredPersons.forEach((Person registeredUser) -> registeredUser.setRegistration(this));
        this.registeredPersons.addAll(registeredPersons);
    }

    public void addRegisteredPerson(Person registeredPerson) {
        if (!this.registeredPersons.contains(registeredPerson)) {
            this.registeredPersons.add(registeredPerson);
        }
    }
}
