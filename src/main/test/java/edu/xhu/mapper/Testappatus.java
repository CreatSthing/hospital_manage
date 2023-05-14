package edu.xhu.mapper;

import edu.xhu.pojo.Appartus;
import edu.xhu.xhuapplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@SpringBootTest(classes = xhuapplication.class)
@RunWith(SpringRunner.class)
public class Testappatus {
    @Autowired
    AppartusMapper appartusMapper;

    @Test
    public void getall() {
        List<Appartus> appartusList = appartusMapper.getall();
        System.out.println(appartusList);
    }

    @Test
    public void insert() {
        Appartus appartus = new Appartus("yq008", "针管", 10, 500, "病房专用");
        this.appartusMapper.insert(appartus);
    }
    @Test
    public void delete(){
        appartusMapper.delete(9);
    }
    @Test
    public void getbyid(){
        Appartus appartus = appartusMapper.getbyid(7);
        System.out.println(appartus);
    }
    @Test
    public void update(){
        Appartus appartus = new Appartus(9,"yq008", "针头", 10, 1000, "病房专用");
        appartusMapper.update(appartus);
    }
    @Test
    public void getcount(){
        int getcount = appartusMapper.getcount();
        System.out.println(getcount);
    }
    @Test
    public void querybypage(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("pageNow",1);
        map.put("pageSize",10);
        List<Appartus> list = appartusMapper.queryByPage(map);
        System.out.println(list);
    }

}
