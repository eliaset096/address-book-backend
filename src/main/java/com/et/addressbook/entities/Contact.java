package com.et.addressbook.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
@NamedQuery(name="contact.findAll", query="SELECT u FROM Contact  u")
public class Contact implements Serializable {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cont_id")*/

    @Id
    //@SequenceGenerator(name="contact_contId_generator", sequenceName="contact_seq")
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contact_contId_generator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cont_id")
    private long contId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "company")
    private String company;
    @Column(name = "job_position")
    private String jobPosition;

    public Contact() {
    }
    public Contact(long contId, String firstName, String lastName, String phoneNumber, String email, String address, String company, String jobPosition) {
        this.contId = contId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.company = company;
        this.jobPosition = jobPosition;
    }

    public long getContId() {
        return contId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }
}
