/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.miasi.konta;

import com.bank.miasi.OperacjaBankowa;

/**
 *
 * @author student
 */
public interface Visitor {
    public default void visit(OperacjaBankowa op)
    {
        
        System.out.println(op.getData() + "\t" + op.getDoKogo().toString() + "\t" + op.getOdKogo() + "\t" + op.getTytul());
    }
    
}
