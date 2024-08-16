/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package Singletor;

/**
 *
 * @author Regina
 */
public class Configuracion {
    
    private String idioma;//atributos
    private String color;//atributos
     private static Configuracion configuracion; //instancia clase
    

     private Configuracion(String idioma) {//es un contructor privado para no crear multipleas instancias
        this.idioma = idioma;   
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
   
    
    public static Configuracion getInstance(String color) { //aqui obtenemos la instancia de la clase
        if(configuracion == null){
            configuracion = new Configuracion("español");//se determina el idioma de la configuracion
          configuracion.setColor(color);//agarra el color que tiene actualemte
            return configuracion;
        }else{
             configuracion.setColor(color);//toma el color por el que se cambio
            return configuracion;}
    }
    
    @Override
	public String toString() {
		return  "El idioma de la configuracion es:  "+ idioma + " Configuracion color= " + color ;
	}
    
   
}
