/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcionamiento;

import dto.EntradasDTO;
import interfacesDTO.IEntradasNegocio;
import interfaz.IEntradaSS;
import java.util.List;
import negocio.EntradasNegocio;

/**
 *
 * @author aleja
 */
public class EntradaSS implements IEntradaSS {

    private IEntradasNegocio iEntradaNegocio;

    public EntradaSS() {
        this.iEntradaNegocio = new EntradasNegocio();
    }

    @Override
    public EntradasDTO registrarEntrada(EntradasDTO entradasDTO) {
        try {
            EntradasDTO entradasDTO1 = iEntradaNegocio.agregarEntrada(entradasDTO);
            if (entradasDTO1 != null) {
                return entradasDTO1;
            } else {
                throw new RuntimeException("Error al agregar la entrada.");

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar agregar la entrada: " + e.getMessage());

        }
    }

    public List<EntradasDTO> obtenerEntradas() {
        try {
            List<EntradasDTO> entradasDTO1 = iEntradaNegocio.obtenerEntradas();
            if (entradasDTO1 != null) {
                return entradasDTO1;
            } else {
                throw new RuntimeException("Error al imprimir las entradas: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrio un error al intentar imprimir las entradas: " + e.getMessage());
        }
    }

    public List<EntradasDTO> obtenerEntradasPorTipo(String tipoEntrada) {
        try {
            List<EntradasDTO> entradasDTO1 = iEntradaNegocio.obtenerEntradasPorTipo(tipoEntrada);
            if (entradasDTO1 != null) {
                return entradasDTO1;
            } else {
                throw new RuntimeException("Error al imprimir las entradas: ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrio un error al intentar imprimir las entradas: " + e.getMessage());
        }
    }

    public List<String> obtenerTiposEntrada() {
        try {
            // Llamar al método de la capa de negocio para obtener los tipos de entrada
            List<String> tiposEntrada = iEntradaNegocio.obtenerTiposEntrada();
            if (tiposEntrada != null) {
                return tiposEntrada;
            } else {
                throw new RuntimeException("Error al obtener los tipos de entrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ocurrió un error al intentar obtener los tipos de entrada: " + e.getMessage());
        }
    }
}
