package com.example.reservations.mvc.model;

import java.util.Date;

public class PlanFlight {

    private String from;
    private String to;
    private final Date date = new Date();

    public PlanFlight (String from, String to) {
        this.from = from;
        this.to = to;
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

    public Date getDate() {
        return date;
    }

}