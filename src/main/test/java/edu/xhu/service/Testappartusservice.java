package edu.xhu.service;

import edu.xhu.comon.JsonResult;
import edu.xhu.xhuapplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = xhuapplication.class)
@RunWith(SpringRunner.class)
public class Testappartusservice {
    @Autowired
    appartusservice appartusservice;
    @Test
    public void testgetall(){
        JsonResult r = appartusservice.getallappartus();
        System.out.println(r.getData());


    }
}
