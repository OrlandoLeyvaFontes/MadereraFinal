/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
import entidades.Usuario;
import interfacesDAO.IUsuarioDAO;
import interfacesDTO.IUsuarioNegocio;

/**
 *
 * @author Oley
 */
public class UsuarioNegocio implements  IUsuarioNegocio{
private IUsuarioDAO iusuarioDAO;

    public UsuarioNegocio() {
        this.iusuarioDAO = new UsuarioDAO() ;
    }

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) {
            Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellidoPaterno(usuarioDTO.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioDTO.getApellidoMaterno());
        usuario.setNumero(usuarioDTO.getNumero());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContraseña(usuarioDTO.getContraseña());

        Usuario usuarioGuardado = iusuarioDAO.agregarUsuario(usuario);

        if (usuarioGuardado != null) {
            UsuarioDTO usuarioDTOResponse = new UsuarioDTO();
            usuarioDTOResponse.setNombre(usuarioGuardado.getNombre());
            usuarioDTOResponse.setApellidoPaterno(usuarioGuardado.getApellidoPaterno());
            usuarioDTOResponse.setApellidoMaterno(usuarioGuardado.getApellidoMaterno());
            usuarioDTOResponse.setNumero(usuarioGuardado.getNumero());
            usuarioDTOResponse.setCorreo(usuarioGuardado.getCorreo());
            usuarioDTOResponse.setContraseña(usuarioGuardado.getContraseña());
            usuarioDTOResponse.setId(usuarioGuardado.getId().toString());  
            return usuarioDTOResponse;
        } else {
            throw new RuntimeException("Error al agregar el usuario, intentelo más tarde");
        }
    }

    @Override
    public UsuarioDTO iniciarSesion(String correo, String contrasena) {
     Usuario usuario = iusuarioDAO.iniciarSesion(correo, contrasena);

    if (usuario != null) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        
        usuarioDTO.setId(usuario.getId().toString());
        
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellidoPaterno(usuario.getApellidoPaterno());
        usuarioDTO.setApellidoMaterno(usuario.getApellidoMaterno());
        usuarioDTO.setNumero(usuario.getNumero());
        usuarioDTO.setCorreo(usuario.getCorreo());
        
        return usuarioDTO; 
    } else {
        System.out.println("Credenciales incorrectas");
        return null;
    }}

    

    
   
    
}
