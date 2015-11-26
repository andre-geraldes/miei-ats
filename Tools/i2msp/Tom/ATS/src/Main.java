import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author andregeraldes
 */
public class Main {
    public ArrayList<String> inst = new ArrayList<String>();

    public ArrayList<String> getInst() {
        return inst;
    }

    public void setInst(ArrayList<String> inst) {
        this.inst = inst;
    }
    
    public void addInstr(Main m) throws FileNotFoundException, IOException{
        boolean ianterior = false;
        
        try (BufferedReader br = new BufferedReader(new FileReader("res.txt"))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                 
                if(ianterior){
                    m.getInst().add("i"+line);
                    ianterior = false;
                }
                if(line.equals("i")){
                    ianterior = true;
                }
                line = br.readLine();
            }
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Main m = new Main();
        m.addInstr(m);
        
        for(String i : m.getInst()){
            System.out.println(i);
        }
    }
    
}
