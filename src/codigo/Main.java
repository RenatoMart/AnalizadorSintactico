/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws Exception {
        generar();
    }

    public static void checkParser() {
        FrmPrincipal ventana = new FrmPrincipal();
        ventana.setVisible(true);
    }
    public static void generar() throws IOException, Exception {
        String path0="/home/renatomr/Descargas/AnalizadorSintactico/";
        String path= path0+"src/codigo/";
        String rutaC = path + "entradaCup.jflex"; // Scanner --- Lexico
        String fileG= "Syntactic.java"; //Parser --- Sintactico
        String [] rutaS = {"-parser", "Syntactic", path+"Grammar.cup"};
        File archivo = new File(rutaC);
        JFlex.Main.generate(archivo);
        System.out.println("Fin Lexico");
        java_cup.Main.main(rutaS);
        System.out.println("ruta---");
        Path rutaSym = Paths.get(path + "sym.java");
        if(Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(path0+"sym.java"),
                Paths.get(path+"sym.java")
        );
        Path rutaSin = Paths.get(path+fileG);
        if(Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(path0+fileG),
                Paths.get(path+fileG)
        );
    }

}
