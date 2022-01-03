//package io.cucumber.skeleton;
//
//import org.junit.Test;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//public class NetworkTests {
//    @Test
//    public void broadcasts_a_message_to_all_listeners() {
//        Network network = new Network();
//        String message = "Free bagels!";
//
//        Person lucy = mock(Person.class);
//        network.subscribe(lucy);
//        network.broadcast(message, lucy.location);
//        verify(lucy).hear(message);
//    }
//}
