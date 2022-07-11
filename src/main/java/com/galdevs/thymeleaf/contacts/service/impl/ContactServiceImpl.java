package com.galdevs.thymeleaf.contacts.service.impl;

import com.galdevs.thymeleaf.contacts.dto.ContactDto;
import com.galdevs.thymeleaf.contacts.repository.ContactRepository;
import com.galdevs.thymeleaf.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<ContactDto> findAllByUsername(String username) {
        return null;
    }
}
