package com.galdevs.thymeleaf.user.service.impl;

import com.galdevs.thymeleaf.company.model.Company;
import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.mapper.UserMapper;
import com.galdevs.thymeleaf.user.model.User;
import com.galdevs.thymeleaf.user.repository.UserRepository;
import com.galdevs.thymeleaf.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        //TODO ELIMINAR Company
        Company company = new Company();
        company.setId(1L);
        user.setCompany(company);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
