package com.example.reservations.mvc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
public class UserSignup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "c_firstname")
    private String firstName;
    @Column(name = "c_lastname")
    private String lastName;
    @Column(name = "c_username", unique = true)
    private String username;
    @Column(name = "c_password")
    private String password;
    @ManyToOne
    private TicketInfo ticket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TicketInfo getTicket() {
        return ticket;
    }

    public void setTicket(TicketInfo ticket) {
        this.ticket = ticket;
    }
}