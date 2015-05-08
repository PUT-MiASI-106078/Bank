package com.bank.miasi;



public abstract class Filtr {
    
    
    protected OperacjaBankowa operacjaBankowa;
    protected Filtr nextFiltr;
    
    public Filtr (OperacjaBankowa operacja)
    {
        operacjaBankowa = operacja;
    }
    
    public void wykonajFilter()
    {
        
    }
}