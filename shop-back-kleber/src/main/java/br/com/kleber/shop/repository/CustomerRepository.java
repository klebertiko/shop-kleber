package br.com.kleber.shop.repository;

import br.com.kleber.shop.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, UUID> {

    @Query(" select customer " +
            " from Customer customer " +
            " where customer.email = ?1")
    Optional<Customer> findByEmail(@Param("email") String email);

}