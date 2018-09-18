package com.example.panda.controller;

import com.example.panda.mapper.PeopleMapper;
import com.example.panda.pojo.People;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PeopleController {
    @Autowired
    PeopleMapper peopleMapper;

    /*@RequestMapping("/listPeople")
    public String listPeople(Model m) throws Exception {
        List<People> cs=peopleMapper.findAll();

        m.addAttribute("cs", cs);

        return "listPeople";
    }*/

    @RequestMapping("/listPeople")
    public ModelAndView listCategory(ModelAndView m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<People> cs=peopleMapper.findAll();
        PageInfo<People> page = new PageInfo<>(cs);
        m.addObject("page", page);
        m.setViewName("listPeople");
        return m;
    }

    @RequestMapping("/addPeople")
    public ModelAndView addPeople(People c) throws Exception {
        peopleMapper.save(c);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:listPeople");
        return mv;
    }
    @RequestMapping("/deletePeople")
    public ModelAndView deletePeople(People c) throws Exception {
        peopleMapper.delete(c.getId());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:listPeople");
        return mv;
    }
    @RequestMapping("/updatePeople")
    public ModelAndView updatePeople(People c) throws Exception {
        peopleMapper.update(c);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:listPeople");
        return mv;
    }
    @RequestMapping("/editPeople")
    public ModelAndView getPeople(int id,Model m) throws Exception {
        People c= peopleMapper.get(id);
        m.addAttribute("c", c);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editPeople");
        return mv;
    }

    @GetMapping("/people")
    public List<People> listCategory(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<People> cs=peopleMapper.findAll();
        PageInfo<People> page = new PageInfo<>(cs);
        return page.getList();
    }

    @GetMapping("/people/{id}")
    public People getPeople(@PathVariable("id") int id) throws Exception {
        People c= peopleMapper.get(id);
        return c;
    }

    @PutMapping("/people")
    public void addJPeople(@RequestBody People c) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+c);
    }
}
