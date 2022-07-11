package com.galdevs.thymeleaf.user.mapper;

import com.galdevs.thymeleaf.company.mapper.CompanyMapper;
import com.galdevs.thymeleaf.core.mapper.EntityMapper;
import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface UserMapper extends EntityMapper<UserDto, User> {

    @Mapping(ignore = true, target = "id")
    User toEntity(UserDto dto);

    @Mapping(ignore = true, target = "passwordConfirm")
    UserDto toDto(User entity);
}
