/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.MaderaDTO;
import entidades.Madera;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IMadereraNegocio {

    public MaderaDTO agregarMadera(MaderaDTO maderaDTO);

    public List<MaderaDTO> obtenerMaderas();
    
    public MaderaDTO buscarMaderaPorId(String id);
}
