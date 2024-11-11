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

/**
 *
 * @author Oley
 */
public class MaderaNegocio implements  IMadereraNegocio{
private IMaderaDAO iMaderaDAO;

    public MaderaNegocio() {
        this.iMaderaDAO = new MaderaDAO();
    }

   

    @Override
    public MaderaDTO agregarMadera(MaderaDTO maderaDTO) {
          Madera madera=new Madera();
          madera.setNombre(maderaDTO.getNombre());
           madera.setDescripcion(maderaDTO.getDescripcion());
          madera.setCantidad(maderaDTO.getCantidad());
madera.setPrecioUnitario(maderaDTO.getPrecioUnitario());
Madera maderaGuardada= iMaderaDAO.agregarMadera(madera);

if(maderaGuardada!=null){
    MaderaDTO maderaDTO1=new MaderaDTO();
    maderaDTO1.setNombre(maderaGuardada.getNombre());
    maderaDTO1.setDescripcion(maderaGuardada.getDescripcion());
    maderaDTO1.setCantidad(maderaGuardada.getCantidad());
    maderaDTO1.setPrecioUnitario(maderaGuardada.getPrecioUnitario());
    return maderaDTO1;
}else{
                throw new RuntimeException("Error al agregar la madera");
 
}




    }
    
}
