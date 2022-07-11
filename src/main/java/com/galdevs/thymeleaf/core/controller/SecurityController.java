package com.galdevs.thymeleaf.core.controller;

import com.galdevs.thymeleaf.company.dto.CompanyDto;
import com.galdevs.thymeleaf.company.service.CompanyService;
import com.galdevs.thymeleaf.core.service.SecurityService;
import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.service.UserService;
import com.galdevs.thymeleaf.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;
    private final SecurityService securityService;
    private final UserValidator userValidator;
    private final CompanyService companyService;

    @GetMapping("/signin")
    public String signIn(Model model) {
        if (securityService.isAuthenticated()) return "redirect:/";

        model.addAttribute("userForm", new UserDto());
        model.addAttribute("company", new CompanyDto());
        model.addAttribute("companies", companyService.findAll());

        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "signin";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping("/home")
    public String loginSubmit(Model model) {
        model.addAttribute("usersCompanies", companyService.getCompanyUsers());
        return "/pages/landing-page";
    }
}
