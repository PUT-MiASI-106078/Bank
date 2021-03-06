/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi;

import com.bank.miasi.konta.typy.TypKonta;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author student
 */
public class OdsetkiStateLokataOptymalna implements OdsetkiState{

    @Override
    public BigDecimal obliczOdsetki( BigDecimal stanKonta, TypKonta typKonta) {
       BigDecimal wynik = null;
        BigDecimal procent = typKonta.getOprocentowanie();

        wynik = stanKonta;
        wynik.multiply(procent);
        wynik.multiply(new BigDecimal(typKonta.getOkresRozliczeniowy()));
        wynik.divide(new BigDecimal(365),2, RoundingMode.HALF_EVEN);

        return wynik;
    }




}
