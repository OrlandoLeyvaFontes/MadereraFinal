/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesDAO;

import entidades.Entradas;
import java.util.List;

/**
 *
 * @author aleja
 */
public interface IEntradasDAO {

    public Entradas guardarEntrada(Entradas entrada);

    public List<Entradas> obtenerMaderas();
}
