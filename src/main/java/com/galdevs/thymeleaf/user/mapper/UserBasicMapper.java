package com.galdevs.thymeleaf.user.mapper;

import com.galdevs.thymeleaf.core.mapper.EntityMapper;
import com.galdevs.thymeleaf.user.dto.UserBasicDto;
import com.galdevs.thymeleaf.user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserBasicMapper extends EntityMapper<UserBasicDto, User> {

}
