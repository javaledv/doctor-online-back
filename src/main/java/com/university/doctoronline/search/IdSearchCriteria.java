package com.university.doctoronline.search;

import com.reserver.common.starter.data.jpa.basecrud.search.BaseSearchCriteria;

public class IdSearchCriteria implements BaseSearchCriteria {

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
