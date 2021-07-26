package com.camarin.base.domain.services.auth;

import com.camarin.base.database.entity.auth.User;
import com.camarin.base.database.repository.auth.UserRepository;
import com.camarin.base.domain.dto.UserDto;
import com.camarin.base.domain.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BaseService<UserDto, User, Long> implements IUserService {

    private final UserRepository repository;

    @Autowired
    protected UserService(UserRepository repository) {
        super(repository, UserDto.class, User.class);
        this.repository = repository;
    }

    @Override
    public Optional<UserDto> findOneByUserName(String userName) {
        User user = this.repository.findOneByUserName(userName);
        return Optional.ofNullable(user != null ? entityToDto(user) : null);
    }
}
