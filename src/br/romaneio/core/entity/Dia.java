/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity;

/**
 *
 * @author valdemar
 */
public class Dia {
    
    private Long id;
    private Double valorLeite;
    private Double furural;
    private int litros;
    private int mes;

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

    public Double getValorLeite() {
        return valorLeite;
    }

    public void setValorLeite(Double valorLeite) {
        this.valorLeite = valorLeite;
    }

    public Double getFurural() {
        return furural;
    }

    public void setFurural(Double furural) {
        this.furural = furural;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }
    
}
