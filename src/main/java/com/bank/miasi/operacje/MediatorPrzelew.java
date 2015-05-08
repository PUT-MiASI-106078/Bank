package com.bank.miasi.operacje;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.bank.miasi.Bank;
import com.bank.miasi.konta.Konto;


public class MediatorPrzelew implements Mediator{ 
    
    private Map<String, Bank> banki;
    
    public MediatorPrzelew() {
    	banki = new HashMap<String, Bank>();
    }
    
    @Override
    public void addBank(Bank bank, String dodatkowe) { 
    	banki.put(dodatkowe, bank);
    }

    @Override
    public void przelejNaRachunek(String nrKontaNadawcy, String nrKontaOdbiorcy, BigDecimal kwota) {
    	
        String nrKonta = nrKontaNadawcy.substring(0,2);
       
        Bank bank = banki.get(nrKonta);
        
        if (bank != null)
        {
            this.przelej (nrKontaNadawcy, bank, kwota);
        }
        else
        {
            System.err.println("Dla numeru konta nie istnieje ¿aden bank.");
        }
    }
    
    private void przelej(String numerKontaNadawcy, Bank bank, BigDecimal kwota) {
        
        Konto konto = bank.pobierzKonto(numerKontaNadawcy);
        
        if (konto != null)
        {
            konto.wplacKwote(kwota); 
        }
        else
        {
            System.err.println("Nie istnieje konto dla danego numeru konta");
        }
    }
}
