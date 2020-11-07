package com.tts.ecommerceproject.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tts.ecommerceproject.models.Product;
import com.tts.ecommerceproject.repositories.ProductRepository;
import com.tts.ecommerceproject.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all
                  // controllers, for the navbar.
public class MainController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    public void addNew() {
        List<Product> allProducts = productService.findAll();

        //productRepository.deleteAll();

        if (allProducts.isEmpty()) {

            List<Product> newProducts = new ArrayList<Product>();

            newProducts.add(new Product(4, (float) 1500.00, "DSI Prophet 12 Synthesizer", "DSI Prophet 12", "Dave Smith Instruments", "Synthesizer",
                    "images/P12.png"));

            newProducts.add(new Product(3, (float) 1000.00, "Moog Voyager Synthesizer", "Moog Voyager", "Moog", "Synthesizer",
                    "images/MoogVoyager.jpg"));

            newProducts.add(new Product(12, (float) 800.00, "Waldorf Blofeld Digital Synthesizer, Black", "Waldorf Blofeld", "Waldorf", "Synthesizer",
                    "images/Blofeld.jpg"));

            newProducts.add(new Product(7, (float) 700.00, "Elektron Analog Rytm Drum Machine", "Elektron Rytm", "Elektron", "Drum Machine",
                    "images/Rytm.jpg"));

            for (Product product : newProducts) {
                productService.save(product);
            }
        } else {

            System.out.println("You don't need more items!");
        }
    }

    @GetMapping("/")
    public String main() {
        addNew();
        return "main";
    }

    @ModelAttribute("products")
       public List<Product> products() {
           return productService.findAll();
       }
 
       @ModelAttribute("categories")
       public List<String> categories() {
           return productService.findDistinctCategories();
       }
 
       @ModelAttribute("brands")
       public List<String> brands() {
           return productService.findDistinctBrands();
       }
 
       @GetMapping("/filter")
       public String filter(@RequestParam(required = false) String category,
                            @RequestParam(required = false) String brand,
                            Model model) {
           List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
           model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
           return "main";
       }
 
       @GetMapping("/about")
       public String about() {
           return "about";
       }
}
