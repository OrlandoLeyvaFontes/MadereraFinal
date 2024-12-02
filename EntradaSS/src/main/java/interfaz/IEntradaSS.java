/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.EntradasDTO;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IEntradaSS {

    public EntradasDTO registrarEntrada(EntradasDTO entradasDTO);

    public List<EntradasDTO> obtenerMaderas();
}
