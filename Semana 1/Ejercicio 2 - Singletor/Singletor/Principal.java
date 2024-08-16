/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Singletor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Regina
 */
public class Principal {

    public static void main(String[] args) {
        // TODO code application logic here
   Configuracion configuracion1 = Configuracion.getInstance("verde"); //se crea la instancia y agregamos un color
   System.out.println(configuracion1);
   Configuracion configuracion2 = Configuracion.getInstance("rosa");
   System.out.println(configuracion2);
   Configuracion configuracion3 = Configuracion.getInstance("azul");
   System.out.println(configuracion3);   
    }
    
}
