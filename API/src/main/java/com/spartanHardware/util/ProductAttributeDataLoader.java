package com.spartanHardware.util;

import com.spartanHardware.model.entity.ProductAttribute;
import com.spartanHardware.repository.ProductAttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductAttributeDataLoader implements CommandLineRunner {

    private final ProductAttributeRepository attributeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadAttributeData();
    }

    private void loadAttributeData() {
//        List<ProductAttribute> productAttributes = List.of(
//                new ProductAttribute("connectionType"),
//                new ProductAttribute("compatibility")
//        );
//        if (attributeRepository.findAll().isEmpty())
//            attributeRepository.saveAll(productAttributes);
    }
}
