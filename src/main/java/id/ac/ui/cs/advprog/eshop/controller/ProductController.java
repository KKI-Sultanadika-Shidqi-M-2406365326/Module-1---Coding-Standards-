package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    // Constructor Injection (DIP applied)
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = productService.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{name}")
    public String editProductPage(@PathVariable String name, Model model) {
        Product product = productService.findByName(name);

        if (product == null) {
            return "redirect:/product/list";
        }

        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String editProductPost(@ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/product/list";
    }

    @GetMapping("/editById/{productId}")
    public String editProductByIdPage(@PathVariable String productId, Model model) {
        Product product = productService.findById(productId);

        if (product == null) {
            return "redirect:/product/list";
        }

        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/editById")
    public String editProductByIdPost(@ModelAttribute Product product) {
        productService.update(product.getProductId(), product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{name}")
    public String deleteProduct(@PathVariable String name) {
        productService.deleteByName(name);
        return "redirect:/product/list";
    }

    @PostMapping("/delete")
    public String deleteProductPost(@RequestParam String productId) {
        productService.deleteProductById(productId);
        return "redirect:/product/list";
    }
}