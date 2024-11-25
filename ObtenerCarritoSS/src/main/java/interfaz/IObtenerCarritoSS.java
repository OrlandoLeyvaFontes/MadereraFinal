/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.CarritoDTO;
import java.util.List;
import javax.swing.text.Document;

/**
 *
 * @author Oley
 */
public interface IObtenerCarritoSS {
public List<CarritoDTO> obtenerCarrito(String usuarioId);
}
