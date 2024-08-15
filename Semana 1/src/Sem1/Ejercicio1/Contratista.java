/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sem1.Ejercicio1;

/**
 *
 * @author Regina
 */
public class Contratista extends Trabajador {
      int HorasTrabajadas;
      private int TarifaHora;
        int Pago;
    
       public Contratista(String nombre, int identificador, int SalarioBase, int HorasTrabajadas, int TarifaHora) {
        super(nombre, identificador, SalarioBase);
         this.HorasTrabajadas = HorasTrabajadas;
         this.TarifaHora = TarifaHora;
        
       
       
    }
    

    @Override
    int CalcularPago() {
       Pago =  TarifaHora * HorasTrabajadas;
        return Pago;
    }

    @Override
     public void RealizarPago() {
         System.out.println("Empleado: " + getNombre() + " con un sueldo de:  " + CalcularPago());
     
    }
}
