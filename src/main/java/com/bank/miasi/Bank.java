package com.bank.miasi;

import java.math.BigDecimal;
import java.util.List;

import com.bank.miasi.konta.Konto;
import com.bank.miasi.operacje.Mediator;

public class Bank {
	
	 private String id;
	private String nazwaBanku;
	private String adresBanku;
    private List<Konto> konta;
    protected Mediator mediator;
    
    public Bank (String id, String nazwaBanku, String adresBanku,List <Konto> konta, Mediator mediator)
    {
    	this.id= id;
       this.adresBanku = adresBanku;
       this.nazwaBanku = nazwaBanku;
       this.konta = konta;
       this.mediator = mediator;
       this.mediator.addBank(this, id);
    }

    public void wyslijPrzelew(String nrKontaNadawcy, String nrKontaOdbiorcy, BigDecimal kwota)
    {
        mediator.przelejNaRachunek(nrKontaNadawcy, nrKontaOdbiorcy, kwota);
    }
    
    public Konto pobierzKonto(String nrKonta)
    {
        Konto kontoWynikowe = null;
        
        for (Konto konto : konta)
        {
            if (konto.getNumer().equals(nrKonta))
            {
               kontoWynikowe = konto; 
            }
            
        }
        
        return kontoWynikowe;
    }
}
