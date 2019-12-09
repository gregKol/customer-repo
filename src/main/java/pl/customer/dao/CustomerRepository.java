package pl.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
