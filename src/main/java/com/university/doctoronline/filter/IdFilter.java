package com.university.doctoronline.filter;

import com.reserver.common.starter.data.jpa.basecrud.filter.BaseFilter;

public class IdFilter implements BaseFilter {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
