package pl.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pl.customer.dao.CustomerRepository;
import pl.customer.model.Customer;

@RestController
public class CustomerController {
	protected final Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	CustomerRepository customerRepository; // Na potrzeby zapisu do bazy

	// Servis tworzacy klienta
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public String createCustomer(@RequestBody Customer customer) throws Exception {

		log.log(Level.INFO, "Customer zawiera", customer.toString());
		customerRepository.save(customer); // Zapis do bazy
		System.out.println("##################### Utworzono klienta: " + customer);
		return "Klient zostal stworzony" + customer;
	}

	// Servis odczytujacy wszystkich klientow zapisanych w bazie
	@RequestMapping(value = "/getCustomers", method = RequestMethod.POST)
	public List<Customer> getCustomers(@RequestBody Set<Integer> creditNumbers) throws Exception {
		
		List<Customer> sendListOfAllCustomers = new ArrayList<Customer>(); // Do listy przypisane zostana wszyscy klienci pobrani z bazy
		for (Customer customer : customerRepository.findAll()) {
			if (creditNumbers.contains(customer.getCreditNumber())) {
				sendListOfAllCustomers.add(customer);
			}
		}
		
		System.out.println("##################### Odczytano klienta/klientow: " + sendListOfAllCustomers);
		return sendListOfAllCustomers;
	}

}
