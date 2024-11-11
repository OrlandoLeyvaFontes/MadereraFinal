/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import funcionalidad.AgregarUsuarioSS;
import funcionalidad.InicioDeSesionSS;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IAgregarUsuarioSS;
import interfazSS.IInicioSesionSS;
import negocio.UsuarioNegocio;
import pantallas.IniciarSesion;

/**
 *
 * @author Oley
 */
public class Main {
    public static void main(String[] args) {
        IInicioSesionSS iInicioSesionSS=new InicioDeSesionSS();
        IAgregarUsuarioSS agregarUsuarioSS= new AgregarUsuarioSS();
        IniciarSesion  inicio=new IniciarSesion(agregarUsuarioSS,iInicioSesionSS);
        inicio.setVisible(true);
        
        
    }
}
