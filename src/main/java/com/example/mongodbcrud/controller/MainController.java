package com.example.mongodbcrud.controller;

import com.example.mongodbcrud.model.Product;
import com.example.mongodbcrud.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    ProductServiceImpl productServiceimp;


    //home page handler
    @RequestMapping("/")
    public String home(Model m){
        List<Product> products=productServiceimp.getAll();
        System.out.println(products);
        m.addAttribute("products",products);
        System.out.println("Inside home handler method...");
        return "home";
    }

    //product form handler
    @RequestMapping("/add-product")
    public String addProduct(Model m){
        m.addAttribute("title","Add Product");
        return "add_product_form";
    }

    //product handler handler
    @RequestMapping(value = "/handle-product",method= RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute("product") Product product){
        System.out.println("Product is: "+product);
        this.productServiceimp.save(product);
        System.out.println("Product has been Added...");
        RedirectView rv=new RedirectView();
        rv.setUrl("/");
        return rv;
    }

    //product delete handler
    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") String id){
        this.productServiceimp.delete(id);
        System.out.println("Product is deleted successfully...");
        RedirectView rv=new RedirectView();
        rv.setUrl("/");
        return rv;
    }

    @RequestMapping("/update/{productId}")
    public String updateForm(@PathVariable("productId") String id,Model m){
        Product product=this.productServiceimp.getProductById(id);
        m.addAttribute("product",product);
        return "update-form";
    }

    @RequestMapping(value = "/update-product",method= RequestMethod.POST)
    public RedirectView updateProduct(@ModelAttribute("product") Product product){
        System.out.println("Product is: "+product);
        this.productServiceimp.save(product);
        System.out.println("Product has been updated...");
        RedirectView rv=new RedirectView();
        rv.setUrl("/");
        return rv;
    }

}
