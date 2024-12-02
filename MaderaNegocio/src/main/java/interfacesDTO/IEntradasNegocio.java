/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.EntradasDTO;
import entidades.Entradas;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IEntradasNegocio {

    public EntradasDTO agregarEntrada(EntradasDTO entradaDTO);

    public List<EntradasDTO> obtenerEntradas();

    public List<EntradasDTO> obtenerEntradasPorTipo(String tipoEntrada);

    public List<String> obtenerTiposEntrada();
}
