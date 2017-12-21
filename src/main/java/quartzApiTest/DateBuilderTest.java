package quartzApiTest;

import org.joda.time.DateTime;
import org.junit.Test;
import org.quartz.DateBuilder;

import java.util.Date;

public class DateBuilderTest {

    @Test
    public void testFutureDate() {
        //创建一个未来的某个时间点
        Date date1 = DateBuilder.futureDate(4, DateBuilder.IntervalUnit.MINUTE);
        System.out.println(date1);

        //使用DateTime
        Date date2 = DateTime.now().plusMinutes(4).toDate();
        System.out.println(date2);


    }


    @Test
    public void testFutureDate1() {
        //创建一个未来的某个时间点
        Date date1 = DateBuilder.futureDate(4, DateBuilder.IntervalUnit.MINUTE);
        System.out.println(date1);


        Date date = DateBuilder.dateOf(16, 1, 12);
        System.out.println(date);


    }

}
