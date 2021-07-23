package io.rushb.springbootdemo;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testOrderNo() {
        String orderCode = "NO";
        String currDateTimeStr = DateUtil.format(new Date(), "yyyyMMddHHmmssSSS");
        // need jdk 11+
        String prefix = currDateTimeStr.substring(2);
        Random random = new Random();
        String randomInt = String.valueOf(random.nextInt(90) + 10);
        String no = orderCode.concat(prefix).concat(randomInt);
        System.out.println(currDateTimeStr);

        System.out.println(orderCode);
        System.out.println(prefix);
        System.out.println(randomInt);

        System.out.println(no);
    }

}
