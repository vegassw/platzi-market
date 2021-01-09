package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository  extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Producto>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);

}
