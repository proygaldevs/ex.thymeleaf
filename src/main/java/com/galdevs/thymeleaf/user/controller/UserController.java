package com.galdevs.thymeleaf.user.controller;

import com.galdevs.thymeleaf.company.dto.CompanyDto;
import com.galdevs.thymeleaf.company.service.CompanyService;
import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findByUsername(Model model, String username) {
        if (!ObjectUtils.isEmpty(username)) {
            model.addAttribute("users", userService.findAllByUsername(username));
        }
        else
            model.addAttribute("users", userService.findAll());

        return "/pages/user/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("company", new CompanyDto());
        model.addAttribute("companies", companyService.findAll());

        return "/pages/user/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult) {
        userService.save(userForm);

        return "/pages/user/list";
    }

    @GetMapping("/{username}/update")
    public String update(Model model, @PathVariable String username) {
        model.addAttribute("user", userService.findByUsername(username));

        return "/pages/user/update";
    }

    @PostMapping("/{username}/update")
    public String update(@ModelAttribute("user") UserDto user, @PathVariable String username, BindingResult bindingResult) {
        userService.update(username, user);

        return "/pages/user/list";
    }

    @GetMapping("/{username}/delete")
    public String delete(@PathVariable String username) {
        userService.deleteByUsername(username);

        return "/pages/user/list";
    }
}
