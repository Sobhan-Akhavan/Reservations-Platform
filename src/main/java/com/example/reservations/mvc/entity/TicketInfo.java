package com.example.reservations.mvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_ticket")
public class TicketInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "c_from")
    private String from;
    @Column(name = "c_to")
    private String to;
    @Column(name = "c_price")
    private String price;
    @Column(name = "c_time")
    private Date time;
    @OneToMany(mappedBy = "ticket")
    private List<UserSignup> users = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<UserSignup> getUsers() {
        return users;
    }

    public void setUsers(List<UserSignup> users) {
        this.users = users;
    }
}
