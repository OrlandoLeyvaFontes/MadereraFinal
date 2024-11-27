/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDTO;

import dto.UsuarioVentasDTO;
import entidades.Madera;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author aleja
 */
public interface IUsuarioVentasNegocio {

    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO);

    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena);

    public UsuarioVentasDTO obtenerUsuarioPorId(String id);

    public List<Document> obtenerMaderasPorUsuarioVenta(String idUsuarioVenta);
}
