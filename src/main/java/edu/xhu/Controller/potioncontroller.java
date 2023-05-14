package edu.xhu.Controller;

import edu.xhu.comon.JsonResult;
import edu.xhu.comon.R;
import edu.xhu.pojo.potion;
import edu.xhu.service.potionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/potion")
public class potioncontroller {
    @Autowired
    private potionservice appartusservice;

    //   查询所有用户，后面用分页未使用
    @GetMapping("/getallappertus")
    public JsonResult getallappartus() {
        JsonResult r = appartusservice.getallappartus();
        return r;

    }

    //分页查询接口
    @GetMapping("/querybypage")
    public JsonResult querybypage(int page, int limit) {
        return appartusservice.queryByPage(page, limit);
    }

    //增添仪器
    @GetMapping("/addappartus")
    public R addappartus(potion appartus) {
        R r = appartusservice.addappartus(appartus);
        return r;
    }

    //    删除仪器
    @GetMapping("/deleteappartus")
    public R deleteappaetus(int id) {
        R r = appartusservice.deleteappartus(id);
        return r;
    }

    //    修改仪器
    @GetMapping("updateappartus")
    public R updateappartus(potion appartus) {
        R r = appartusservice.updateappartus(appartus);
        return r;
    }

    //     id查询
    @GetMapping("getappartusbyid")
    public JsonResult getappartusbyid(int id) {
        JsonResult jsonResult = appartusservice.getappartusbyid(id);
        return jsonResult;
    }

    //     编号查询
    @GetMapping("getappartusbyno")
    public JsonResult getappartusbyno(String no) {
        JsonResult jsonResult = appartusservice.getappartusbyno(no);
        return jsonResult;
    }

    //    名称查询
    @GetMapping("getappartusbyname")
    public JsonResult getappartusbyname(String name) {
        JsonResult jsonResult = appartusservice.getappartusbyname(name);
        return jsonResult;
    }

    //查询按钮的接口
    @GetMapping("search")
    public JsonResult search(String no, String name) {
        JsonResult searchres = appartusservice.Search(no, name);
        return searchres;
    }
}
