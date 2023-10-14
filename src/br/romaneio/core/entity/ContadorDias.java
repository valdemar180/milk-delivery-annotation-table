/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.romaneio.core.entity;

import java.util.Calendar;
import java.time.YearMonth;


/**
 *
 * @author valdemar
 */
public class ContadorDias {
    public int calendario(){
       Calendar cal = Calendar.getInstance();
       int mes = cal.get(Calendar.MONTH) + 1;
       int ano = cal.get(Calendar.YEAR);
       YearMonth yearMonth = YearMonth.of(ano, mes);
       int numeroDeDias = yearMonth.lengthOfMonth();
       
       return numeroDeDias;
   }


    
}
