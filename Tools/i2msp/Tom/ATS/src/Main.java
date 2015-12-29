
import java.io.FileNotFoundException;
import java.io.IOException;

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
        if(args[0].equals("res.txt")){
            Parser m = new Parser();
            m.parseFile(args[0]);
            m.printRes();
        }
        else if(args[0].equals("res.msp")){
            Printer p = new Printer();
            p.readfile("res.msp");
            p.addPrints();
            p.writeFile("res.msp");
        }
        else System.out.println("ERRO: Ficheiro desconhecido!");
    }
}
