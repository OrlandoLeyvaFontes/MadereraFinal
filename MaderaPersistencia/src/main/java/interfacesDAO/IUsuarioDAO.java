/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Tarjetas;
import entidades.Usuario;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public interface IUsuarioDAO {

    public Usuario agregarUsuario(Usuario usuario);

    public Usuario iniciarSesion(String correo, String contrasena);

    public boolean agregarTarjeta(ObjectId usuarioId, Tarjetas tarjeta);

    public List<String> obtenerNumerosTarjetasPorUsuario(ObjectId idUsuario);

    public Usuario obtenerUsuarioPorId(ObjectId id);

 public boolean iniciarSesionPorCVV(String numero, String cvv);

 public Usuario buscarPorCorreo(String correo);
}
