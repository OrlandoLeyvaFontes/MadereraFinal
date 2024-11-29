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
public class MaderaSS implements IMaderaSS {

    IMadereraNegocio iMadereraNegocio;

    public MaderaSS() {
        this.iMadereraNegocio = new MaderaNegocio();
    }

    @Override
    public List<MaderaDTO> obtenerMaderas() {
        return iMadereraNegocio.obtenerMaderas();
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

        }    }

    @Override
    public MaderaDTO buscarMaderaPorId(String id) {
return  iMadereraNegocio.buscarMaderaPorId(id);
    }

    @Override
    public MaderaDTO buscarMaderaPorNombre(String nombre) {
 return iMadereraNegocio.buscarMaderaPorNombre(nombre);
    }

}
