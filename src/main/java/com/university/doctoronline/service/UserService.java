package com.university.doctoronline.service;

import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import com.university.doctoronline.entity.user.User;
import com.university.doctoronline.search.IdSearchCriteria;

import java.util.Optional;

public interface UserService extends BaseCrudService<User, IdSearchCriteria> {

    Optional<User> getByEmail(String email);
}
