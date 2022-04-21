/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsetsum;

/**
 *
 * @author garroakion
 */
public class Main {
    public static Arreglos creadorArreglos = new Arreglos();
    public static FuerzaBruta metodoFuerzaBruta = new FuerzaBruta();
    public static programacionDinamica metodoDinamico = new programacionDinamica();
    
    public static void ejecutarMetodos(int n){
        int [] arreglo = creadorArreglos.arregloQuemado(n);
        int [] aleatorio = creadorArreglos.arregloAleatorio(n);
        
        System.out.println("Fuerza Bruta ---  Arreglo Quemado");
        metodoFuerzaBruta.aplicarFB(arreglo);
        System.out.println("Fuerza Bruta ---  Arreglo Aleatorio");
        metodoFuerzaBruta.aplicarFB(aleatorio);
        System.out.println("--------------------------------------------------------------------------"); 
        
        System.out.println("Programción Dinamica ---  Arreglo Quemado");
        System.out.println(metodoDinamico.aplicarMetodoDinamico(0, 0, arreglo, n)-1);
        System.out.println("Programción Dinamica ---  Arreglo Aleatorio");
        System.out.println(metodoDinamico.aplicarMetodoDinamico(0, 0, aleatorio, n)-1);
        System.out.println("--------------------------------------------------------------------------"); 
        
        
    
    }
    
    public static void main(String[] args) {
      
  
       int tamaño = 3;
       while (tamaño <= 7) {            
            ejecutarMetodos(tamaño);
            tamaño++;
        }
        tamaño += 2;
        while (tamaño <= 15) {            
            ejecutarMetodos(tamaño);
            tamaño++;
        }
        tamaño += 4;
        ejecutarMetodos(tamaño);
        tamaño += 10;
        ejecutarMetodos(tamaño);
        
  
  
    
        
        
        
        
        
        
    }
    
    
    
}