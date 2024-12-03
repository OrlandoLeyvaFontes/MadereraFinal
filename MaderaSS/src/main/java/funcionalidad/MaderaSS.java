/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionalidad;

import dto.MaderaDTO;
import interfacesDTO.IMadereraNegocio;
import interfaz.IMaderaSS;
import java.util.List;
import negocio.MaderaNegocio;

/**
 *
 * @author Oley
 */
/**
 * Clase MaderaSS
 *
 * Implementa la interfaz IMaderaSS y actúa como la capa de servicio para la
 * gestión de las operaciones relacionadas con las maderas. Interactúa con la
 * capa de negocio IMadereraNegocio para manejar la lógica correspondiente.
 */
public class MaderaSS implements IMaderaSS {

    IMadereraNegocio iMadereraNegocio;

    /**
     * Constructor por defecto. Inicializa la instancia de IMadereraNegocio como
     * una nueva instancia de MaderaNegocio.
     */
    public MaderaSS() {
        this.iMadereraNegocio = new MaderaNegocio();
    }

    /**
     * Obtiene la lista completa de maderas disponibles.
     *
     * @return Una lista de objetos MaderaDTO que representan las maderas
     * registradas.
     */
    @Override
    public List<MaderaDTO> obtenerMaderas() {
        return iMadereraNegocio.obtenerMaderas();
    }

    /**
     * Agrega una nueva madera al sistema.
     *
     * @param maderaDTO Objeto MaderaDTO que contiene los datos de la madera a
     * registrar.
     * @return El objeto MaderaDTO de la madera registrada.
     * @throws RuntimeException Si ocurre algún error al intentar agregar la
     * madera.
     */
    @Override
    public MaderaDTO agregarMadera(MaderaDTO maderaDTO) {
        try {
            MaderaDTO maderaDTO1 = iMadereraNegocio.agregarMadera(maderaDTO);
            if (maderaDTO1 != null) {
                return maderaDTO1;
            } else {
                throw new RuntimeException("Error al agregar la madera.");

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar la madera: " + e.getMessage());

        }
    }

    /**
     * Busca una madera por su identificador único.
     *
     * @param id Identificador de la madera a buscar.
     * @return El objeto MaderaDTO correspondiente a la madera encontrada.
     */
    @Override
    public MaderaDTO buscarMaderaPorId(String id) {
        return iMadereraNegocio.buscarMaderaPorId(id);
    }

    /**
     * Busca una madera por su nombre.
     *
     * @param nombre Nombre de la madera a buscar.
     * @return El objeto MaderaDTO correspondiente a la madera encontrada.
     */
    @Override
    public MaderaDTO buscarMaderaPorNombre(String nombre) {
        return iMadereraNegocio.buscarMaderaPorNombre(nombre);
    }

}
