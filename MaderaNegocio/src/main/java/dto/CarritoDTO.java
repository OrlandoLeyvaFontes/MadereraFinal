/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Madera;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CarritoDTO {
     private String id;
    private UsuarioDTO usuarioDTO; 
    private List<MaderaDTO> maderasDTO; 
    private List<Integer> cantidades; 
    private double total; 

    public CarritoDTO() {
        this.maderasDTO = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    public CarritoDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
        this.maderasDTO = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public List<MaderaDTO> getMaderasDTO() {
        return maderasDTO;
    }

    public void setMaderasDTO(List<MaderaDTO> maderasDTO) {
        this.maderasDTO = maderasDTO;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   

    
}
