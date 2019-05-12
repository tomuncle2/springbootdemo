package com.caidi.springbootdemo.controller;


import com.caidi.springbootdemo.domain.Person;
import com.caidi.springbootdemo.domain.User;
import com.caidi.springbootdemo.service.DownExcelService;
import com.caidi.springbootdemo.service.JPAService;
import com.caidi.springbootdemo.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {


//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private DownExcelService downExcelService;

    @Autowired
    private JPAService jpaService;

    @GetMapping(value="helloword")
    public String HelloWord(HttpServletRequest request){
        /**/
        HttpSession session = request.getSession();
        return "hello word !!";
    }

    @GetMapping(value="downexcel")
    public void export(HttpServletResponse response){

        downExcelService.downExcel(response);
    }

    /**
     * @Author 蔡迪
     * @Description //easypoi导入
     * @Date 9:36 2019/4/23
     * @Param [request]
     * @return void
     **/
    @RequestMapping("importExcel")
    public void importExcel(HttpServletRequest request){
        //解析excel，
        String filePath="//海贼王.xsl";
        List<Person> personList = ExcelUtil.importExcel(filePath,1,1,Person.class);
    }


    /**
     * @Author 蔡迪
     * @Description //jpa测试
     * @Date 9:36 2019/4/23
     * @Param [request]
     * @return void
     **/
    @RequestMapping("listAllUser")
    public List<User> listAllUser(){

        List<User>  listUser = jpaService.listUser();
        return listUser;
    }

}
