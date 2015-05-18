/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.miasi.Bank;
import com.bank.miasi.Klient;
import com.bank.miasi.konta.Konto;
import com.bank.miasi.konta.KontoBankowe;
import com.bank.miasi.konta.typy.KontoWygodne;

import com.bank.miasi.operacje.Mediator;
import com.bank.miasi.operacje.MediatorPrzelew;

import static org.junit.Assert.*;

/**
 *
 * @author Krzysztof
 */
public class BankControllerTest {
    
    public BankControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BankController.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BankController.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testMediatorPrzelew() {
        
        MediatorPrzelew mediator = new MediatorPrzelew();
        
       
        Klient k1 = new Klient("jan", "nowak", "ccc", "92012821435", "nip", "85557534", BigDecimal.valueOf(5000.00));
        KontoBankowe konto1 = new KontoBankowe(new KontoWygodne(), "06432", k1);
        Klient k2 = new Klient("karol", "kulesza", "ccc", "920128134445", "nip", "345345534", BigDecimal.valueOf(7000.00)); 
        KontoBankowe konto2 = new KontoBankowe(new KontoWygodne(), "02223", k2);
        
        
        
        List<Konto> listaKontBanku1 = new ArrayList<>();
        listaKontBanku1.add(konto1);
        listaKontBanku1.add(konto2);
        
        Klient k3 = new Klient("staszek", "jegierski", "ccc", "9102345643", "nip", "766523564", BigDecimal.valueOf(4000.00));
        KontoBankowe konto3 = new KontoBankowe(new KontoWygodne(), "04128", k3 );
        Klient k4 = new Klient("amadeusz", "noser", "ccc", "9246676432", "nip", "345364544", BigDecimal.valueOf(3000.00)); 
        KontoBankowe konto4 = new KontoBankowe(new KontoWygodne(), "04223", k4);
        
        
        List<Konto> listaKontBanku2 = new ArrayList<>();
        listaKontBanku2.add(konto3);
        listaKontBanku2.add(konto4);
       
        Bank b1 = new Bank("02", "BZWBK", "test", listaKontBanku1,mediator);
        Bank b2 = new Bank("04", "PKO", "test", listaKontBanku2, mediator);
        
        mediator.przelejNaRachunek("06432", "04223", new BigDecimal("200.0"));
        
        assertEquals(new BigDecimal("200.0"), b2.pobierzKonto("04223").getStan());
    }
    
}
