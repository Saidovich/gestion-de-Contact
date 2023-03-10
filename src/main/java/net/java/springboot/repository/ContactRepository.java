package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
