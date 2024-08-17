/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inyector;

/**
 *
 * @author Regina
 */
public class inyectar {
    
    static Persona InyectarServicio(String nombre, String mensaje, Servicio servicioemail){//aqui creamos nuestro metodo donde se estan inyectando las opciones a las clases
    
        switch(servicioemail) {
		case GMAIL: 
			return new Persona(nombre,mensaje, new Gmail("Gmail"));
		case HOTMAIL:
			return new Persona(nombre,mensaje,new Hotmail("Hotmail "));
		case YAHOO:
			return new Persona(nombre,mensaje,new Yahoo("Yahoo!"));
		default:
			throw new UnsupportedOperationException("Servicio de correo no existente");
		}
    
    
    }
    
   
}
