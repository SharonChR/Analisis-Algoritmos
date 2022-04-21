/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsetsum;

/**
 *
 * @author garroakion
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class FuerzaBruta {

    /*
    * 1.	Creación de conjuntos de números enteros (negativos y positivos)
    *       que tengan al menos un subconjunto que sume cero para diferentes
    *       tamaños de elementos del conjunto.
    * */
    
    int comparaciones=0;
    int asignaciones=0;
    long startTime = 0;
    long endTime = 0;
    double totalTime = 0;
    
    private int subconjuntos = 0;
  
    public FuerzaBruta(){}

    public void aplicarFB(int arreglo[]) {
        subconjuntos = 0;
        this.startTime = System.nanoTime();
        findSets(arreglo);
        this.endTime = System.nanoTime();
        totalTime = endTime - startTime;
        
        showData(arreglo.length);
        
        
        /*this.startTime = System.nanoTime();
        findSets(this.arr2);
        this.endTime = System.nanoTime();
        totalTime = endTime - startTime;
        showData();*/

    }

    public void findSets(int arr[]){
        
        this.asignaciones =0;
        this.comparaciones=0;
        System.out.println("Given Array: " + Arrays.toString(arr) + ", required sum: " + 0 + '\n');
        Arrays.sort(arr); 
        List<Integer> combinationList = new ArrayList<>();
        combinationUtil(arr, 0, 0, combinationList);

        this.asignaciones +=2;
    }



    public void combinationUtil(int arrA[], int currSum, int start, List<Integer> combinationList) {
        this.asignaciones += 4;
        this.comparaciones++;
        if (currSum == 0 && combinationList.size() > 0) {
            System.out.println(combinationList);
            subconjuntos++;
            this.comparaciones +=2;
            this.asignaciones++;
            return;
        }
        
        this.asignaciones++;
        for (int i = start; i < arrA.length; i++) {
            this.asignaciones ++;
            this.comparaciones+=2;
            if (currSum + arrA[i] > 0){
                //array is sorted, no need to check further
                break;
            }

            combinationList.add(arrA[i]);
            this.asignaciones++;
            combinationUtil(arrA, currSum + arrA[i], i + 1, combinationList);
            combinationList.remove(combinationList.size() - 1);
            this.asignaciones++;

        }
        this.comparaciones ++;
        
    }

    

    public void showData(int n){
        System.out.println("");
        System.out.println("Tamaño :"  +  n);
        System.out.println("Resultados :"  +  subconjuntos);
        System.out.println("");
        System.out.println("Asignaciones : "+ this.asignaciones);
        System.out.println("");
        System.out.println("Comparaciones : "+ this.comparaciones);
        System.out.println("");
        DecimalFormat df = new DecimalFormat("#.000");
        totalTime = totalTime / 1000000;
        System.out.println("Tiempo : " + df.format(this.totalTime));
        //System.out.println("Tiempo : "+ this.totalTime);
        
        System.out.println("");
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------");
          
        System.out.println("");
        System.out.println("");
    }


}