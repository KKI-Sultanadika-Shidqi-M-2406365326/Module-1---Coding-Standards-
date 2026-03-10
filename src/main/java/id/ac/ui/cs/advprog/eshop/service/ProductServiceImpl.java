package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> iterator = productRepository.findAll();
        List<Product> products = new ArrayList<>();

        while (iterator.hasNext()) {
            products.add(iterator.next());
        }

        return products;
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void deleteByName(String name) {
        productRepository.deleteByName(name);
    }

    @Override
    public Product findById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void update(String productId, Product product) {
        productRepository.update(productId, product);
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.delete(productId);
    }
}