/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import dto.MaderaDTO;
import entidades.Madera;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IMaderaDAO {

    public Madera agregarMadera(Madera madera);

    public List<Madera> obtenerMaderas();

    public Madera buscarMaderaPorId(String id);

    public Madera obtenerMaderaPorId(ObjectId id);

    public Madera obtenerMaderaPorNombre(String nombre);

    public void actualizar(Madera madera);

    public List<MaderaDTO> buscarMaderaPorCorreoVendedor(String correoUsuarioVenta);

    public Madera agregarMaderaPorCorreo(String correoVendedor, Madera madera);

    public void editarMadera(Madera madera);
    
    public boolean eliminarMadera(String id);
}
