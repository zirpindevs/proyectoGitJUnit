package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    @DisplayName("Test event constructor")
    public void testEventConstructor()
    {
        EventType techType = EventType.TECH;
        EventNotificationService myEventServ = new EventNotificationServiceImpl();

        Event eventTester = new Event(1L, "java conference", techType, myEventServ);
        assertNotNull(eventTester);

    }
    @Test
    @DisplayName("Test add attendee")
    public void TestAddAttendee()
    {
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        System.out.println(attendee1.getId()+" "+attendee1.getNickname()+" "+ attendee1.getEmail());
        Event eventTester = new Event();
        eventTester.addAttendee(attendee1);;
        assertNotNull(attendee1);
        assertNotNull(eventTester);
    }

    @Test
    @DisplayName("Test add and set attendees")
    public void testAddAttendees()
    {
        Event eventTester = new Event();
        ArrayList<Attendee> attendeeList = new ArrayList<>();
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        Attendee attendee2 = new Attendee(2L,"loki","loki@email.es");

        attendeeList.add(0,attendee1);
        attendeeList.add(1,attendee2);

        eventTester.addAttendees(attendeeList);
        eventTester.setAttendees(attendeeList);

        assertNotNull(eventTester.getAttendees());
        assertEquals(attendeeList.stream().count(),2);

    }



}