package com.example.panda.controller;

import com.example.panda.dao.CategoryDAO;
import com.example.panda.dao.PeopleMapper;
import com.example.panda.pojo.Category;
import com.example.panda.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PeopleController {
    @Autowired
    PeopleMapper peopleMapper;

    @RequestMapping("/listPeople")
    public String listCategory(Model m) throws Exception {
        List<People> cs=peopleMapper.findAll();

        m.addAttribute("cs", cs);

        return "listPeople";
    }

}
