/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.UsuarioVentasDAO;
import dto.UsuarioVentasDTO;
import entidades.UsuarioVentas;
import interfacesDAO.IUsuarioVentasDAO;
import interfacesDTO.IMadereraNegocio;
import interfacesDTO.IUsuarioVentasNegocio;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Esta clase implementa la lógica de negocio para gestionar usuarios de ventas.
 * Realiza las operaciones de agregar usuario, iniciar sesión y obtener un
 * usuario por su ID.
 */
public class UsuarioVentasNegocio implements IUsuarioVentasNegocio {

    private IUsuarioVentasDAO usuarioVentasDAO; // Instancia para interactuar con la base de datos.
    private IMadereraNegocio madereraNegocio;  // Esta instancia no está en uso actualmente.

    /**
     * Constructor que inicializa las instancias de los DAOs e interfaces
     * necesarias.
     */
    public UsuarioVentasNegocio() {
        this.usuarioVentasDAO = new UsuarioVentasDAO(); // Inicialización del DAO de usuarios de ventas.
        this.madereraNegocio = new MaderaNegocio();     // Inicialización de la interfaz de Maderera, aunque no se usa aquí.
    }

    /**
     * Método para agregar un nuevo usuario de ventas.
     *
     * @param usuarioVentasDTO Objeto DTO con los datos del usuario.
     * @return UsuarioVentasDTO El DTO del usuario recién agregado.
     * @throws RuntimeException Si hay un error al agregar el usuario.
     */
    @Override
    public UsuarioVentasDTO agregarUsuario(UsuarioVentasDTO usuarioVentasDTO) {
        // Encriptar la contraseña utilizando BCrypt
        String hashedPassword = BCrypt.hashpw(usuarioVentasDTO.getContraseña(), BCrypt.gensalt());

        // Crear la entidad UsuarioVentas y asignar los valores
        UsuarioVentas usuarioVentas = new UsuarioVentas();
        usuarioVentas.setNombre(usuarioVentasDTO.getNombre());
        usuarioVentas.setApellidoMaterno(usuarioVentasDTO.getApellidoMaterno());
        usuarioVentas.setApellidoPaterno(usuarioVentasDTO.getApellidoPaterno());
        usuarioVentas.setCorreo(usuarioVentasDTO.getCorreo());
        usuarioVentas.setNumero(usuarioVentasDTO.getNumero());
        usuarioVentas.setContraseña(hashedPassword); // Almacenar la contraseña encriptada

        System.out.println(usuarioVentas); // Depuración: Imprimir la entidad creada para verificar datos

        // Guardar usuario en la base de datos
        UsuarioVentas usuarioVentaGuardado = usuarioVentasDAO.agregarUsuario(usuarioVentas);

        // Verificar si el usuario fue guardado correctamente
        if (usuarioVentaGuardado != null) {
            // Convertir la entidad guardada a DTO para ser devuelta
            UsuarioVentasDTO usuarioVentasGuardadoDTO = new UsuarioVentasDTO();
            usuarioVentasGuardadoDTO.setNombre(usuarioVentaGuardado.getNombre());
            usuarioVentasGuardadoDTO.setApellidoMaterno(usuarioVentaGuardado.getApellidoMaterno());
            usuarioVentasGuardadoDTO.setApellidoPaterno(usuarioVentaGuardado.getApellidoPaterno());
            usuarioVentasGuardadoDTO.setCorreo(usuarioVentaGuardado.getCorreo());
            usuarioVentasGuardadoDTO.setNumero(usuarioVentaGuardado.getNumero());
            usuarioVentasGuardadoDTO.setContraseña(usuarioVentaGuardado.getContraseña());
            return usuarioVentasGuardadoDTO;
        } else {
            throw new RuntimeException("Error al agregar el usuario de ventas. Intente más tarde.");
        }
    }

    /**
     * Método para iniciar sesión de un usuario de ventas.
     *
     * @param correo Correo del usuario.
     * @param contrasena Contraseña ingresada por el usuario.
     * @return UsuarioVentasDTO El DTO del usuario si las credenciales son
     * correctas.
     * @throws RuntimeException Si las credenciales son incorrectas o el usuario
     * no existe.
     */
    @Override
    public UsuarioVentasDTO iniciarSesion(String correo, String contrasena) {
        // Obtener el usuario de la base de datos por correo
        UsuarioVentas usuarioVenta = usuarioVentasDAO.iniciarSesion(correo);

        // Verificar si el usuario existe
        if (usuarioVenta == null) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        // Imprimir contraseñas para depuración (NO recomendable para producción)
        System.out.println("Contraseña ingresada: " + contrasena);
        System.out.println("Contraseña almacenada (hash): " + usuarioVenta.getContraseña());

        // Validar la contraseña usando BCrypt
        boolean contraseñaValida = BCrypt.checkpw(contrasena, usuarioVenta.getContraseña());
        if (contraseñaValida) {
            System.out.println("Inicio de sesión exitoso");
        } else {
            System.out.println("Contraseña incorrecta");
            throw new RuntimeException("Credenciales incorrectas");
        }

        // Crear el DTO con los datos del usuario
        UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
        usuarioVentaDTO.setNombre(usuarioVenta.getNombre());
        usuarioVentaDTO.setApellidoMaterno(usuarioVenta.getApellidoMaterno());
        usuarioVentaDTO.setApellidoPaterno(usuarioVenta.getApellidoPaterno());
        usuarioVentaDTO.setCorreo(usuarioVenta.getCorreo());
        usuarioVentaDTO.setNumero(usuarioVenta.getNumero());
        usuarioVentaDTO.setContraseña(usuarioVenta.getContraseña());

        return usuarioVentaDTO;
    }

    /**
     * Método para obtener un usuario de ventas a partir de su ID.
     *
     * @param id El ID del usuario.
     * @return UsuarioVentasDTO El DTO del usuario encontrado.
     * @throws RuntimeException Si el usuario no se encuentra o hay un error.
     */
    @Override
    public UsuarioVentasDTO obtenerUsuarioPorId(String id) {
        try {
            // Convertir el ID de String a ObjectId de MongoDB
            ObjectId objectId = new ObjectId(id);
            // Obtener el usuario de la base de datos
            UsuarioVentas usuarioVenta = usuarioVentasDAO.obtenerUsuarioPorId(objectId);

            // Verificar si el usuario existe
            if (usuarioVenta == null) {
                throw new RuntimeException("Usuario de ventas no encontrado");
            }

            // Convertir la entidad UsuarioVentas a un DTO
            UsuarioVentasDTO usuarioVentaDTO = new UsuarioVentasDTO();
            usuarioVentaDTO.getId().toString(); // Posiblemente deberías establecer el ID en el DTO.
            usuarioVentaDTO.getNombre(); // Faltan las asignaciones de los valores en el DTO
            usuarioVentaDTO.getApellidoMaterno();
            usuarioVentaDTO.getApellidoPaterno();
            usuarioVentaDTO.getCorreo();
            usuarioVentaDTO.getNumero();
            usuarioVentaDTO.getContraseña();

            return usuarioVentaDTO;

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el usuario de ventas: " + e.getMessage(), e);
        }
    }
}
