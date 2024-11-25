/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.CarritoDTO;
import interfacesDTO.ICarritoNegocio;
import interfaz.IObtenerCarritoSS;
import java.util.List;
import javax.swing.text.Document;
import negocio.CarritoNegocio;

/**
 *
 * @author Oley
 */
public class ObtenerCarritoSS  implements IObtenerCarritoSS {
ICarritoNegocio iCarritoNegocio;

    public ObtenerCarritoSS( ) {
        this.iCarritoNegocio = new CarritoNegocio();
    }

    @Override
    public List<CarritoDTO> obtenerCarrito(String usuarioId) {
 return iCarritoNegocio.obtenerCarrito(usuarioId);
    }

    
    }



    

       


    

