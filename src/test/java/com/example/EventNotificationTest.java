package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Class EventNotificationTest
 * @Author Javier Moreno
 *
 *  * Test class that check interactions of eventNotificationService Class with:
 *      * EventNotificationServiceImpl class
 *      * Notification class
 *
 */
@ExtendWith(MockitoExtension.class)
class EventNotificationTest {


    /**
     *
     * Check mockito tests
     *
     * This function test with a mock method
     * The Mock will be a Event instance
     * The SUT will be EventNotificationServiceImpl instance
     * Adding attendee users to a list and then checking the 3 interactions produced.
     *
     */

    @Mock
    Event eventTester;

    @InjectMocks
    EventNotificationService eventNotificationService = new EventNotificationServiceImpl();


    @Test
    @DisplayName("Check mockito tests")
    public void checkMockitoTests()
    {
        ArrayList<Attendee> attendeeList = new ArrayList<>();
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        Attendee attendee2 = new Attendee(2L,"loki","loki@email.es");

        attendeeList.add(0,attendee1);
        attendeeList.add(1,attendee2);

        eventTester.addAttendees(attendeeList);

        when(eventTester.getAttendees()).thenReturn(attendeeList);
        eventNotificationService.announce(eventTester);
        eventNotificationService.confirmAttendance(eventTester, attendee1);
        verify(eventTester, times(3)).getAttendees();
    }


    /**
     * Test create notification
     * Check create a notification constructor with a String and return gets values
     */

    @Test
    @DisplayName("Test create notification")
    public void testCreateNotification()
    {
        String messageTest = "Hello this is a test!";
        Notification notificationtest = new Notification(messageTest);
        assertEquals(messageTest,notificationtest.getMessage());
    }

    /**
     * Test set message notification
     * Check set a notification void constructor and then set String message
     */

    @Test
    @DisplayName("Test set message notification")
    public void testSetMessageNotification()
    {
        Notification notificationSet = new Notification();
        notificationSet.setMessage("this is a instert test message");
        assertNotNull(notificationSet);
    }

    @Test
    @DisplayName("Test add anew ttendee")
    public void TestAddAttendee()
    {
        Attendee attendee1 = new Attendee();
        Event eventTester = new Event();

        attendee1.setId(1L);
        attendee1.setNickname("horus");
        attendee1.setEmail("horus@email.es");

        eventTester.addAttendee(attendee1);;
        assertNotNull(attendee1);
        assertEquals(eventTester.getAttendees().size(),1);
    }

    @Test
    @DisplayName("Test expertise ")
    public void removeSpeaker()
    {
        Speaker speakerNormal = new Speaker();
        speakerNormal.setId(5L);
        speakerNormal.setExpertise("pro");
        speakerNormal.setName("Alfred");
        Event eventTester = new Event();
        eventTester.removeSpeaker(speakerNormal);
        assertEquals(eventTester.getSpeakers().size(),0);
    }
}