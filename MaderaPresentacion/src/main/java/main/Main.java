/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import funcionalidad.AgregarUsuarioSS;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IAgregarUsuarioSS;
import negocio.UsuarioNegocio;
import pantallas.IniciarSesion;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        
        IAgregarUsuarioSS agregarUsuarioSS= new AgregarUsuarioSS();
        IniciarSesion  inicio=new IniciarSesion(agregarUsuarioSS);
        inicio.setVisible(true);
        
        
    }
}
