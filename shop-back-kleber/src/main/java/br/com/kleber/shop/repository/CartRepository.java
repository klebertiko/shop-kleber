package br.com.kleber.shop.repository;

import br.com.kleber.shop.model.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by kleber on 4/24/17.
 */
@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    @Query("select cart " +
            " from Cart cart " +
            " where cart.cartItems.length > 0" +
            " order by cart.id")
    Collection<Cart> findAll();

    @Query("select cart "+
                  " from Cart cart "+
                  " where cart.customer.email = ?1")
    Optional<Cart> getCurrentFromEmail(String email);
}
