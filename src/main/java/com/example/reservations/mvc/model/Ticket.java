package com.example.reservations.mvc.model;

import java.util.Date;

public abstract interface Ticket {
    String From();
    String To();
    Date Time();
    String Type();
    String Price();
}
