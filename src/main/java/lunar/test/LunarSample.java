package lunar.test;


import com.forever.util.lunar.Lunar;

/**
 * 阴历示例
 * @author 6tail
 *
 */
public class LunarSample{
  public static void main(String[] args){
    //今天
    Lunar date = new Lunar();
    //输出阴历信息
    System.out.println(date.toFullString());
    //输出阳历信息
    System.out.println(date.getSolar().toFullString());
    System.out.println();
    //指定阴历的某一天
    date = new Lunar(1986,4,21);
    System.out.println(date.toFullString());
    System.out.println(date.getSolar().toFullString());
  }
}