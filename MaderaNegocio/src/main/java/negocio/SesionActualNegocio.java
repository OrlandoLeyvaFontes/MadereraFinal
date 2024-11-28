/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.SesionActualDAO;
import dto.SesionActualDTO;
import entidades.SesionActual;
import interfacesDTO.ISesionActualNegocio;

/**
 *
 * @author aleja
 */
public class SesionActualNegocio implements ISesionActualNegocio {
    
    private SesionActualDAO sesionActualDAO;

    public SesionActualNegocio() {
        this.sesionActualDAO = new SesionActualDAO();
    }

    
    
    public SesionActualDTO guardarSesion(String correo){
        SesionActual sesionActual = new SesionActual(correo);
        sesionActualDAO.guardarSesion(sesionActual);
        
        if(sesionActual != null){
            SesionActualDTO sesionActualDTO = new SesionActualDTO();
            sesionActualDTO.setCorreo(sesionActual.getCorreo());
            return sesionActualDTO;
        }else {
            throw new RuntimeException("Error al agregar la sesion actual.");
        }
    }
}
