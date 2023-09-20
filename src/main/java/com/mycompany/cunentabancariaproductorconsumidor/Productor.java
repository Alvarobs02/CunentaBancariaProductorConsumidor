/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cunentabancariaproductorconsumidor;

/**
 *
 * @author CES
 */
public class Productor extends Thread{
    private CuentaBacaria cuenta;

    public Productor(String name ,CuentaBacaria cuenta) {
        super(name);
        this.cuenta = cuenta;
    }
    @Override
    public void run(){
        while (true) {
           cuenta.producir(this.getName(), (int)Math.random()*100+1);
            
        }
    }
    
}
