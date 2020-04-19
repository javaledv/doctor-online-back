package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.user.User;

import java.util.Optional;

public interface UserRepository extends BaseCrudRepository<User> {

    Optional<User> findByEmail(String email);
}
