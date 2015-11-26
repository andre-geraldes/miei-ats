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
    private ArrayList<String> inst = new ArrayList<String>();
    private ArrayList<String> blocos = new ArrayList<String>();
    private ArrayList<String> caminhos = new ArrayList<String>();
    private int totalI = 0;
    private int totalB = 0;
    private int totalC = 0;

    public ArrayList<String> getInst() {
        return inst;
    }

    public void setInst(ArrayList<String> inst) {
        this.inst = inst;
    }

    public int getTotalI() {
        return totalI;
    }

    public void setTotalI(int lastI) {
        this.totalI = lastI;
    }

    public ArrayList<String> getBlocos() {
        return blocos;
    }

    public void setBlocos(ArrayList<String> blocos) {
        this.blocos = blocos;
    }

    public ArrayList<String> getCaminhos() {
        return caminhos;
    }

    public void setCaminhos(ArrayList<String> caminhos) {
        this.caminhos = caminhos;
    }

    public int getTotalB() {
        return totalB;
    }

    public void setTotalB(int totalB) {
        this.totalB = totalB;
    }

    public int getTotalC() {
        return totalC;
    }

    public void setTotalC(int totalC) {
        this.totalC = totalC;
    }
    
    
    
    
    
    public void parseFile(Main m) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("res.txt"))) {
            String line = br.readLine();

            while (line != null) {
                //Total de instruções
                if(line.equals("t")) {
                    m.setTotalI(Integer.parseInt(br.readLine()));
                }
                
                //Total de blocos
                if(line.equals("p")) {
                    m.setTotalB(Integer.parseInt(br.readLine()));
                }
                
                //Total de if else
                if(line.equals("h")) {
                    m.setTotalC(Integer.parseInt(br.readLine()));
                }
                
                //Instruções executadas
                if(line.equals("i")) {
                    m.getInst().add("i"+br.readLine());
                }
                
                //Blocos executados
                if(line.equals("b")) {
                    m.getBlocos().add("b"+br.readLine());
                }
                
                //Caminhos de if else executados
                if(line.equals("c")) {
                    m.getCaminhos().add("c"+br.readLine());
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
        m.parseFile(m);
        
        System.out.println("----------------------------------------------");
        System.out.println("Foram executadas " + m.getInst().size() + " de " + m.getTotalI() + " instruções totais.");
        System.out.println("Foram executados " + m.getBlocos().size() + " de " + m.getTotalB() + " blocos totais.");
        System.out.println("Foram executados " + m.getCaminhos().size() + " de " + m.getTotalC() + " if else totais.");
        System.out.println("----------------------------------------------");
        System.out.println("Foram executadas " + Float.parseFloat(m.getInst().size()+"")/Float.parseFloat(m.getTotalI()+"") * 100 + "% instruções.");
        System.out.println("Foram executados " + Float.parseFloat(m.getBlocos().size()+"")/Float.parseFloat(m.getTotalB()+"") * 100 + "% blocos.");
        System.out.println("Foram executados " + Float.parseFloat(m.getCaminhos().size()+"")/Float.parseFloat(m.getTotalC()+"") * 100 + "% if else.");
        System.out.println("----------------------------------------------");
    }
    
}
