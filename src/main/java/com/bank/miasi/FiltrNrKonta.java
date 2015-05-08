package com.bank.miasi;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.bank.miasi.exceptions.NiewspieranaOperacja;



public class FiltrNrKonta extends Filtr{

    public FiltrNrKonta(OperacjaBankowa operacja) {
        super(operacja);
    }
    
    public void wykonajFilter()
    {
        if (operacjaBankowa.getDoKogo().getNumer() == null)
        {
            System.err.println("Brka numeru odbiorcy");
        }
        else
        {
            try {
                operacjaBankowa.wykonajOperacjeFiltr();
            } catch (NiewspieranaOperacja ex) {
                
                System.err.println("B³ad");
            }
        }
    }
    
}
