/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dto.TarjetasDTO;
import dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author Oley
 */
public interface IUsuarioSS {
            public UsuarioDTO iniciarSesion(String correo, String contrasena);
            public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO);
                 public boolean agregarTarjeta(String usuarioId, TarjetasDTO tarjetasDTO);
        public boolean iniciarSesionPorCVV(String cvv);
        public List<String> obtenerNumerosTarjetasPorUsuario(String idUsuario);


}
