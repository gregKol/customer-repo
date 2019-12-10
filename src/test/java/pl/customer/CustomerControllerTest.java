package pl.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import pl.customer.model.Customer;



public class CustomerControllerTest  extends AbstractTest{

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	@Test
	   public void createCustomer() throws Exception {
	      String uri = "/createCustomer";
	      Customer customer = new Customer(102, "Janek 2", "Kowalski 2", "88443322 2");

	      String inputJson = super.mapToJson(customer);
	      
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Klient zostal stworzony" + customer);
	   }
	
	
//	@Test
//	   public void getProductsList() throws Exception {
//	      String uri = "/getCustomers";
//	      
//	      int[] tabNumb = {102};
//	      String inputJsonTab = super.mapToJson(tabNumb);
//	      
//	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//	 	         .contentType(MediaType.APPLICATION_JSON_VALUE)
//	 	         .content(inputJsonTab)).andReturn();
//	      
//	      int status = mvcResult.getResponse().getStatus();
//	      assertEquals(200, status);
//	      String content = mvcResult.getResponse().getContentAsString();
//	      Customer[] customer = super.mapFromJson(content, Customer[].class);
//	      assertTrue(customer.length > 0);
//	   }
	
	
	

}
