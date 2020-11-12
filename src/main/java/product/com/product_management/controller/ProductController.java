package product.com.product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import product.com.product_management.model.Product;
import product.com.product_management.service.product.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping()
    public ModelAndView showListProduct() {
        Iterable<Product> products = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateProduct() {
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", product);
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createProduct(Product product) {
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "ok con de");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProduct(@PathVariable Long id){
        Product product = (Product) iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @PostMapping("/editProduct")
    public ModelAndView editProduct(@ModelAttribute("product") Product product){
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

        @GetMapping("/delete/{id}")
        public String showFormDelete(@PathVariable Long id){
            Product product = (Product) iProductService.findById(id);
            if (product != null) {
                iProductService.remove(id);
                return "redirect:/products";
            }else
                return "loi";
    }
//    @GetMapping("delete/{id}")
//    public ModelAndView showDelete(@PathVariable Long id) {
//        Product product=  (Product) iProductService.findById(id);
//            ModelAndView modelAndView = new ModelAndView("/delete");
//            modelAndView.addObject("product", product);
//            return modelAndView;
//        }
//    @PostMapping("delete")
//    public ModelAndView delete(Product product){
//        iProductService.remove(product.getId());
//        ModelAndView modelAndView = new ModelAndView("redirect:/products");
//        return modelAndView;
//    }

}
