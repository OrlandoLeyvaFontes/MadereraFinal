/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Tarjetas;
import entidades.Usuario;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IUsuarioDAO {
    public Usuario agregarUsuario(Usuario usuario);
     public Usuario iniciarSesion(String correo, String contrasena);
     public boolean agregarTarjeta(ObjectId usuarioId, Tarjetas tarjeta);
}
