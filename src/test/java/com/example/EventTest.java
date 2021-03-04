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
        Attendee attendee1 = new Attendee();
        attendee1.setId(1L);
        attendee1.setNickname("thor");
        attendee1.setEmail("thor@email.es");

        Event eventTester = new Event();
        eventTester.addAttendee(attendee1);;
        assertNotNull(attendee1);
        assertEquals(eventTester.getAttendees().size(),1);
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


    @Test
    @DisplayName("Test remove attendee object")
    public void testRemoveAttendee()
    {
        Event eventTester = new Event();
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        eventTester.addAttendee(attendee1);

        assertNotNull(attendee1);
        assertEquals(eventTester.getAttendees().size(), 1);

        eventTester.removeAttendee(attendee1);
        assertEquals(eventTester.getAttendees().size(), 0);
    }

    @Test
    @DisplayName("Test remove attendees")
    public void testRemoveAttendes()
    {
        Event eventTester = new Event();
        ArrayList<Attendee> attendeeList = new ArrayList<>();
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        Attendee attendee2 = new Attendee(2L,"loki","loki@email.es");

        attendeeList.add(0,attendee1);
        attendeeList.add(1,attendee2);

        eventTester.setAttendees(attendeeList);

        eventTester.removeAttendees(attendeeList);;

        assertEquals(attendeeList.stream().count(), 0);
    }

    @Test
    @DisplayName("Test create speaker")
    public void createSpeaker()
    {
        Speaker speakerSenior = new Speaker(1L,"John","senior");
        Speaker speakerNull = new Speaker();
        Event eventTester = new Event();
        eventTester.addSpeaker(speakerSenior);
        assertNotNull(eventTester);
        assertEquals(eventTester.getSpeakers().size(),1);
        }

    @Test
    @DisplayName("Test remove speaker")
    public void removeSpeaker()
    {
        Speaker speakerNormal = new Speaker();
        speakerNormal.setId(2L);
        speakerNormal.setName("Jim");
        speakerNormal.setExpertise("normal");
        Event eventTester = new Event();
        eventTester.removeSpeaker(speakerNormal);
        assertEquals(eventTester.getSpeakers().size(),0);
    }
}