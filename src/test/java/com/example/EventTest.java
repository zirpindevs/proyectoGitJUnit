package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class EventTest
 * @Author Javier Moreno
 *
 * Test class that check interactions of Event Class with Attendee, EventType and Speaker classes
 *
 */

class EventTest {

    /**
     * Test Event Constructors
     *
     * Check Event void constructor
     * Check Event constructor with arguments
     *
     */
    @Test
    @DisplayName("Test event constructors")
    public void testEventConstructor()
    {
        EventNotificationService myEventServ = new EventNotificationServiceImpl();
        Event eventManualTester = new Event();
        Event eventTester = new Event(1L, "java conference", EventType.TECH, myEventServ);
        assertNotNull(eventTester);

        eventManualTester.setId(2L);
        eventManualTester.setTitle("Manual setter");
        eventManualTester.setType(EventType.BUSINESS);

        assertEquals(2L, eventManualTester.getId());
        assertNotEquals("java conference", eventManualTester.getTitle());
        assertEquals(EventType.BUSINESS, eventManualTester.getType());

    }

    /**
     * Test Add a Attendee
     * It creates an attendee instance and then add it from a Event instance
     *
     */
    @Test
    @DisplayName("Test add attendee")
    public void TestAddAttendee()
    {
        Attendee attendee1 = new Attendee();
        Event eventTester = new Event();

        attendee1.setId(1L);
        attendee1.setNickname("thor");
        attendee1.setEmail("thor@email.es");

        eventTester.addAttendee(attendee1);;
        assertNotNull(attendee1);
        assertEquals(eventTester.getAttendees().size(),1);
    }


    /**
     * Test add and set attendees
     * 
     * This class creates a couple of attendee instances and at it to a list to check
     */
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
        assertEquals((long) attendeeList.size(),2);

    }

    /**
     * Test remove an attendee object
     *
     */
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

    /**
     * Test remove attendees
     * It creates a couple of attendees and added to a list for them test to remove with assert
     */
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

    /**
     * Test create a speaker
     *  Check Speaker void constructor
     *  Check Speaker constructor with arguments
     */
    @Test
    @DisplayName("Test create speaker")
    public void createSpeaker()
    {
        Speaker speakerSenior = new Speaker(1L,"John","senior");
        Speaker speakerNull = new Speaker();
        Event eventTester = new Event();
        eventTester.addSpeaker(speakerSenior);
        assertNotNull(speakerNull);
        assertNotNull(eventTester);
        assertEquals(eventTester.getSpeakers().size(),1);
        }

    /**
     * Test remove speaker
     * Check create a speaker and then remove it from a Event instance
     */
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

    /**
     * Test add and set speakers
     *
     * This class creates a couple of speakers instances and at it to a list to check
     */
    @Test
    @DisplayName("Test add and set speakers")
    public void testAddSpeakers()
    {
        Event eventTester = new Event();
        List<Speaker> speakersList = new ArrayList<Speaker>();
        Speaker speakerSenior = new Speaker(1L,"John","senior");
        Speaker speakerNormal = new Speaker(2L,"Jim","normal");

        assertFalse(speakerSenior.equals(speakerNormal));


        speakersList.add(speakerSenior);
        speakersList.add(speakerNormal);

        eventTester.setSpeakers(speakersList);

        assertNotNull(eventTester.getSpeakers());
        assertEquals(speakersList.stream().count(),2);

    }

}