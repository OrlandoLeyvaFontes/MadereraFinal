/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacesDTO;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import entidades.Tarjetas;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IUsuarioNegocio {

    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO);
     public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO);

    public UsuarioDTO iniciarSesion(String correo, String contrasena);
    public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario);
    public boolean iniciarSesionPorCVV(String cvv);



}
