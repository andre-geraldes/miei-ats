import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author andregeraldes
 */
public class Parser {
    private ArrayList<String> instExec = new ArrayList<>();
    private ArrayList<String> blocosExec = new ArrayList<String>();
    private ArrayList<String> caminhosExec = new ArrayList<String>();
    private ArrayList<String> instNaoExec = new ArrayList<String>();
    private ArrayList<String> blocosNaoExec = new ArrayList<String>();
    private ArrayList<String> caminhosNaoExec = new ArrayList<String>();
    private HashMap<String,Integer> whilesExec = new HashMap<String,Integer>();
    private ArrayList<String> whilesNaoExec = new ArrayList<String>();
    private int totalI = 0;
    private int totalB = 0;
    private int totalC = 0;
    private int totalW = 0;

    public int getTotalI() {
        return totalI;
    }

    public void setTotalI(int lastI) {
        this.totalI = lastI;
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

    public ArrayList<String> getInstExec() {
        return instExec;
    }

    public void setInstExec(ArrayList<String> instExec) {
        this.instExec = instExec;
    }

    public ArrayList<String> getBlocosExec() {
        return blocosExec;
    }

    public void setBlocosExec(ArrayList<String> blocosExec) {
        this.blocosExec = blocosExec;
    }

    public ArrayList<String> getCaminhosExec() {
        return caminhosExec;
    }

    public void setCaminhosExec(ArrayList<String> caminhosExec) {
        this.caminhosExec = caminhosExec;
    }

    public ArrayList<String> getInstNaoExec() {
        return instNaoExec;
    }

    public void setInstNaoExec(ArrayList<String> instNaoExec) {
        this.instNaoExec = instNaoExec;
    }

    public ArrayList<String> getBlocosNaoExec() {
        return blocosNaoExec;
    }

    public void setBlocosNaoExec(ArrayList<String> blocosNaoExec) {
        this.blocosNaoExec = blocosNaoExec;
    }

    public ArrayList<String> getCaminhosNaoExec() {
        return caminhosNaoExec;
    }

    public void setCaminhosNaoExec(ArrayList<String> caminhosNaoExec) {
        this.caminhosNaoExec = caminhosNaoExec;
    }

    public HashMap<String, Integer> getWhilesExec() {
        return whilesExec;
    }

    public void setWhilesExec(HashMap<String, Integer> whilesExec) {
        this.whilesExec = whilesExec;
    }

    public ArrayList<String> getWhilesNaoExec() {
        return whilesNaoExec;
    }

    public void setWhilesNaoExec(ArrayList<String> whilesNaoExec) {
        this.whilesNaoExec = whilesNaoExec;
    }

    public int getTotalW() {
        return totalW;
    }

    public void setTotalW(int totalW) {
        this.totalW = totalW;
    }
    
    
    public void parseFile(Parser m) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("res.txt"))) {
            String line = br.readLine();
            int k = 0;
            String h;
            while (line != null) {
                //Total de instruções
                if(line.equals("t")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0) m.setTotalI(k);
                }
                
                //Total de blocosExec
                if(line.equals("p")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0)m.setTotalB(k);
                }
                
                //Total de if else
                if(line.equals("h")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0)m.setTotalC(k);
                }
                
                //Total de whiles e fors
                if(line.equals("f")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0) m.setTotalW(k);
                }
                
                //Instruções executadas
                if(line.equals("i")) {
                    h = br.readLine();
                    if(!m.getInstExec().contains("i"+h))
                        m.getInstExec().add("i"+h);
                }
                
                //Blocos executados
                if(line.equals("b")) {
                    h = br.readLine();
                    if(!m.getBlocosExec().contains("b"+h))
                        m.getBlocosExec().add("b"+h);
                }
                
                //Caminhos de if else executados
                if(line.equals("c")) {
                    h = br.readLine();
                    if(!m.getCaminhosExec().contains("c"+h))
                        m.getCaminhosExec().add("c"+h);
                }
                
                //Whiles e fors
                if(line.equals("w")){
                    h = br.readLine();
                    if(m.getWhilesExec().containsKey("w"+h))
                        m.getWhilesExec().put("w"+h, m.getWhilesExec().get("w"+h) + 1);
                    else m.getWhilesExec().put("w"+h, 1);
                }
                
                line = br.readLine();
            }
        }
        //Calculo das instruções nao executadas
        for(int i = 1; i <= m.getTotalI(); i++){
            if(!m.getInstExec().contains("i"+i))
                m.getInstNaoExec().add("i"+i);
        }
        //Calculo dos blocos nao executados
        for(int i = 1; i <= m.getTotalB(); i++){
            if(!m.getBlocosExec().contains("b"+i))
                m.getBlocosNaoExec().add("b"+i);
        }
        //Calculo dos caminhos nao executados
        for(int i = 1; i <= m.getTotalC(); i++){
            if(!m.getCaminhosExec().contains("c"+i))
                m.getCaminhosNaoExec().add("c"+i);
        }
        //Calculo dos whiles/for nao executados
        for(int i = 1; i <= m.getTotalW(); i++){
            if(!m.getWhilesExec().keySet().contains("w"+i))
                m.getWhilesNaoExec().add("w"+i);
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Parser m = new Parser();
        m.parseFile(m);
        
        System.out.println("----------------------------------------------");
        System.out.println("Foram executadas " + m.getInstExec().size() + " de " + m.getTotalI() + " instruções totais.");
        System.out.println("Foram executados " + m.getBlocosExec().size() + " de " + m.getTotalB() + " blocos totais.");
        System.out.println("Foram executados " + m.getCaminhosExec().size() + " de " + m.getTotalC() + " if/else totais.");
        System.out.println("Foram executados " + m.getWhilesExec().size() + " de " + m.getTotalW() + " while/for totais.");
        System.out.println("----------------------------------------------");
        System.out.println("Foram executadas " + Float.parseFloat(m.getInstExec().size()+"")/Float.parseFloat(m.getTotalI()+"") * 100 + "% das instruções.");
        System.out.println("Foram executados " + Float.parseFloat(m.getBlocosExec().size()+"")/Float.parseFloat(m.getTotalB()+"") * 100 + "% dos blocos.");
        System.out.println("Foram executados " + Float.parseFloat(m.getCaminhosExec().size()+"")/Float.parseFloat(m.getTotalC()+"") * 100 + "% dos if/else.");
        System.out.println("Foram executados " + Float.parseFloat(m.getWhilesExec().size()+"")/Float.parseFloat(m.getTotalW()+"") * 100 + "% dos while/for.");
        System.out.println("----------------------------------------------");
        System.out.println("Instruções executadas(" + m.getInstExec().size() + "):");
        for(String in : m.getInstExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("Instruções não executadas(" + m.getInstNaoExec().size() + "):");
        for(String in : m.getInstNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Blocos executados(" + m.getBlocosExec().size() + "):");
        for(String in : m.getBlocosExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("Blocos não executados(" + m.getBlocosNaoExec().size() + "):");
        for(String in : m.getBlocosNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("If/else executados(" + m.getCaminhosExec().size() + "):");
        for(String in : m.getCaminhosExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("If/else não executados(" + m.getCaminhosNaoExec().size() + "):");
        for(String in : m.getCaminhosNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("While/for executados(" + m.getWhilesExec().size() + "):");
        for(String in : m.getWhilesExec().keySet()){
            System.out.println(in + " executado " + m.getWhilesExec().get(in) + " vezes");
        }
        System.out.println("While/for não executados(" + m.getWhilesNaoExec().size() + "):");
        for(String in : m.getWhilesNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
    }
    
}
