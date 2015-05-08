package com.bank.miasi;

import java.math.BigDecimal;



public class FiltrKwota extends Filtr{
    
    
    public FiltrKwota(OperacjaBankowa operacja)
    {
        super(operacja);
       nextFiltr = new FiltrTytul(operacja); 
    }
    
    public void filtruj()
    {
        BigDecimal kwota = new BigDecimal("20000");
        BigDecimal kwotaWychodzace = new BigDecimal("-20000");
             
        if (operacjaBankowa.getKwota().compareTo(kwota) > 0 || operacjaBankowa.getKwota().compareTo(kwotaWychodzace) < 0)
        {
            System.err.println("Przelew musi zostaæ wyjaœniony");
        }
        else
        {
            nextFiltr.wykonajFilter();
        }
    }
   
}
