package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="clients_id_seq")
    @SequenceGenerator(name="clients_id_seq", sequenceName="clients_id_seq", allocationSize=3)
    private Long id;

    @Column(name="SECURITY_NUMBER")
    private  Long securityNumber;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="PHONE")
    private String phone;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="ADDRESS")
    private String address;

    /*  @GeneratedValue(strategy = GenerationType.IDENTITY)*/

    protected Client() {
        this.securityNumber = null;
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.country = "";
        this.address = "";
    }
    public Client(Long securityNumber,
                        String firstName,
                        String lastName,
                        String phone,
                        String country,
                        String address) {
        this.securityNumber = securityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
        this.address = address;
    }
    public Client(Long securityNumber,
                  String firstName,
                  String lastName) {
        this.securityNumber = securityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = "";
        this.country = "";
        this.address = "";
    }
    public Long getId() {
        return id;
    }
    public Long getSecurityNumber() {
        return securityNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getCountry() {
        return country;
    }
    public String getAddress() {
        return address;
    }

    public void setSecurityNumber(Long securityNumber) {
        this.securityNumber = securityNumber;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPhone( String phone) {
        this.phone = phone;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ClientEntity [id="+id+", firstName="+firstName+
                ", lastName="+lastName +
                ", securityNumber="+securityNumber +
                ", phone="+phone +
                ", address="+address +
                ", country="+country +
                "]";
    }
}
