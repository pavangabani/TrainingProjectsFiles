import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap=jobExecutionContext.getJobDetail().getJobDataMap();

        String jobSays=dataMap.getString("jobSays");
        float myFloatValue=dataMap.getFloat("myFloatValue");

        System.out.println("Job Says: "+jobSays+" val"+myFloatValue);
    }
}
