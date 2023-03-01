package com.spartanHardware.repository.specification;

import com.spartanHardware.model.dto.request.ProductFilterRequest;
import com.spartanHardware.model.entity.ParentCategory;
import com.spartanHardware.model.entity.Product;
import com.spartanHardware.model.entity.SubCategory;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {

    public Specification<Product> getByFilters(ProductFilterRequest filterRequest) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filterRequest.getCategory())) {
                Join<ParentCategory, Product> join = root.join("parentCategory", JoinType.LEFT);
                Expression<String> category = join.get("category");
                predicates.add(category.in(filterRequest.getCategory()));
            }
            if (StringUtils.hasLength(filterRequest.getSubCategory())) {
                Join<SubCategory, Product> join = root.join("subCategory", JoinType.LEFT);
                Expression<String> subCategory = join.get("subCategory");
                predicates.add(subCategory.in(filterRequest.getSubCategory()));
            }
            query.distinct(true);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
