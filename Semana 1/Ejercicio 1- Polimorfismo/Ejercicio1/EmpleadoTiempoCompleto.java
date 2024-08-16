/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sem1.Ejercicio1;

/**
 *
 * @author Regina
 */
public class EmpleadoTiempoCompleto extends Trabajador  {
    
    int bono;//atributos
      int Pago;
   

    public EmpleadoTiempoCompleto(String nombre, int identificador, int SalarioBase) {
        super(nombre, identificador, SalarioBase);
        this.bono = 200;
       
       
    }
    
  

    @Override
    public int CalcularPago() {//Polimorfismo porque en cada clase hace cosas diferentes
        Pago =  getSalarioBase() * bono;
        return Pago;
    }

    @Override
    public void RealizarPago() {
         System.out.println("Empleado: " + getNombre() + " con un sueldo de:  " + CalcularPago());
     
    }
}
