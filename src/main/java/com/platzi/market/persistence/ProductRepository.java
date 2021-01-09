package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.IProductCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private IProductCrudRepository productCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productCrudRepository.findAll();
    }

    public List<Producto> getByCategory(int idCategory){
        return  productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Producto>> getStockQuantity(int quantity){
        return productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
    }

    public Optional<Producto> getProduct(int idProduct){
        return productCrudRepository.findById(idProduct);
    }

    public Producto save(Producto producto){
        return productCrudRepository.save(producto);
    }

    public  void delete(int idProduct){
        productCrudRepository.deleteById(idProduct);
    }

}
