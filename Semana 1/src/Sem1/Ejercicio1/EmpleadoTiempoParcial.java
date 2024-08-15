/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sem1.Ejercicio1;

/**
 *
 * @author Regina
 */
public class EmpleadoTiempoParcial extends Trabajador{
    
    int HorasTrabajadas;
      int Pago;
    
       public EmpleadoTiempoParcial(String nombre, int identificador, int SalarioBase, int HorasTrabajadas) {
        super(nombre, identificador, SalarioBase);
         this.HorasTrabajadas = HorasTrabajadas;
        
       
       
    }
    

    @Override
    int CalcularPago() {
       Pago =  getSalarioBase() * HorasTrabajadas;
        return Pago;
    }

    @Override
    public void RealizarPago() {
         System.out.println("Empleado: " + getNombre() + " con un sueldo de:  " + CalcularPago());
     
    }
    
}
