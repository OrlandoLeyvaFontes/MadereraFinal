/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dao.TarjetasDAO;
import dto.TarjetasDTO;
import entidades.Tarjetas;
import interfacesDAO.ITarjetasDAO;
import interfacesDTO.ITarjetasNegocio;

/**
 *
 * @author Oley
 */
/**
 * Implementación de la lógica de negocio para las tarjetas de pago.
 * no se uso

 */
public class TarjetasNegocio implements ITarjetasNegocio {

    /**
     * DAO para operaciones con tarjetas
     */

    private ITarjetasDAO iTarjetasDAO;
/**
     * Constructor que inicializa la referencia al DAO de tarjetas.
     */
    public TarjetasNegocio() {
        this.iTarjetasDAO = new TarjetasDAO();
    }

}
