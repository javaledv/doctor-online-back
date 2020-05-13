package com.university.doctoronline.utils;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class SpecificationUtils {

    public static Join<?, ?> join(From<?, ?> from, String name, JoinType type) {
        return from.getJoins().stream()
                .filter(join -> StringUtils.equals(join.getAttribute().getName(), name) && join.getJoinType() == type)
                .findFirst()
                .orElseGet(() -> from.join(name, type));
    }
}
