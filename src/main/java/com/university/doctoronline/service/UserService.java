package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.user.User;
import com.university.doctoronline.filter.IdFilter;

import java.util.Optional;

public interface UserService extends BaseCrudService<User, IdFilter> {

    Optional<User> getByEmail(String email);
}
