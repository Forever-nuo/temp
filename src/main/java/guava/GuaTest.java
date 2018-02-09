package guava;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Forever丶诺 on 2018/2/9.
 */
public class GuaTest {

    @Test
    public void testJdkList() {
        List<String> nameList= new ArrayList<String>();
        nameList.add("测试1");
        nameList.add("测试2");
        nameList.add("测试3");
        nameList.add("测试4");
        System.out.println(nameList);
    }

    @Test
    public void testGuavaList() {
        ArrayList<String> nameList = Lists.newArrayList();
        nameList.add("测试1");
        nameList.add("测试2");
        nameList.add("测试3");
        nameList.add("测试4");
        System.out.println(nameList);
    }

}
