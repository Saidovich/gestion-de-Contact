package net.java.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.exception.ResourceNotFoundException;
import net.java.springboot.model.Contact;
import net.java.springboot.repository.ContactRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	// get all contacts
	@GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}		
	
	// create contact rest api
	@PostMapping("/contacts")
	public Contact createContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	// get contact by id rest api
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
		return ResponseEntity.ok(contact);
	}
	
	// update contact rest api
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails){
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
		
		contact.setFirstName(contactDetails.getFirstName());
		contact.setLastName(contactDetails.getLastName());
		contact.setEmail(contactDetails.getEmail());
		contact.setPassword(contactDetails.getPassword());
		
		Contact updatedContact = contactRepository.save(contact);
		return ResponseEntity.ok(updatedContact);
	}
	
	// delete contact rest api
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id){
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact not exist with id :" + id));
		
		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
