package com.spain.league.dto;

public class DeportistasPorNacionalidadDTO {

    private String nacionalidad;
    private Long total;

    public DeportistasPorNacionalidadDTO() {
    }

    public DeportistasPorNacionalidadDTO(String nacionalidad, Long total) {
        this.nacionalidad = nacionalidad;
        this.total = total;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DeportistasPorNacionalidadDTO{" +
                "nacionalidad='" + nacionalidad + '\'' +
                ", total=" + total +
                '}';
    }
}
