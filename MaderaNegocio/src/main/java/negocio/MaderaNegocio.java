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

    @Override
    public List<MaderaDTO> obtenerMaderasPorCorreoUsuarioVenta(String correoUsuarioVenta) {
        
        try {
            if (correoUsuarioVenta == null || correoUsuarioVenta.isEmpty()) {
                MaderaDAO maderaDAO = new MaderaDAO();
            List<MaderaDTO> maderas = maderaDAO.buscarMaderaPorCorreoVendedor(correoUsuarioVenta);
            }

            // Buscar las maderas asociadas al vendedor utilizando el correo
            MaderaDAO maderaDAO = new MaderaDAO();
            List<MaderaDTO> maderas = maderaDAO.buscarMaderaPorCorreoVendedor(correoUsuarioVenta);

            // Si no se encuentran maderas asociadas al vendedor
            if (maderas == null || maderas.isEmpty()) {
                System.out.println("El usuario de ventas no tiene maderas asociadas.");
                return new ArrayList<>();
            }

            return maderas;

        } catch (Exception e) {
            System.err.println("Error al obtener las maderas del usuario de ventas: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>(); // Retornar una lista vacía en caso de error
        }
    }

    @Override
    public MaderaDTO agregarMaderaPorCorreo(MaderaDTO maderaDTO, String correoVendedor) {
        if (correoVendedor == null || correoVendedor.isEmpty()) {
            throw new IllegalArgumentException("El correo del vendedor no puede ser nulo o vacío.");
        }

        Madera madera = new Madera();
        madera.setNombre(maderaDTO.getNombre());
        madera.setDescripcion(maderaDTO.getDescripcion());
        madera.setCantidad(maderaDTO.getCantidad());
        madera.setPrecioUnitario(maderaDTO.getPrecioUnitario());
        madera.setCorreoVendedor(maderaDTO.getCorreoVendedor()); // Asociar la madera con el correo del vendedor

        Madera maderaGuardada = iMaderaDAO.agregarMadera(madera);

        if (maderaGuardada != null) {
            MaderaDTO maderaDTO1 = new MaderaDTO();
            maderaDTO1.setId(maderaGuardada.getId().toString());
            maderaDTO1.setNombre(maderaGuardada.getNombre());
            maderaDTO1.setDescripcion(maderaGuardada.getDescripcion());
            maderaDTO1.setCantidad(maderaGuardada.getCantidad());
            maderaDTO1.setPrecioUnitario(maderaGuardada.getPrecioUnitario());
            maderaDTO1.setCorreoVendedor(maderaGuardada.getCorreoVendedor());
            return maderaDTO1;
        } else {
            throw new RuntimeException("Error al agregar la madera");
        }
    }

}
