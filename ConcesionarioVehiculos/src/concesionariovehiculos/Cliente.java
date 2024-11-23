/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionariovehiculos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author SantiQ
 */

public class Cliente extends Thread{
    private String nombre;
    private Semaphore vehiculosDisponibles;
    
    
    public Cliente(String nombre, Semaphore vehiculosDisponibles) {
        this.nombre = nombre;
        this.vehiculosDisponibles = vehiculosDisponibles;
    }
     

    
    @Override
    public void run() {
        try {
            // Aqui el cliente intenta adquirir permiso para probar un vehículo y avisa con el Sout que lo está probando
            vehiculosDisponibles.acquire();
            System.out.println("+Don " + nombre + " está probando un vehículo");
            
            // Con el random simulamos el tiempo que lo esta probando
            sleep((long) (Math.random() * 4321 + 1000));

            // En este otro Sout el cliente avisa de cuando termina de probar el vehículo
            System.out.println("--Ya terminó Don " + nombre + " de probar el vehículo");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Con el finally que se ejecuta siempre, liberamos el permiso para que otro cliente pueda probar el vehículo
            vehiculosDisponibles.release();
        }
    }
}
