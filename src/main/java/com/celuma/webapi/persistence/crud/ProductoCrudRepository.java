package com.celuma.webapi.persistence.crud;

import com.celuma.webapi.persistence.entity.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE products SET name = ?1, content = ?2, category_id = ?3 WHERE product_id = ?4" , nativeQuery = true)
    int updateProduct(String name, String content, Integer category, Integer id);


}
