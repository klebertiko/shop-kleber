package br.com.kleber.shop.repository;

import br.com.kleber.shop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by kleber on 4/24/17.
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query("select product " +
            " from Product product " +
            " where product.quantity > 0" +
            " order by product.name")
    Collection<Product> findAll();
}
