package com.misc1.DroolsSpringBoot.dto;

public class CarDetailsDto {

    private String carModel;
    private Integer carModelYear;
    private Integer carSellingPricePercentage;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(Integer carModelYear) {
        this.carModelYear = carModelYear;
    }

    public Integer getCarSellingPricePercentage() {
        return carSellingPricePercentage;
    }

    public void setCarSellingPricePercentage(Integer carSellingPricePercentage) {
        this.carSellingPricePercentage = carSellingPricePercentage;
    }
}
