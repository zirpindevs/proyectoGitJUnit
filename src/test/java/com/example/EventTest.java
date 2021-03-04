package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    @DisplayName("Test add attendee")
    public void addAttendee()
    {
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        System.out.println(attendee1.getId()+" "+attendee1.getNickname()+" "+ attendee1.getEmail());
        Event eventTester = new Event();
        eventTester.addAttendee(attendee1);;
        assertNotNull(attendee1);
        assertNotNull(eventTester);
    }

}