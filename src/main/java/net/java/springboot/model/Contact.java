package net.java.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contact_id;
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	public Contact() {
		
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 */
	public Contact(long contact_id, String firstName, String lastName, String password, String email) {
		super();
		this.contact_id = contact_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	

	/**
	 * @return the contact_id
	 */
	public long getContact_id() {
		return contact_id;
	}

	/**
	 * @param contact_id the contact_id to set
	 */
	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
