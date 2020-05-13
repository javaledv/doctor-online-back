package com.university.doctoronline.dto;

public class DoctorSpecializationDto extends BaseDto {

    private String localizedName;
    private Integer code;

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
