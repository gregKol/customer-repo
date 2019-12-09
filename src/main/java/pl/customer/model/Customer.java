package pl.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "customer")

@Entity
@Table(name = "customer", schema = "customerdb")
public class Customer {

	@Id
	@Column(name = "credit_number")
	private int creditNumber;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "surname")
	private String surname;

	@Column(name = "pesel")
	private String pesel;

	
	
	public Customer() {
	}

	public Customer(int creditNumber, String firstname, String surname, String pesel) {
		this.creditNumber = creditNumber;
		this.firstname = firstname;
		this.surname = surname;
		this.pesel = pesel;
	}

	public int getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public String toString() {
		return "Customer {creditNumber=" + creditNumber + ", firstname=" + firstname + ", surname=" + surname + ", pesel=" + pesel + "}";
	}

}
