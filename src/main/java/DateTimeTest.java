import com.sun.org.apache.xpath.internal.SourceTree;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeTest {


    public static final String dateformat = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD = "yyyy-MM-dd";


    /**
     * 创建某一个随意的时间点
     */
    @Test
    public void testGetTime1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.DECEMBER, 23, 10, 37);
        Date date = calendar.getTime();
        System.out.println(date);
    }


    /**
     * 创建某一个随意的时间点方式2
     */
    @Test
    public void testGetTime2() {
        DateTime dateTime = new DateTime(2017, 12, 23, 10, 37);
        Date date = dateTime.toDate();
        System.out.println(date);
    }


    /**
     * 得到某个时间点90天之后的日期
     */
    @Test
    public void testGetTimeAdd90Day1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.DECEMBER, 23, 10, 37);

        //添加90天
        calendar.add(Calendar.DAY_OF_MONTH, 90);

        Date date = calendar.getTime();
        System.out.println(date);
    }


    /**
     * 在某个时间点上+90天
     */
    @Test
    public void testGetTimeAdd90Day2() {
        DateTime dateTime = new DateTime(2017, 12, 23, 10, 37);
        dateTime.plusDays(90);
        System.out.println(dateTime.toDate());
    }


    /**
     * 45 天之后的某天在下一个月的当前周的最后一天的日期
     */
    @Test
    public void testGetSomeTimeWeekLastDay() {
        DateTime dateTime = new DateTime(2017, 12, 23, 10, 37);
        Date date = dateTime.plusDays(45).plusMonths(1).dayOfWeek().withMinimumValue().toDate();
        System.out.println(date);
    }


    /**
     * Joda 和 JDK 互操作性
     */
    @Test
    public void testChange() {
        Calendar calendar = Calendar.getInstance();

        DateTime dateTime = new DateTime(2017, 12, 23, 10, 37);
        String timeStr = dateTime.plusDays(45).plusMonths(1).dayOfWeek().withMinimumValue().toString("yyyy-MM-dd HH:mm");

        System.out.println(timeStr);


        //转换成Jdk Date对象
        Date date = dateTime.toDate();

        //转换成calendar对象
        calendar = dateTime.toCalendar(Locale.getDefault());
    }


    /**
     * 构造函数1
     * 空构造函数
     */
    @Test
    public void testDateTime1() {
        //输出当前时间
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString(dateformat));
    }

    /**
     * 构造函数2
     * 时间戳
     */
    @Test
    public void testDateTime2() {
        //使用当前毫秒值
        DateTime dateTime = new DateTime(System.currentTimeMillis());
        System.out.println(dateTime.toString(dateformat));
    }


    /**
     * 构造函数3
     * 使用Date对象
     */
    @Test
    public void testDateTime3() {
        Date date = new Date();
        //使用当前毫秒值
        DateTime dateTime = new DateTime(date);
        System.out.println(dateTime.toString(dateformat));
    }

    /**
     * 构造函数4
     * 使用多个字段
     */
    @Test
    public void testDateTime4() {
        //使用当前毫秒值
        DateTime dateTime = new DateTime(2019, 9, 12, 23, 22);
        System.out.println(dateTime.toString(dateformat));
        System.out.println(dateTime.toString(YMD));
        System.out.println(dateTime.toLocalDate().toString());
    }


    /**
     * 只有年月日的对象
     */
    @Test
    public void testGetNowTime() {
        LocalDate localDate = new LocalDate();
        String time = localDate.toString();
        System.out.println(time);
    }


    /**
     * 上个月的最后一天
     */
    @Test
    public void testGetLastMonthTime() {
        LocalDate now = LocalDate.now();
        System.out.println(now.minusMonths(1).dayOfMonth().withMaximumValue().toString());
    }


    /**
     * 得到某个月的第一个星期2
     */
    @Test
    public void test1() {
        LocalDate date = new LocalDate(2017, 12, 15);
        LocalDate localDate = date
                .monthOfYear().setCopy(11).//得到1年中的11月份
                dayOfMonth().withMinimumValue()//得到11月份中的第一天
                .plusDays(6).dayOfWeek().setCopy(1) //+6天 得到第一个星期一
                .plusDays(1); //+1天 得到第一个星期二
        System.out.println(localDate.toString());
    }


    /**
     * 计算5年后的第二个月的最后一天
     */
    @Test
    public void test2() {
        LocalDate now = LocalDate.now();
        String time = now.minusYears(5).monthOfYear().setCopy(2).dayOfMonth().withMaximumValue().toString();
        System.out.println(time);
    }


    /**
     * 格式化时间打印 1
     * 使用 ISO-8601
     */
    @Test
    public void testFormatTime1() {
        DateTime now = DateTime.now();

        System.out.println(now.toString(ISODateTimeFormat.basicDateTime()));
        System.out.println(now.toString(ISODateTimeFormat.basicDateTimeNoMillis()));
        System.out.println(now.toString(ISODateTimeFormat.basicOrdinalDateTime()));
        System.out.println(now.toString(ISODateTimeFormat.basicWeekDateTime()));
    }

    /**
     * 格式化打印2
     * <p>
     * 使用DateFormat字符串
     */
    @Test
    public void testFormatTime2() {
        DateTime now = DateTime.now();

        System.out.println(now.toString("MM/dd/yyyy hh:mm:ss.SSSa"));
        System.out.println(now.toString("dd-MM-yyyy HH:mm:ss"));

    }




}
