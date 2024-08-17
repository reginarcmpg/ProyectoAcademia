/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inyector;

/**
 *
 * @author Regina
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona Env1 = inyectar.InyectarServicio("Romina","Hola que tal", Servicio.GMAIL);
        Env1.enviar();
    }
    
}
