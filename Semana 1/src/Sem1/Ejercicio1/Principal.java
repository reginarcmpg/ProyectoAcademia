
package Sem1.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Regina
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
    Scanner scanner = new Scanner(System.in);//Esta nos ayuda a ingresar datos

      
        System.out.print("Ingrese el nombre del empleado tiempo completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese la identificación: ");
        int idCompleto = scanner.nextInt();
        System.out.print("Ingrese el salario base completo: ");
        int salarioBaseCompleto = scanner.nextInt();
        scanner.nextLine(); 
        
        Trabajador trabajadores1 = new EmpleadoTiempoCompleto(nombreCompleto, idCompleto, salarioBaseCompleto) ; //aqui estanos creando el objeto de la clase de empleado tiempo completo
        
        System.out.println(); 
        
        System.out.print("Ingrese el nombre del empleado tiempo parcial: ");
        String nombreParcial = scanner.nextLine();
        System.out.print("Ingrese la identificación: ");
        int idParcial = scanner.nextInt();
        System.out.print("Ingrese el salario base por hora: ");
        int salarioBaseParcial = scanner.nextInt();
        System.out.print("Ingrese las horas trabajadas: ");
        int horasTrabajadas = scanner.nextInt();
        scanner.nextLine(); 
        
      
       
       Trabajador trabajadores2 = new EmpleadoTiempoParcial(nombreParcial, idParcial, salarioBaseParcial, horasTrabajadas); //aqui estanos creando el objeto de la clase de empleado tiempo parcial
       
       System.out.println(); 
       
          System.out.print("Ingrese el nombre del contratista: ");
        String nombreContratista = scanner.nextLine();
        System.out.print("Ingrese la identificación: ");
        int idContratista = scanner.nextInt();
        System.out.print("Ingrese la tarifa por hora: ");
        int tarifaPorHora = scanner.nextInt();
        System.out.print("Ingrese las horas trabajadas: ");
        int horasTrabajadasContratista = scanner.nextInt();
        scanner.nextLine(); 
        
        Trabajador trabajadores3 = new Contratista(nombreContratista, idContratista, tarifaPorHora, horasTrabajadas, horasTrabajadasContratista); //aqui estanos creando el objeto de la clase del contratista
        
        System.out.println(); 
        
        List<Trabajador> trabajadores = new ArrayList<>(); //creamos una lista de array porque queremos que su longitud pueda cambiar
        
        trabajadores.add(trabajadores1); //aqui estamos agregando los objetos de la clase trabajdor al array
        trabajadores.add(trabajadores2);
        trabajadores.add(trabajadores3);
        
        for (Trabajador tr : trabajadores){ //aqui usamos uso del for each para que esta se este repitiendo dependiendo de la longityd del array
        tr.RealizarPago(); //usamdo el polimorfismos porque el tr nos permite hacer diferentes tareas
        System.out.println(); 
        }
        
       
   
    
}
}
