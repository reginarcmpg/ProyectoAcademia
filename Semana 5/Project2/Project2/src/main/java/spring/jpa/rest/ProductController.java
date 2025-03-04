package spring.jpa.rest;

import spring.jpa.entity.Product;
import spring.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService theProductService) {
        productService = theProductService;
    }


    @GetMapping("/products") // Get the list of all products
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}") // Get the products by id
    public Product getProduct(@PathVariable int productId) {
        Product theProduct = productService.findById(productId);
        if (theProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        return theProduct;
    }

    @GetMapping("/products/{productId}/stock") //Show Products available
    public String isStock(@PathVariable int productId) {
        boolean inStock = productService.IsStock(productId);
        String message = inStock ? "Product available" : "Product not available";
        return message;
    }

    @GetMapping("/products/discount") //discount applies to items over 15
    public List<String> discount() {
        List<Product> productWithDiscount = productService.PriceWithDiscount(25);
        return productWithDiscount.stream()
                .map(product -> "Product: " + product.getMAKEUP() + ", Price with discount: " + product.getPRICE())
                .collect(Collectors.toList());
    }

    @GetMapping("/products/filter/{price}") //filter products depending on price
    public List<Product> filterProducts(@PathVariable Double price) {
        List<Product> allProducts = productService.findAll();
        return allProducts.stream()
                .filter(product -> product.getPRICE() >= price)
                .collect(Collectors.toList());
    }

    @PostMapping("/products") // Add new product
    public Product addProduct(@RequestBody Product theProduct) {
        theProduct.setID(0);
        return productService.save(theProduct);
    }

    @PutMapping("/products") // Update a product
    public Product updateProduct(@RequestBody Product theProduct) {
        return productService.save(theProduct);
    }

    @DeleteMapping("/products/{productId}") // Delete product
    public String deleteProduct(@PathVariable int productId) {
        Product tempProduct = productService.findById(productId);
        if (tempProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }
        productService.deleteById(productId);
        return "Deleted product id - " + productId;
    }
}
