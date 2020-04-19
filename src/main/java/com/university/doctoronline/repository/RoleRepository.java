package com.university.doctoronline.repository;

import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.university.doctoronline.entity.user.Role;

public interface RoleRepository extends BaseCrudRepository<Role> {

    Role getByName(String name);
}
