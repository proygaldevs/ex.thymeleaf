package com.galdevs.thymeleaf.contacts.service;

import com.galdevs.thymeleaf.contacts.dto.ContactDto;

import java.util.List;

public interface ContactService {

    List<ContactDto> findAllByUsername(String username);
}
