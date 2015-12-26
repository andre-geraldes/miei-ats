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
    
    
    public void parseFile(String filename) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            int k = 0;
            String h;
            while (line != null) {
                //Total de instruções
                if(line.equals("t")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0) this.setTotalI(k);
                }
                
                //Total de blocosExec
                if(line.equals("p")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0) this.setTotalB(k);
                }
                
                //Total de if else
                if(line.equals("h")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0) this.setTotalC(k);
                }
                
                //Total de whiles e fors
                if(line.equals("f")) {
                    k = Integer.parseInt(br.readLine());
                    if(k > 0) this.setTotalW(k);
                }
                
                //Instruções executadas
                if(line.equals("i")) {
                    h = br.readLine();
                    if(!this.getInstExec().contains("i"+h))
                        this.getInstExec().add("i"+h);
                }
                
                //Blocos executados
                if(line.equals("b")) {
                    h = br.readLine();
                    if(!this.getBlocosExec().contains("b"+h))
                        this.getBlocosExec().add("b"+h);
                }
                
                //Caminhos de if else executados
                if(line.equals("c")) {
                    h = br.readLine();
                    if(!this.getCaminhosExec().contains("c"+h))
                        this.getCaminhosExec().add("c"+h);
                }
                
                //Whiles e fors
                if(line.equals("w")){
                    h = br.readLine();
                    if(this.getWhilesExec().containsKey("w"+h))
                        this.getWhilesExec().put("w"+h, this.getWhilesExec().get("w"+h) + 1);
                    else this.getWhilesExec().put("w"+h, 1);
                }
                
                line = br.readLine();
            }
        }
        //Calculo das instruções nao executadas
        for(int i = 1; i <= this.getTotalI(); i++){
            if(!this.getInstExec().contains("i"+i))
                this.getInstNaoExec().add("i"+i);
        }
        //Calculo dos blocos nao executados
        for(int i = 1; i <= this.getTotalB(); i++){
            if(!this.getBlocosExec().contains("b"+i))
                this.getBlocosNaoExec().add("b"+i);
        }
        //Calculo dos caminhos nao executados
        for(int i = 1; i <= this.getTotalC(); i++){
            if(!this.getCaminhosExec().contains("c"+i))
                this.getCaminhosNaoExec().add("c"+i);
        }
        //Calculo dos whiles/for nao executados
        for(int i = 1; i <= this.getTotalW(); i++){
            if(!this.getWhilesExec().keySet().contains("w"+i))
                this.getWhilesNaoExec().add("w"+i);
        }
    }
    
    public void printRes(){
        System.out.println("----------------------------------------------");
        System.out.println("Foram executadas " + this.getInstExec().size() + " de " + this.getTotalI() + " instruções totais.");
        System.out.println("Foram executados " + this.getBlocosExec().size() + " de " + this.getTotalB() + " blocos totais.");
        System.out.println("Foram executados " + this.getCaminhosExec().size() + " de " + this.getTotalC() + " if/else totais.");
        System.out.println("Foram executados " + this.getWhilesExec().size() + " de " + this.getTotalW() + " while/for totais.");
        System.out.println("----------------------------------------------");
        System.out.println("Foram executadas " + Float.parseFloat(this.getInstExec().size()+"")/Float.parseFloat(this.getTotalI()+"") * 100 + "% das instruções.");
        System.out.println("Foram executados " + Float.parseFloat(this.getBlocosExec().size()+"")/Float.parseFloat(this.getTotalB()+"") * 100 + "% dos blocos.");
        System.out.println("Foram executados " + Float.parseFloat(this.getCaminhosExec().size()+"")/Float.parseFloat(this.getTotalC()+"") * 100 + "% dos if/else.");
        System.out.println("Foram executados " + Float.parseFloat(this.getWhilesExec().size()+"")/Float.parseFloat(this.getTotalW()+"") * 100 + "% dos while/for.");
        System.out.println("----------------------------------------------");
        System.out.println("Instruções executadas(" + this.getInstExec().size() + "):");
        for(String in : this.getInstExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("Instruções não executadas(" + this.getInstNaoExec().size() + "):");
        for(String in : this.getInstNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("Blocos executados(" + this.getBlocosExec().size() + "):");
        for(String in : this.getBlocosExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("Blocos não executados(" + this.getBlocosNaoExec().size() + "):");
        for(String in : this.getBlocosNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("If/else executados(" + this.getCaminhosExec().size() + "):");
        for(String in : this.getCaminhosExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("If/else não executados(" + this.getCaminhosNaoExec().size() + "):");
        for(String in : this.getCaminhosNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
        System.out.println("While/for executados(" + this.getWhilesExec().size() + "):");
        for(String in : this.getWhilesExec().keySet()){
            System.out.println(in + " executado " + this.getWhilesExec().get(in) + " vezes");
        }
        System.out.println("While/for não executados(" + this.getWhilesNaoExec().size() + "):");
        for(String in : this.getWhilesNaoExec()){
            System.out.print(in + " ");
        }
        System.out.println("");
        System.out.println("----------------------------------------------");
    }
}
