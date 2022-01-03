//package io.cucumber.skeleton;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//public class PersonTests {
//    private final Network network = mock(Network.class);
//
//    @Test
//    public void it_subscribes_to_the_network() {
//        Person lucy = new Person("lucy");
//        lucy.setNetwork(network);
////        verify(network).subscribe(lucy);
//    }
//
//    @Test
//    public void broadcasts_shouts_to_the_network() {
//        String message = "Free bagels!";
//        Person sean = new Person("sean");
//        sean.setNetwork(network);
//        sean.shout(message);
//        verify(network).broadcast(message);
//    }
//
//    @Test
//    public void remembers_messages_heard() {
//        String message = "Free bagels!";
//        Person lucy = new Person("lucy");
//        lucy.setNetwork(network);
//        lucy.Hear(message);
//        Assert.assertEquals(List.of(message), lucy.getMessagesHeard());
//    }
//}