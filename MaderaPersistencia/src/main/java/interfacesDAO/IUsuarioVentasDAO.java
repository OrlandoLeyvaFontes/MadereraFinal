/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.UsuarioVentas;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author aleja
 */
public interface IUsuarioVentasDAO {

    public UsuarioVentas agregarUsuario(UsuarioVentas usuarioVentas);

    public UsuarioVentas iniciarSesion(String correo, String contrasena);

    public UsuarioVentas obtenerUsuarioPorId(ObjectId id);

    public List<Document> obtenerMaderasPorUsuarioVenta(ObjectId idUsuarioVenta);
}
