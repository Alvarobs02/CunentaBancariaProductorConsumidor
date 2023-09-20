/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cunentabancariaproductorconsumidor;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Nuestro Recuso Compartido
 */
public class CuentaBacaria {
    
    private final int MAX_LIMITE=10;
    private int saldo = 0;
    private Semaphore semProductor= new Semaphore(MAX_LIMITE);
    private Semaphore semConsumidor= new Semaphore(0);
    private Semaphore mutex= new Semaphore(1);
    
    public void producir(String nombreProductor, int ingreso){
        System.out.println(nombreProductor + " entro a depositar");
        
        try {
            semProductor.acquire();
            mutex.acquire();
            
            saldo= saldo + ingreso;
            System.out.println(nombreProductor+" ha ingresado "+ ingreso +" €"
            +"y tenemos "+saldo +" de saldo");
            
            mutex.release();
            Thread.sleep(1000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(CuentaBacaria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        semConsumidor.release();
        }
    }
    public void consumir (String nombreConsumidor, int reintegro){
        System.out.println(nombreConsumidor + " entro a retirar dinero");
        try {
            semConsumidor.acquire();
            mutex.acquire();
            
            saldo = saldo-reintegro;
            
            System.out.println(nombreConsumidor + " ha retirado "+ reintegro +" €"
            +" y tenemos "+saldo +" de saldo");
            mutex.release();
            Thread.sleep(1000);
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(CuentaBacaria.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        semProductor.release();
        }
    }
}
