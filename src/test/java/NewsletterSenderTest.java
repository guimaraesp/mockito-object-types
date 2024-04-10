import github.guimaraesp.MessagingEngine;
import github.guimaraesp.NewsletterSender;
import github.guimaraesp.SubscribersDatabase;
import github.guimaraesp.ZeroSubscribersException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewsletterSenderTest {

    @Test
    public void constructorAssignsDatabase_mock() {

        // null behavior class created by mockito
        MessagingEngine messagingEngine = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabase, messagingEngine);

        assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers_stub() {

        SubscribersDatabase subscribersDatabaseMock = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);

        NewsletterSender sender = new NewsletterSender(subscribersDatabaseMock, messagingEngineMock);

        List<String> subscribersList = Arrays.asList("email1", "email2", "email3");
        // stubs tells how to respond when a specific behavior (method) is called
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribersList);

        assertEquals(3, sender.numberOfSubscribers());
    }

    @Test
    public void zeroSubscribersThrown_spy() {

        NewsletterSender newsletterSender = new NewsletterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsletterSender newsletterSenderSpy = spy(newsletterSender);

        when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0);

        // In adition to stubs, spys can modify not only 1 behavior (method or attribute)
        // but all of them if necessary to simulate a real life scenario
        Exception exception = assertThrows(ZeroSubscribersException.class, () -> newsletterSenderSpy.sendNewsletter("SUBJECT"));
        System.out.println(exception.getMessage());
        assertEquals("You do not have any subscribers buddy :(", exception.getMessage());

    }
}