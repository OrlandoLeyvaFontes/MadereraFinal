/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.CarritoDAO;
import dto.CarritoDTO;
import dto.MaderaDTO;
import interfacesDAO.ICarritoDAO;
import interfacesDTO.ICarritoNegocio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Oley
 */
public class CarritoNegocio implements  ICarritoNegocio{
private ICarritoDAO  iCarritoDAO;

    public CarritoNegocio( ) {
        this.iCarritoDAO = new CarritoDAO();
    }

    @Override
    public void agregarProducto(String usuarioId, String maderaId, int cantidad) {
 if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }
        
        ObjectId usuarioObjectId = new ObjectId(usuarioId);
        ObjectId maderaObjectId = new ObjectId(maderaId);
        iCarritoDAO.agregarProducto(usuarioObjectId, maderaObjectId, cantidad);    }

   @Override
public List<CarritoDTO> obtenerCarrito(String usuarioId) {
 if (usuarioId == null || usuarioId.isEmpty()) {
        throw new IllegalArgumentException("User ID cannot be null or empty.");
    }

    ObjectId usuarioObjectId = new ObjectId(usuarioId);
    Document carrito = iCarritoDAO.obtenerCarrito(usuarioObjectId);

    if (carrito == null) {
        throw new RuntimeException("No cart found for the user with ID: " + usuarioId);
    }

    // Crear una lista para almacenar los CarritoDTOs
    List<CarritoDTO> carritoDTOList = new ArrayList<>();

    List<Document> productos = (List<Document>) carrito.get("maderas");

    if (productos == null || productos.isEmpty()) {
        throw new RuntimeException("No products found in the cart for user with ID: " + usuarioId);
    }

    double totalCarrito = 0.0;

    // Iterar sobre los productos y agregar cada uno a la lista
    for (Document producto : productos) {
        // Obtener precio y cantidad de manera segura, usando un valor predeterminado si es null
        Double precio = Optional.ofNullable(producto.getDouble("precio")).orElse(0.0);
        Integer cantidad = Optional.ofNullable(producto.getInteger("cantidad")).orElse(0);

        // Crear DTO para cada producto
        MaderaDTO maderaDTO = new MaderaDTO(
            producto.getString("nombre"),
            precio
        );

        // Crear un CarritoDTO para cada producto
        CarritoDTO carritoDTO = new CarritoDTO();
        carritoDTO.getMaderasDTO().add(maderaDTO);
        carritoDTO.getCantidades().add(cantidad);

        // Calcular el total del producto de manera segura
        double totalProducto = precio * cantidad;
        carritoDTO.setTotal(totalProducto);

        // Añadir el producto al carritoDTOList
        carritoDTOList.add(carritoDTO);

        // Sumar al total del carrito
        totalCarrito += totalProducto;
    }

    // Si es necesario, puedes agregar el total del carrito al primer CarritoDTO o manejarlo como un dato aparte
    // carritoDTOList.get(0).setTotal(totalCarrito);

    return carritoDTOList;
}


    @Override
    public void eliminarProducto(String usuarioId, String maderaId) {
 ObjectId usuarioObjectId = new ObjectId(usuarioId);
        ObjectId maderaObjectId = new ObjectId(maderaId);
        iCarritoDAO.eliminarProducto(usuarioObjectId, maderaObjectId);    }

    
    
  public void vaciarCarrito(String usuarioId) {
        if (usuarioId == null || usuarioId.isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo o vacío.");
        }

        ObjectId usuarioObjectId = new ObjectId(usuarioId);

        iCarritoDAO.vaciarCarrito(usuarioObjectId);

        System.out.println("El carrito del usuario ha sido vaciado en la capa de negocio.");
    }

    
    
}
