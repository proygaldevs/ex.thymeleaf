package com.galdevs.thymeleaf.user.mapper;

import com.galdevs.thymeleaf.core.mapper.EntityMapper;
import com.galdevs.thymeleaf.user.dto.UserBasicDto;
import com.galdevs.thymeleaf.user.dto.UserDto;
import com.galdevs.thymeleaf.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserBasicMapper extends EntityMapper<UserBasicDto, User> {

}
