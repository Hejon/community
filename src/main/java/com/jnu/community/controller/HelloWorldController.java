package com.jnu.community.controller;

import com.jnu.community.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RequestMapping(path="/test")
@Controller
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Spring Boot.";
    }

    @RequestMapping("/getService")
    @ResponseBody
    public String getService(){
        return helloWorldService.getDao();
    }

    @RequestMapping(path = "/processReq", method = RequestMethod.GET)
    public void processReq(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getContextPath());
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " " + value);
        }

        response.setContentType("text/html; charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
                ){
            writer.write("<h1> 暨南大学 </h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(path = "/getPageInfo", method = RequestMethod.GET)
    @ResponseBody
    public String getPageInfo(@RequestParam(name = "cur", defaultValue = "1", required = false) int cur,
                              @RequestParam(name = "limit", defaultValue = "10", required = false) int limit){
        System.out.println(cur);
        System.out.println(limit);
        return "Page Info";
    }

    @RequestMapping(path = "/getStu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStu(@PathVariable(name = "id") int id){
        System.out.println(id);
        return "a student.";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String getStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "get a student from a form.";
    }

    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "hangman");
        mav.addObject("age", 40);
        mav.setViewName("/demo/view");
        return mav;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name", "JNU");
        model.addAttribute("age", 115);
        return "/demo/view";
    }

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "zhangsan");
        emp.put("age", 39);
        emp.put("salary", 8000);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> emps = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "zhangsan");
        emp.put("age", 39);
        emp.put("salary", 8000);
        emps.add(emp);

        Map<String, Object> emp2 = new HashMap<>();
        emp2.put("name", "lisi");
        emp2.put("age", 45);
        emp2.put("salary", 9000);
        emps.add(emp2);

        Map<String, Object> emp3 = new HashMap<>();
        emp3.put("name", "wangwu");
        emp3.put("age", 30);
        emp3.put("salary", 10000);
        emps.add(emp3);

        return emps;

    }
}
