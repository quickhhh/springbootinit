package com.example.panda.controller;

import com.example.panda.mapper.PeopleMapper;
import com.example.panda.pojo.People;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
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
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<People> cs=peopleMapper.findAll();
        PageInfo<People> page = new PageInfo<>(cs);
        m.addAttribute("page", page);

        return "listPeople";
    }


    @RequestMapping("/addPeople")
    public String listPeople(People c) throws Exception {
        peopleMapper.save(c);
        return "redirect:listPeople";
    }
    @RequestMapping("/deletePeople")
    public String deletePeople(People c) throws Exception {
        peopleMapper.delete(c.getId());
        return "redirect:listPeople";
    }
    @RequestMapping("/updatePeople")
    public String updatePeople(People c) throws Exception {
        peopleMapper.update(c);
        return "redirect:listPeople";
    }
    @RequestMapping("/editPeople")
    public String listPeople(int id,Model m) throws Exception {
        People c= peopleMapper.get(id);
        m.addAttribute("c", c);
        return "editPeople";
    }
}
