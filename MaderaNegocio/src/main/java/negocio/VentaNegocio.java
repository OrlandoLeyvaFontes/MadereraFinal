/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.VentaDAO;
import dto.MaderaDTO;
import dto.UsuarioDTO;
import dto.VentaDTO;
import entidades.Ventas;
import interfacesDAO.IVentaDAO;
import interfacesDTO.IVentaNegocio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Oley
 */
public class VentaNegocio implements  IVentaNegocio{
     private IVentaDAO ventaDAO;

    public VentaNegocio( ) {
        this.ventaDAO = new VentaDAO();
    }
      public List<VentaDTO> obtenerVentas() {
         List<VentaDTO> ventasDTOList = new ArrayList<>();
        
        try {
            List<Ventas> ventasList = ventaDAO.obtenerVentas();
            
            for (Ventas venta : ventasList) {
                VentaDTO ventasDTO = new VentaDTO();
                ventasDTO.setId(venta.getId().toString());
                ventasDTO.setCantidad(venta.getCantidad());
                ventasDTO.setPrecioTotal(venta.getPrecioTotal());
                
                if (venta.getFechaVenta() != null) {
                    ventasDTO.setFechaVenta(venta.getFechaVenta().getTime());
                }
                
                if (venta.getMadera() != null) {
                    MaderaDTO maderaDTO = new MaderaDTO();
                    maderaDTO.setId(venta.getMadera().getId().toString());
                    maderaDTO.setNombre(venta.getMadera().getNombre());
                    maderaDTO.setPrecioUnitario(venta.getMadera().getPrecioUnitario());
                    ventasDTO.setMadera(maderaDTO);
                }
                
                if (venta.getUsuario() != null) {
                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    usuarioDTO.setId(venta.getUsuario().getId().toString());
                    usuarioDTO.setNombre(venta.getUsuario().getNombre());
                    ventasDTO.setUsuario(usuarioDTO);
                }
                
                ventasDTOList.add(ventasDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ventasDTOList;
    }
     
}
