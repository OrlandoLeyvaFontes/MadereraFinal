/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dto.MaderaDTO;
import funcionalidad.AgregarMaderaSS;
import funcionalidad.AgregarUsuarioSS;
import funcionalidad.InicioDeSesionSS;
import interfacesDTO.IUsuarioNegocio;
import interfazSS.IAgregarMaderaSS;
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
        IInicioSesionSS iInicioSesionSS = new InicioDeSesionSS();
        IAgregarUsuarioSS agregarUsuarioSS = new AgregarUsuarioSS();
        IAgregarMaderaSS agregarMaderaSS = new AgregarMaderaSS();
        MaderaDTO maderaDTO1 = new MaderaDTO("Pino", "Madera de pino para construcción", 50, 120.5);
        agregarMaderaSS.agregarMadera(maderaDTO1);

        MaderaDTO maderaDTO2 = new MaderaDTO("Roble", "Madera de roble para muebles", 30, 250.75);
        agregarMaderaSS.agregarMadera(maderaDTO2);
        MaderaDTO maderaDTO3 = new MaderaDTO("Cedro", "Madera de cedro para decoración", 100, 350.0);
        agregarMaderaSS.agregarMadera(maderaDTO3);
        MaderaDTO maderaDTO4 = new MaderaDTO("Abeto", "Madera de abeto para estructuras", 75, 150.25);
        agregarMaderaSS.agregarMadera(maderaDTO4);
        MaderaDTO maderaDTO5 = new MaderaDTO("Nogal", "Madera de nogal para ebanistería", 20, 500.0);
        agregarMaderaSS.agregarMadera(maderaDTO5);
        MaderaDTO maderaDTO6 = new MaderaDTO("Cerezo", "Madera de cerezo para acabados finos", 40, 420.0);
        agregarMaderaSS.agregarMadera(maderaDTO6);
        IniciarSesion inicio = new IniciarSesion(agregarUsuarioSS, iInicioSesionSS);
        inicio.setVisible(true);

    }
}
