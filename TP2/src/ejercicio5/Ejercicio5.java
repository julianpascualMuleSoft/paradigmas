package ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import static helpers.Helpers.esPrimo;
import static helpers.Helpers.escribirArchivo;

/**
 * Created by julianpascual on 9/3/16.
 */
public class Ejercicio5 {

    public void generarArchivoResultados(int[] numeros) {

        ArrayList<Integer> arrayPares = new ArrayList<Integer>();
        ArrayList<Integer> arrayImpares = new ArrayList<Integer>();
        ArrayList<Integer> arrayPrimos = new ArrayList<Integer>();
        ArrayList<Integer> arrayDiv3000 = new ArrayList<Integer>();
        int promedioPares, promedioImpares;

        for (int i = 0; i < numeros.length; i++) {

            if (esPrimo(numeros[i])) {
                arrayPrimos.add(numeros[i]);
            }
            if (esDivisor3000(numeros[i])) {
                arrayDiv3000.add(numeros[i]);
            }
            if (numeros[i] % 2 == 0) {
                arrayPares.add(numeros[i]);
            } else {
                arrayImpares.add(numeros[i]);
            }
        }

        promedioImpares = promedioNumeros(arrayImpares);
        promedioPares = promedioNumeros(arrayPares);

        escribirArchivo("resources/", "primos.txt", convertirArray(arrayPrimos));
        escribirArchivo("resources/", "divisoresDe3000.txt", convertirArray(arrayDiv3000));
        escribirArchivo("resources/", "promedios.txt", "Promedio de pares: " + promedioPares + "\nPromedio de impares: " + promedioImpares);
    }

    public int promedioNumeros(ArrayList<Integer> numeros) {

        int prom;
        int sumNumeros = 0;

        for (int i = 0; i < numeros.size(); i++) {
            sumNumeros = sumNumeros + numeros.get(i);
        }
        prom = sumNumeros / numeros.size();
        return prom;
    }

    public boolean esDivisor3000(int num){
        if (3000 % num == 0) {
            return true;
        } else {
            return false;
        }
    }


    public String convertirArray(ArrayList<Integer> numeros) {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < numeros.size(); i++) {
            texto.append(numeros.get(i) + "\n");
        }
        return texto.toString();
    }
}
