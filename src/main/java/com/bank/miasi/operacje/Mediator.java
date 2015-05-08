package com.bank.miasi.operacje;

import java.math.BigDecimal;

import com.bank.miasi.Bank;




public interface Mediator {
    public void addBank(Bank bank, String dodatkowe);
    public void przelejNaRachunek(String nrkontaNadawcy, String nrkontaOdbiorcy, BigDecimal kwota);
}

