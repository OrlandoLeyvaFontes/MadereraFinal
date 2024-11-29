/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.MaderaDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IMaderaSS {
            public List<MaderaDTO> obtenerMaderas();
                public MaderaDTO agregarMadera(MaderaDTO maderaDTO);
    public MaderaDTO buscarMaderaPorId(String id);
        public MaderaDTO buscarMaderaPorNombre(String nombre);

}
