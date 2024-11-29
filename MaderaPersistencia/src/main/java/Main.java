import dao.CompraDAO;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de CompraDAO
        CompraDAO compraDAO = new CompraDAO();

        // Ejemplo de usuarioId para realizar la prueba
        // Cambia este ID por uno válido en tu base de datos
        String usuarioIdStr = "6747f2f458cf237c90f67465"; // Reemplazar con un ID real
        try {
            ObjectId usuarioId = new ObjectId(usuarioIdStr);

            // Llamar al método y obtener los resultados
            List<Document> compras = compraDAO.obtenerComprasPorUsuarioId(usuarioId);

            // Imprimir los resultados en consola
            if (!compras.isEmpty()) {
                System.out.println("Compras del usuario con ID: " + usuarioIdStr);
                for (Document compra : compras) {
                    System.out.println("-------------------------");
                    System.out.println("Fecha de Compra: " + compra.getDate("fechaCompra"));
                    System.out.println("Nombre de Madera: " + compra.getString("nombreMadera"));
                    System.out.println("Cantidad Comprada: " + compra.getInteger("cantidad"));
                    System.out.println("Precio Total: " + compra.getDouble("precioTotal"));
                }
            } else {
                System.out.println("No se encontraron compras para el usuario con ID: " + usuarioIdStr);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("El ID de usuario ingresado no es válido: " + usuarioIdStr);
        }
    }
}
