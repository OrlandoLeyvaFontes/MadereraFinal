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
 * Clase que maneja la lógica de negocio de las entradas en el sistema.
 * Interactúa con el DAO de Entradas para realizar operaciones CRUD sobre las
 * entradas y devolver los resultados en forma de objetos DTO.
 */
public class EntradasNegocio implements IEntradasNegocio {

    // Instancia del DAO de entradas
    private IEntradasDAO iEntradasDAO;

    /**
     * Constructor que inicializa la instancia del DAO de Entradas.
     */
    public EntradasNegocio() {
        this.iEntradasDAO = new EntradasDAO();
    }

    /**
     * Agrega una nueva entrada al sistema. Convierte el DTO a la entidad
     * Entradas y luego la guarda utilizando el DAO.
     *
     * @param entradaDTO El DTO que contiene la información de la entrada a
     * agregar.
     * @return El DTO de la entrada agregada, con la información actualizada,
     * incluyendo su ID.
     */
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

    /**
     * Obtiene todas las entradas del sistema.
     *
     * @return Una lista de DTOs que representan las entradas en el sistema.
     */
    @Override
    public List<EntradasDTO> obtenerEntradas() {
        List<EntradasDTO> listaMaderasDTO = new ArrayList<>();
        try {
            // Obtener todas las entradas desde el DAO
            List<Entradas> listaEntradas = iEntradasDAO.obtenerEntradas();
            for (Entradas entradas : listaEntradas) {
                // Convertir cada entidad a su DTO correspondiente
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

    /**
     * Obtiene las entradas filtradas por tipo de entrada.
     *
     * @param tipoEntrada El tipo de entrada para filtrar las entradas.
     * @return Una lista de DTOs de entradas que coinciden con el tipo
     * especificado.
     */
    public List<EntradasDTO> obtenerEntradasPorTipo(String tipoEntrada) {
        List<EntradasDTO> listaEntradasDTO = new ArrayList<>();
        try {
            // Obtener las entradas filtradas por tipo
            List<Entradas> listaEntradas = iEntradasDAO.obtenerEntradasPorTipo(tipoEntrada);

            for (Entradas entradas : listaEntradas) {
                EntradasDTO entradasDTO = new EntradasDTO();
                entradasDTO.setId(entradas.getId().toString());
                entradasDTO.setTipoEntrada(entradas.getTipoEntrada());
                entradasDTO.setTipoMadera(entradas.getTipoMadera());
                entradasDTO.setCantidad(entradas.getCantidad());
                if (entradas.getFechaEntrada() != null) {
                    entradasDTO.setFechaEntrada(entradas.getFechaEntrada());
                }
                listaEntradasDTO.add(entradasDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las entradas por tipo", e);
        }
        return listaEntradasDTO;
    }

    /**
     * Obtiene la lista de tipos de entrada disponibles.
     *
     * @return Una lista de los tipos únicos de entradas en el sistema.
     */
    public List<String> obtenerTiposEntrada() {
        List<String> tiposEntrada = new ArrayList<>();
        try {
            // Obtener los tipos de entrada desde el DAO
            tiposEntrada = iEntradasDAO.obtenerTiposEntrada();  // Llamar al método DAO que obtiene los tipos únicos
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los tipos de entrada", e);
        }
        return tiposEntrada;
    }
}
