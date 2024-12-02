/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.EntradasDAO;
import dto.EntradasDTO;
import entidades.Entradas;
import interfacesDAO.IEntradasDAO;
import interfacesDTO.IEntradasNegocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleja
 */
public class EntradasNegocio implements IEntradasNegocio {

    private IEntradasDAO iEntradasDAO;

    public EntradasNegocio() {
        this.iEntradasDAO = new EntradasDAO();
    }

    @Override
    public EntradasDTO agregarEntrada(EntradasDTO entradaDTO) {
        // Convertir el DTO a la entidad
        Entradas entrada = new Entradas();
        entrada.setTipoEntrada(entradaDTO.getTipoEntrada());
        entrada.setTipoMadera(entradaDTO.getTipoMadera());
        entrada.setCantidad(entradaDTO.getCantidad());
        entrada.setFechaEntrada(LocalDate.now()); // Asignar la fecha actual

        // Guardar la entrada utilizando el DAO
        Entradas entradaGuardada = iEntradasDAO.guardarEntrada(entrada);

        if (entradaGuardada != null) {
            // Convertir la entidad guardada a DTO
            EntradasDTO entradaDTOGuardada = new EntradasDTO();
            entradaDTOGuardada.setTipoEntrada(entradaGuardada.getTipoEntrada());
            entradaDTOGuardada.setTipoMadera(entradaGuardada.getTipoMadera());
            entradaDTOGuardada.setCantidad(entradaGuardada.getCantidad());
            entradaDTOGuardada.setFechaEntrada(entradaGuardada.getFechaEntrada());
            return entradaDTOGuardada;
        } else {
            throw new RuntimeException("Error al agregar la entrada.");
        }
    }

    @Override
    public List<EntradasDTO> obtenerMaderas() {
        List<EntradasDTO> listaMaderasDTO = new ArrayList<>();
        try {
            List<Entradas> listaEntradas = iEntradasDAO.obtenerMaderas();
            for (Entradas entradas : listaEntradas) {
                EntradasDTO entradasDTO = new EntradasDTO();
                entradasDTO.setId(entradas.getId().toString());
                entradasDTO.setTipoEntrada(entradas.getTipoEntrada());
                entradasDTO.setTipoMadera(entradas.getTipoMadera());
                entradasDTO.setCantidad(entradas.getCantidad());
                if (entradas.getFechaEntrada() != null) {
                    entradasDTO.setFechaEntrada(entradas.getFechaEntrada());
                }
                listaMaderasDTO.add(entradasDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las maderas", e);
        }
        return listaMaderasDTO;
    }

}
