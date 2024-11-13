/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Madera;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IMaderaDAO {
        public Madera agregarMadera(Madera madera);
        public List<Madera> obtenerMaderas();
        public Madera buscarMaderaPorId(String id);

}
