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
 *
 * @author aleja
 */
public class MaderaVentaSS implements IMaderaVentaSS {

    IMadereraNegocio iMadereraNegocio;

    public MaderaVentaSS() {
        this.iMadereraNegocio = new MaderaNegocio();
    }

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

    @Override
    public MaderaDTO obtenerMaderaPorNombre(String nombre) {
        return iMadereraNegocio.buscarMaderaPorNombre(nombre);
    }

    @Override
    public List<MaderaDTO> obtenerMaderas() {
        return iMadereraNegocio.obtenerMaderas();
    }

    public MaderaDTO buscarMaderaPorId(String id) {
        return iMadereraNegocio.buscarMaderaPorId(id);
    }
}
