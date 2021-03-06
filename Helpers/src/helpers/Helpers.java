package helpers;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * Created by julianpascual on 9/4/16.
 */
public final class Helpers {
    private static String connectionString = "jdbc:h2:~/paradigmas/DB_TP_4/DB_H2";

    public static boolean esPrimo(int num) {
        int cantDivisores = 0;
        for (int i = 1; i <= num ; i++) {
            if (num % i == 0) {
                cantDivisores ++;
            }
        }
        if (cantDivisores == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static Connection getConnection(){
        Connection dbConnection = null;
        try {
            Class.forName("org.h2.Driver");
            dbConnection = DriverManager.getConnection(connectionString,"julian","");
            return dbConnection;
        } catch (Exception ex) {
            return dbConnection;
        }
    }

    public static ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(classloader.getResource(nombreArchivo).getPath()));
            String line = bufferedReader.readLine();
            while (line != null) {
                lineas.add(line);
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public static void escribirArchivo(String path, String fileName, String texto) {
        try {
            File statText = new File(path + fileName);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(texto);
            w.close();
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo.");
        }
    }
}
