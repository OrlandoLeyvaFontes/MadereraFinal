/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfacesDTO.ICarritoNegocio;
import negocio.CarritoNegocio;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        ICarritoNegocio carritoNegocio=new CarritoNegocio();
        carritoNegocio.obtenerCarrito("6741544ce0f6e93e979548da");
    }
}
