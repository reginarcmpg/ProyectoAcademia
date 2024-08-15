/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sem1.Ejercicio1;

/**
 *
 * @author Regina
 */
public abstract class Trabajador implements Pagable { //aqui estammos creando nuestra clase abstracta
    
    private String nombre;//atributos
    private int identificador;
    private int SalarioBase;
   
    
     Trabajador(String nombre, int identificador, int SalarioBase){//constructores
    this.nombre = nombre;
    this.identificador = identificador;
    this.SalarioBase = SalarioBase;
   
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(int SalarioBase) {
        this.SalarioBase = SalarioBase;
    }
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
      abstract int CalcularPago(); //metodo abstracto 
    
    
   
}
