import com.github.brainlag.nsq.NSQConsumer;
import com.github.brainlag.nsq.lookup.DefaultNSQLookup;
import com.github.brainlag.nsq.lookup.NSQLookup;

public class Consumer
{
    public static void main(String[] args)
    {
        int processorCount = Runtime.getRuntime().availableProcessors();

        System.out.println(processorCount);
    }
}
