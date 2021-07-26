package com.camarin.base.domain.services.auth;

import com.camarin.base.domain.dto.UserDto;
import com.camarin.base.domain.services.IBaseService;

import java.util.Optional;

public interface IUserService extends IBaseService<UserDto, Long> {
    Optional<UserDto> findOneByUserName(String userName);
}
