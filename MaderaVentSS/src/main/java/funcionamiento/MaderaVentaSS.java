/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionamiento;

import dto.MaderaDTO;
import interfacesDTO.IMadereraNegocio;
import interfaz.IMaderaVentaSS;
import java.util.List;
import negocio.MaderaNegocio;

/**
 * Clase que implementa la interfaz IMaderaVentaSS y proporciona los métodos
 * necesarios para la gestión de la venta de madera en el sistema. Esta clase se
 * encarga de delegar las operaciones a la capa de negocio (MaderaNegocio) para
 * realizar acciones sobre las maderas, como agregar, editar, eliminar, buscar y
 * obtener maderas.
 *
 * @author aleja
 */
public class MaderaVentaSS implements IMaderaVentaSS {

    // Instancia de la interfaz IMadereraNegocio, que representa la capa de negocio para maderas
    IMadereraNegocio iMadereraNegocio;

    /**
     * Constructor de la clase, que inicializa la instancia de la capa de
     * negocio.
     */
    public MaderaVentaSS() {
        this.iMadereraNegocio = new MaderaNegocio();
    }

    /**
     * Método que agrega una nueva madera al sistema. Delegado a la capa de
     * negocio para realizar la operación.
     *
     * @param maderaDTO Objeto de tipo MaderaDTO que contiene los datos de la
     * madera a agregar.
     * @return MaderaDTO Objeto que contiene la madera agregada.
     * @throws RuntimeException Si ocurre un error al agregar la madera.
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
     * Método que edita una madera existente en el sistema. Delegado a la capa
     * de negocio para realizar la operación.
     *
     * @param maderaDTO Objeto de tipo MaderaDTO que contiene los datos
     * actualizados de la madera.
     * @throws RuntimeException Si ocurre un error al editar la madera.
     */
    @Override
    public void editarMadera(MaderaDTO maderaDTO) {
        try {
            // Llamada al método del negocio para editar la madera
            iMadereraNegocio.editarMadera(maderaDTO);  // Aquí no esperamos ningún valor de retorno
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar editar la madera: " + e.getMessage());
        }
    }

    /**
     * Método que elimina una madera del sistema a través de su ID. Delegado a
     * la capa de negocio para realizar la operación.
     *
     * @param id Identificador único de la madera a eliminar.
     * @throws RuntimeException Si ocurre un error al intentar eliminar la
     * madera.
     */
    @Override
    public void eliminarMadera(String id) {
        try {
            // Llamada al método del negocio para eliminar la madera
            boolean eliminado = iMadereraNegocio.eliminarMadera(id);  // Se debe llamar al método "eliminarMadera" correctamente

            // Verificamos si la eliminación fue exitosa
            if (!eliminado) {
                throw new RuntimeException("No se encontró la madera con el ID proporcionado o ya fue eliminada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar eliminar la madera: " + e.getMessage());
        }
    }

    /**
     * Método que obtiene una madera en función de su nombre. Delegado a la capa
     * de negocio para realizar la operación.
     *
     * @param nombre Nombre de la madera a buscar.
     * @return MaderaDTO Objeto que contiene la madera encontrada.
     * @throws RuntimeException Si ocurre un error al intentar obtener la
     * madera.
     */
    @Override
    public MaderaDTO obtenerMaderaPorNombre(String nombre) {
        return iMadereraNegocio.buscarMaderaPorNombre(nombre);
    }

    /**
     * Método que obtiene todas las maderas disponibles en el sistema. Delegado
     * a la capa de negocio para realizar la operación.
     *
     * @return List<MaderaDTO> Lista de todas las maderas disponibles en el
     * sistema.
     * @throws RuntimeException Si ocurre un error al intentar obtener las
     * maderas.
     */
    @Override
    public List<MaderaDTO> obtenerMaderas() {
        return iMadereraNegocio.obtenerMaderas();
    }

    /**
     * Método que busca una madera en función de su identificador único (ID).
     * Delegado a la capa de negocio para realizar la operación.
     *
     * @param id Identificador único de la madera a buscar.
     * @return MaderaDTO Objeto que contiene la madera encontrada.
     * @throws RuntimeException Si ocurre un error al intentar buscar la madera
     * por ID.
     */
    public MaderaDTO buscarMaderaPorId(String id) {
        return iMadereraNegocio.buscarMaderaPorId(id);
    }
}
