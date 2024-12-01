/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.MaderaDTO;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IMaderaVentaSS {

    public MaderaDTO agregarMadera(MaderaDTO madera);

    public MaderaDTO obtenerMaderaPorNombre(String nombre);

    public List<MaderaDTO> obtenerMaderas();

    public MaderaDTO buscarMaderaPorId(String id);

    public void editarMadera(MaderaDTO maderaDTO);

    public void eliminarMadera(String id);
}
