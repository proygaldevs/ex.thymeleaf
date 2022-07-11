package com.galdevs.thymeleaf.user.service.impl;

import com.galdevs.thymeleaf.company.model.Company;
import com.galdevs.thymeleaf.core.model.eunms.Status;
import com.galdevs.thymeleaf.user.dto.UserBasicDto;
import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.mapper.UserBasicMapper;
import com.galdevs.thymeleaf.user.mapper.UserMapper;
import com.galdevs.thymeleaf.user.model.User;
import com.galdevs.thymeleaf.user.repository.UserRepository;
import com.galdevs.thymeleaf.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserBasicMapper userBasicMapper;

    @Override
    public void save(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }

    @Override
    public List<UserDto> findAllByUsername(String username) {
        return userMapper.toDto(userRepository.findAllByUsername(username));
    }

    @Override
    public List<UserBasicDto> findAll() {
        List<User> users = userRepository.findAll();

        return userBasicMapper.toDto(users);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteUserByUsername(username);
    }

    @Override
    public void update(String username, UserDto userDto) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            userRepository.save(user);
        }

    }

    @Override
    public Integer countUsersByCompany(Long companyId) {
        return userRepository.countUsersByCompanyIdAndStatus(companyId, Status.ACTIVE);
    }
}
