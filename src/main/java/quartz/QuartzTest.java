package quartz;

import org.joda.time.DateTime;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuartzTest {


    public static void test1() throws SchedulerException {

        //通过SchedulerFactory 获取一个调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //创建JobDetail实例,绑定Job实现类
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();


        Trigger trigger = TriggerBuilder.newTrigger().startNow().build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        scheduler.start();

    }

    /**
     * 使用JobDataMap 传输数据
     *
     * @throws SchedulerException
     */
    public static void test2() throws SchedulerException {
        //获取调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "张三");
        jobDataMap.put("age", 15);

        //获取工作类
        JobDetail jobDetail = JobBuilder.newJob(MyJob2.class).usingJobData(jobDataMap).build();

        //触发器执行的开始时间
        Date triggerStartTime = DateTime.now().plusSeconds(10).toDate();


        //获取触发器
        Trigger trigger = TriggerBuilder.newTrigger().startAt(triggerStartTime).build();


        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();


    }


    /**
     * 每隔多少秒执行一次
     */
    public void test3() throws SchedulerException {
        //创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //创建工作任务
        JobDetail job = JobBuilder.newJob(MyJob.class).build();

        //创建调度器 (每隔5秒执行一次,总共执行10次)
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(10)).build();


        scheduler.scheduleJob(job,trigger);
        scheduler.start();

    }



    /**
     * 每隔多少秒执行一次
     */
    public void test4() throws SchedulerException {
        //创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //创建工作任务
        JobDetail job = JobBuilder.newJob(MyJob.class).build();

        //创建调度器 (每隔5秒执行一次,总共执行10次)
        SimpleTrigger trigger = TriggerBuilder.newTrigger().startAt(DateBuilder.futureDate(5, DateBuilder.IntervalUnit.MINUTE)).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(10)).build();


        scheduler.scheduleJob(job,trigger);
        scheduler.start();

    }


    public static void main(String[] args) throws SchedulerException {
        QuartzTest quartzTest = new QuartzTest();
        quartzTest.test3();

        //test2();
    }
}
