/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inyector;

/**
 *
 * @author Regina
 */
public class Persona {
    
    private String nombre;
    private String mensaje;
    private ServicioEmail servicioemail;

   
     public Persona(String nombre, String mensaje, ServicioEmail servicioemail) { //aqui usamos el inyector mediante el constrcutor
            this.nombre = nombre;
            this.mensaje = mensaje;
            this.servicioemail = servicioemail;
        }
 
  
     void enviar(){//metodo
    System.out.println(nombre);
    System.out.println();
    System.out.println("Envio el siguiente mensaje: " + mensaje);
    servicioemail.mensajae();
    }
     
      public ServicioEmail getServicioemail() {
        return servicioemail;
    }

    public void setServicioemail(ServicioEmail servicioemail) {
        this.servicioemail = servicioemail;
    }
}
