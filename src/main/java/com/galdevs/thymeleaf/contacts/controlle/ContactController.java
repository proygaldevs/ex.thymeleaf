package com.galdevs.thymeleaf.contacts.controlle;

import com.galdevs.thymeleaf.contacts.dto.ContactDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {


    @GetMapping//("/{username}")
    public String findByUsername(Model model, String username) {
        if (!ObjectUtils.isEmpty(username)) {
            model.addAttribute("contacts", getContacts());
        }
        else
            model.addAttribute("contacts", getContacts());

        return "/pages/contacts/list";
    }

    public List<ContactDto> getContacts(){
        List<ContactDto> contactDtos = new ArrayList<>();
        contactDtos.add(buildContactDto("Andres", "123", "Av. 123", "email"));
        contactDtos.add(buildContactDto("Camilo", "321", "Av. 987", "liame"));

        return contactDtos;
    }

    private ContactDto buildContactDto(String a, String b, String c, String d) {
        return ContactDto.builder()
                .name(a)
                .phone(b)
                .address(c)
                .email(d)
                .build();
    }
}
