package com.ruhac.project_demo2.controller;

import com.ruhac.project_demo2.entity.Product;
import com.ruhac.project_demo2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @RequestMapping ("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = productService.listall();
        model.addAttribute("listproducts", listProducts);
        return "index";
    }

    @GetMapping("/newproduct")
    public String AddNewProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "Add_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById((long)id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/";
    }
}
