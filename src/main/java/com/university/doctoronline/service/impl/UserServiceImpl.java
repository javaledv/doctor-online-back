package com.university.doctoronline.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.filter.BaseFilter;
import com.reserver.common.starter.data.jpa.basecrud.service.impl.AbstractBaseCrudService;
import com.university.doctoronline.entity.user.User;
import com.university.doctoronline.filter.IdFilter;
import com.university.doctoronline.repository.UserRepository;
import com.university.doctoronline.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends AbstractBaseCrudService<User, IdFilter> implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Example<User> createExample(BaseFilter filter) {
        return null;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }
}
