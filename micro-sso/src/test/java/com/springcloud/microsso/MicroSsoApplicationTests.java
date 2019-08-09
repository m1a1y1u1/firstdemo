package com.springcloud.microsso;

import com.springcloud.microcommon.config.httpclient.HttpAPIService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroSsoApplicationTests {

    @Autowired
    private HttpAPIService httpAPIService;

    @Test
    public void contextLoads() {
        String str = null;
        for (int i = 0; i < 2; i++){
            try {
                str = httpAPIService.doGet("http://www.baidu.com");
            } catch (Throwable e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i+"; "+str);
        }
    }

}
