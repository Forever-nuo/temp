package quartz;

import org.quartz.*;

public class MyJob2 implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println(key);
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String nameValue = jobDataMap.getString("name");
        Integer ageValue = jobDataMap.getIntValue("age");
        System.out.println(nameValue +ageValue);
    }
}
