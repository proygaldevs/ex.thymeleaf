package com.galdevs.thymeleaf.user.controller;


import com.galdevs.thymeleaf.user.dto.UserBasicDto;
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
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findByUsername(Model model, String username) {
        if (!ObjectUtils.isEmpty(username)) {
            model.addAttribute("users", userService.findAllByUsername(username));
        }
        else
            model.addAttribute("users", userService.findAll());

        return "/pages/user/list";
    }

    @GetMapping("/{username}")
    public String findByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);

        return "/pages/user/list";
    }

    @PostMapping
    public String create(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult) {
        return "/pages/user/create";
    }

    @GetMapping("/update")
    public String update(Model model, String username) {
        return "/pages/user/update";
    }

    @PostMapping("/{username}")
    public String update(@ModelAttribute("userForm") UserDto userForm, @PathVariable String username, BindingResult bindingResult) {
        return "/pages/user/update";
    }

    @GetMapping("/{username}/delete")
    public String delete(@PathVariable String username) {
        userService.deleteByUsername(username);

        return "/pages/user/list";
    }


}
