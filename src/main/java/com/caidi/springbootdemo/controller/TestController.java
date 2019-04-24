package com.caidi.springbootdemo.controller;


import com.caidi.springbootdemo.domain.Person;
import com.caidi.springbootdemo.service.DownExcelService;
import com.caidi.springbootdemo.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private DownExcelService downExcelService;

    @GetMapping(value="helloword")
    public String HelloWord(HttpServletRequest request){
        /**/
        HttpSession session = request.getSession();
        return "hello word !!";
    }

    /**
     * @Author 蔡迪
     * @Description //测试webmvcconfig视图
     * @Date 16:16 2019/4/23
     * @Param []
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping(value="testview")
    public ModelAndView Testview(){
        ModelAndView m  =new ModelAndView("/thymeleaf/test.html");
        m.addObject("name","测试view");
        return m;
    }


    /**
     * @Author 蔡迪
     * @Description //easypoi导出
     * @Date 9:35 2019/4/23
     * @Param [response]
     * @return void
     **/
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
        String filePath = "F:\\海贼王.xls";
        //解析excel，
        List<Person> personList = ExcelUtil.importExcel(filePath,1,1,Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");
    }


}
