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
public class Banquero {
    public static void main(String[] args) {
        final int Productores = 3;
        final int Consumidor = 10 ;
        CuentaBacaria cuenta =new CuentaBacaria();
        
        for (int i = 0; i < Productores; i++) {
            new Productor("Productor "+i, cuenta).start();
        }
        for (int i = 0; i < Consumidor; i++) {
            new Consumidor("Consumidor "+i, cuenta).start();
        }
        
    }
    
}
