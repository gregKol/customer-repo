package pl.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.customer.dao.CustomerRepository;
import pl.customer.model.Customer;

@Component
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository; // Na potrzeby zapisu do bazy
	
	public List<Customer> getAllCustomers(Set<Integer> creditNumbers){
		
		
		List<Customer> sendListOfAllCustomers = new ArrayList<Customer>(); // Do listy przypisane zostana wszyscy klienci pobrani z bazy
		for (Customer customer : customerRepository.findAll()) {
			if (creditNumbers.contains(customer.getCreditNumber())) {
				sendListOfAllCustomers.add(customer);
			}
		}
		return sendListOfAllCustomers;
	}
}
