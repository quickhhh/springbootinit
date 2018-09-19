package com.example.panda.controller;

import com.example.panda.dao.CategoryDAO;
import com.example.panda.pojo.Category;
import com.example.panda.service.CategoryService;
import com.example.panda.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    /*@Autowired
    CategoryDAO categoryDAO;*/
    @Autowired
    CategoryService categoryService;

    /*@RequestMapping("/listCategory")
    public String listCategory(Model m) throws Exception {
        List<Category> cs=categoryDAO.findAll();

        m.addAttribute("cs", cs);

        return "listCategory";
    }*/


    //@RequestMapping("/listCategory")
    @GetMapping("/categories")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        //Page<Category> page =categoryDAO.findAll(pageable);
        Page4Navigator<Category> page =categoryService.list(pageable);
        m.addAttribute("page", page);
        return "listCategory";
    }

    //@RequestMapping("/addCategory")
    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        //categoryDAO.save(c);
        categoryService.save(c);
        return "redirect:/categories";
    }
    //@RequestMapping("/deleteCategory")
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        //categoryDAO.delete(c);
        categoryService.delete(c.getId());
        return "redirect:/categories";
    }

    //@RequestMapping("/updateCategory")
    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
        //categoryDAO.save(c);
        categoryService.save(c);
        return "redirect:/categories";
    }

    //@RequestMapping("/editCategory")
    @GetMapping("/categories/{id}")
    public String editCategory(@PathVariable("id")int id,Model m) throws Exception {
        //Category c= categoryDAO.getOne(id);
        Category c= categoryService.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

}
