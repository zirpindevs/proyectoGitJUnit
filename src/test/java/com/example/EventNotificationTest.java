package com.example;

import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;
import org.junit.jupiter.api.Assertions;
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

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
/*
@MockitoSettings(strictness = Strictness.LENIENT)
*/
class EventNotificationTest {

    //DEPENDENCIA
    @Mock
    Event eventTester;

    // SUT
    @InjectMocks
    EventNotificationService eventNotificationService = new EventNotificationServiceImpl();


    @Test
    @DisplayName("check announce with mockito test")
    public void checkAnnounceMockitoTest()
    {
        ArrayList<Attendee> attendeeList = new ArrayList<>();
        Attendee attendee1 = new Attendee(1L,"thor","thor@email.es");
        Attendee attendee2 = new Attendee(2L,"loki","loki@email.es");

        attendeeList.add(0,attendee1);
        attendeeList.add(1,attendee2);

        eventTester.addAttendees(attendeeList);
        eventTester.setAttendees(attendeeList);

        when(eventTester.getAttendees()).thenReturn(attendeeList);
        eventNotificationService.announce(eventTester);
        verify(eventTester, times(3)).getAttendees();

    }


}