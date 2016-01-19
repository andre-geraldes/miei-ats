
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andregeraldes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException { 
        Parser m = new Parser();
        Printer p = new Printer();
        //Resultados
        if(args[0].equals("res.txt")){
            m.parseFile(args[0]);
            m.printRes();
            
            //Indicar linhas nao executadas
            m.insertNotExec(args[1]);
        }
        //Prints
        else if(args[0].equals("res.msp")){
            p.readfile(args[0]);
            String line;
            //Ler o numero de instruções, para escrever no fim da main
            try (BufferedReader br = new BufferedReader(new FileReader("inst.txt"))) {
                line = br.readLine();
            }
            p.setNi(Integer.parseInt(line));
            p.addPrints();
            p.writeFile(args[0]);
        }
        else if(args[0].contains(".i")){
            p.printInst(args[0]);
            //Escrever num ficheiro o total de instruções
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("inst.txt"), "utf-8"))) {
                String res = "" + p.getNi();
                writer.write(res);
                writer.close();
            }
        }
        else System.out.println("ERRO");
    }
}
