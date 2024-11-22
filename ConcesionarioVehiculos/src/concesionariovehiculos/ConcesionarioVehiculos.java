/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionariovehiculos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Semaphore;

/**
 *
 * @author SantiQ
 */

public class ConcesionarioVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore vehiculosDisponibles = new Semaphore(4);
        // Listamos los nombres de los clientes
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList(
        "Boni", "Santiago", "Angel Juan", "Nelson", "Luz Mario", "Javier", "Gabriel", "Juan Vicente", "Iñaki"));
         
        // Creamos los nueve clientes, cada uno con su nombre
        for (int i = 1; i <= 9; i++) {
            Collections.shuffle(nombres);
            String nombre = nombres.remove(0);
            
            Cliente cliente = new Cliente(nombre, vehiculosDisponibles);
            cliente.start();
        }
    }
    
}
