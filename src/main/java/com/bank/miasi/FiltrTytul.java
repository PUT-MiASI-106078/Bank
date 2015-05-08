package com.bank.miasi;

import java.math.BigDecimal;



public class FiltrTytul extends Filtr{
    
    public FiltrTytul(OperacjaBankowa operacja)
    {
       super(operacja);
       nextFiltr = new FiltrNrKonta(operacja); 
    }
    
    public void wykonajFilter()
    {
        BigDecimal kwota = new BigDecimal("20000");
        
        if (operacjaBankowa.getTytul() == null)
        {
            System.err.println("Brak tytu³u przelewu");
        }
        else
        {
            nextFiltr.wykonajFilter();
        }
    }
    
}
