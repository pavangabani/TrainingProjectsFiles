import com.github.brainlag.nsq.NSQProducer;
import com.github.brainlag.nsq.exceptions.NSQException;

import java.util.concurrent.TimeoutException;

public class Producer
{
    public static void main(String[] args) throws NSQException, TimeoutException
    {
        NSQProducer producer = new NSQProducer().addAddress("localhost", 4150).start();
        while (true){
            producer.produce("TestTopic2", ("this is a message").getBytes());
        }

    }
}
