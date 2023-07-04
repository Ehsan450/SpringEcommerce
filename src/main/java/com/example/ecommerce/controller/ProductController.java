package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/save")
    public ModelAndView saveForm(Model model) {
        model.addAttribute("product", new Product());
        return new ModelAndView("products/add-product");
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable("id") String id, Model model) {
        Optional<Product> productOptional = this.productService.product(id);
        productOptional.ifPresent(product -> model.addAttribute("product", product));

        return new ModelAndView("products/update-product");
    }

    @GetMapping("/")
    public ModelAndView products(Model model){
        model.addAttribute("products",this.productService.products());
        return new ModelAndView("products/product");
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ModelAndView save(@ModelAttribute @Valid Product product, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("product",product);
            return new ModelAndView("products/add-product");
        }
        Product saveProduct=this.productService.save(product);
        return new ModelAndView(new RedirectView("/products/"));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id) {
        this.productService.delete(id);
        return new ModelAndView(new RedirectView("/products/"));
    }
}
