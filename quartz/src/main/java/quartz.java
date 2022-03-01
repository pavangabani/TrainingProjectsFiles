import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class quartz {
    public static void main(String[] args) {
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();
        try {
            Scheduler scheduler=schedulerFactory.getScheduler();

            JobDetail job= JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("myJob","group1")
                    .usingJobData("jobSays","Hello World")
                    .usingJobData("myFloatValue","3.14f")
                    .build();
            Trigger trigger=TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger","grou1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                    .build();

            scheduler.scheduleJob(job,trigger);

            JobDetail jobA=JobBuilder.newJob(JobA.class)
                    .withIdentity("jobA","group2")
                    .build();

            JobDetail jobB=JobBuilder.newJob(JobB.class)
                    .withIdentity("jobB","group2")
                    .build();

            Trigger triggerA=TriggerBuilder.newTrigger()
                    .withIdentity("triggerA","group2")
                    .startNow()
                    .withPriority(15)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .build();

            Trigger triggerB=TriggerBuilder.newTrigger()
                    .withIdentity("triggerB","group2")
                    .startNow()
                    .withPriority(10)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                    .build();

            scheduler.scheduleJob(jobA,triggerA);
            scheduler.scheduleJob(jobB,triggerB);
            scheduler.start();

        }catch (Exception e){

        }
    }
}
