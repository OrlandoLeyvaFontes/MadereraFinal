/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.MaderaDAO;
import dao.UsuarioDAO;
import dto.MaderaDTO;
import entidades.Madera;
import interfacesDAO.IMaderaDAO;
import interfacesDAO.IUsuarioDAO;
import interfacesDTO.IMadereraNegocio;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class MaderaNegocio implements IMadereraNegocio {

    private IMaderaDAO iMaderaDAO;

    public MaderaNegocio() {
        this.iMaderaDAO = new MaderaDAO();
    }

    @Override
    public MaderaDTO agregarMadera(MaderaDTO maderaDTO) {
        Madera madera = new Madera();
        madera.setNombre(maderaDTO.getNombre());
        madera.setDescripcion(maderaDTO.getDescripcion());
        madera.setCantidad(maderaDTO.getCantidad());
        madera.setPrecioUnitario(maderaDTO.getPrecioUnitario());
        Madera maderaGuardada = iMaderaDAO.agregarMadera(madera);

        if (maderaGuardada != null) {
            MaderaDTO maderaDTO1 = new MaderaDTO();
            maderaDTO1.setNombre(maderaGuardada.getNombre());
            maderaDTO1.setDescripcion(maderaGuardada.getDescripcion());
            maderaDTO1.setCantidad(maderaGuardada.getCantidad());
            maderaDTO1.setPrecioUnitario(maderaGuardada.getPrecioUnitario());
            return maderaDTO1;
        } else {
            throw new RuntimeException("Error al agregar la madera");

        }

    }

    @Override
    public List<MaderaDTO> obtenerMaderas() {
        List<MaderaDTO> listaMaderasDTO = new ArrayList<>();
        try {
            List<Madera> listaMaderas = iMaderaDAO.obtenerMaderas();
            for (Madera madera : listaMaderas) {
                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setId(madera.getId().toString());
                maderaDTO.setNombre(madera.getNombre());
                maderaDTO.setDescripcion(madera.getDescripcion());
                maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
                maderaDTO.setCantidad(madera.getCantidad());
                listaMaderasDTO.add(maderaDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las maderas", e);
        }
        return listaMaderasDTO;
    }

    @Override
    public MaderaDTO buscarMaderaPorId(String id) {
        try {
            Madera madera = iMaderaDAO.buscarMaderaPorId(id);

            if (madera != null) {

                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setId(madera.getId().toString());
                maderaDTO.setNombre(madera.getNombre());
                maderaDTO.setDescripcion(madera.getDescripcion());
                maderaDTO.setCantidad(madera.getCantidad());
                maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
                return maderaDTO;
            } else {
                throw new RuntimeException("Madera no encontrada con el ID proporcionado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al buscar la madera por ID", e);
        }
    }

    public MaderaDTO buscarMaderaPorNombre(String nombre) {
        try {
            Madera madera = iMaderaDAO.buscarMaderaPorNombre(nombre);

            if (madera != null) {
                MaderaDTO maderaDTO = new MaderaDTO();
                maderaDTO.setId(madera.getId().toString());
                maderaDTO.setNombre(madera.getNombre());
                maderaDTO.setDescripcion(madera.getDescripcion());
                maderaDTO.setCantidad(madera.getCantidad());
                maderaDTO.setPrecioUnitario(madera.getPrecioUnitario());
                return maderaDTO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra la madera
    }

    @Override
    public void editarMadera(MaderaDTO maderaDTO) {
        // Crear una entidad Madera a partir del DTO
        Madera madera = new Madera();
        madera.setId(new ObjectId(maderaDTO.getId()));
        madera.setNombre(maderaDTO.getNombre());
        madera.setDescripcion(maderaDTO.getDescripcion());
        madera.setCantidad(maderaDTO.getCantidad());
        madera.setPrecioUnitario(maderaDTO.getPrecioUnitario());
        System.out.println(maderaDTO.getId());
        try {
            // Llama al método del DAO para editar/actualizar la madera
            iMaderaDAO.editarMadera(madera);
        } catch (Exception e) {
            // Manejo de excepciones si ocurre algún error en la actualización
            throw new RuntimeException("Error al editar la madera en la base de datos", e);
        }
    }

    @Override
    public boolean eliminarMadera(String id) {
        return iMaderaDAO.eliminarMadera(id);
    }

}
