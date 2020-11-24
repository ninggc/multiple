package com.ninggc.demo.rabbitmq.entity;

/**
 * Created by smlz on 2019/10/9.
 */
public class Address {

    private String provinces;
    private String city;
    private String area;

    @Override
    public String toString() {
        return "Address{" +
                "provinces='" + provinces + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
