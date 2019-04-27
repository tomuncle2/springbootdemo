package com.caidi.springbootdemo.controller;

import ch.qos.logback.core.util.FileUtil;
import com.caidi.springbootdemo.domain.Person;
import com.caidi.springbootdemo.service.DownExcelService;
import com.caidi.springbootdemo.service.impl.DownExcelServiceImpl;
import com.caidi.springbootdemo.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Autowired
    private DownExcelService downExcelService;

    @GetMapping(value="helloword")
    public String HelloWord(){
        return "hello word !!";
    }

    @GetMapping(value="downexcel")
    public void export(HttpServletResponse response){

        downExcelService.downExcel(response);
    }

    @RequestMapping("importExcel")
    public void importExcel(){
        String filePath = "F:\\������.xls";
        //����excel��
        List<Person> personList = ExcelUtil.importExcel(filePath,1,1,Person.class);
        //Ҳ����ʹ��MultipartFile,ʹ�� FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)����
        System.out.println("��������һ����"+personList.size()+"����");

        //TODO �������ݿ�
    }


}
