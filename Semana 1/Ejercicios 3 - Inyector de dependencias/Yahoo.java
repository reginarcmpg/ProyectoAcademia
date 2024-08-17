/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inyector;

/**
 *
 * @author Regina
 */
public class Yahoo implements ServicioEmail{
    
       private String tipo;

    public Yahoo(String tipo) {
        this.tipo = tipo;
        
    }

    public void mensajae() {
        System.out.println("Se envio mediante " + tipo);
         System.out.println();
    }
    
}
