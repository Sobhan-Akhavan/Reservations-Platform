package com.example.reservations.mvc.model;

import java.util.Date;

public class Charter implements Ticket {
    private final PlanFlight planFlight;

    public Charter(PlanFlight planFlights) {
        this.planFlight = planFlights;
    }

    @Override
    public String From() {
        return planFlight.getFrom();
    }

    @Override
    public String To() {
        return planFlight.getTo();
    }

    @Override
    public Date Time() {
        return planFlight.getDate();
    }

    @Override
    public String Type() {
        return "Charter";
    }

    @Override
    public String Price() {
        return "1,250,000";
    }

    @Override
    public String toString() {
        return "FirstClass Tickets: <br>" +
                "Plan Flights: <br>" +
                "From: " + this.From() + "<br>To: " + this.To() + "<br>" +
                "At: " + this.Time() + "<br>" +
                "Price: " + this.Price();
    }
}

