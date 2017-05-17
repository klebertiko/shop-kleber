package br.com.kleber.shop.repository;

import br.com.kleber.shop.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    @Query("select cart " +
                  " from Cart cart ")
    Optional<Cart> getCurrent();
}
