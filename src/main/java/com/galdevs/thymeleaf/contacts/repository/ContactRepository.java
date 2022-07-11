package com.galdevs.thymeleaf.contacts.repository;

import com.galdevs.thymeleaf.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByUserUsername(String username);
}
