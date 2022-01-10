package com.customHotline.customHotline.service.serviceImpl;

import com.customHotline.customHotline.domain.Product;
import com.customHotline.customHotline.importProduct.ProductJson;
import com.customHotline.customHotline.repository.ProductRepository;
import com.customHotline.customHotline.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private Product product;


    @Value("${file.product}")
    private String file;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    @Scheduled(fixedDelay = 30000000L, initialDelay = 0L)
    public void insertDataFromFile() throws IOException {
        String content = Files.lines(Paths.get(file)).reduce("", String::concat);
        ObjectMapper mapper = new ObjectMapper();
        ProductJson[] productFromJSON = mapper.readValue(content, ProductJson[].class);

        for (ProductJson gfp : productFromJSON){

            productRepository.insertDataFromFile(gfp.getId(), gfp.getSku(),
                    gfp.getName(), gfp.getCategory_id(), gfp.getCategory_name(),
                     gfp.getSupl_price(), gfp.getPrice(), gfp.getStock());
            System.out.println(gfp.getId());
        }
    }
}
