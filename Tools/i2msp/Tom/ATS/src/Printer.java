
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
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
public class Printer {
    private ArrayList<String> params;
    private int ni; //Contador de instruções
    private int nc; //Contador de ciclos
    private int nb; //Contador de blocos
    private int nif;//Contador de ifs/else

    public Printer(){
        this.params = new ArrayList<>();
        this.ni = 0;
        this.nc = 0;
        this.nb = 0;
        this.nif = 0;
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public int getNi() {
        return ni;
    }

    public void setNi(int ni) {
        this.ni = ni;
    }

    public int getNc() {
        return nc;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void readfile(String file) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            String[] array = line.split(",");
            for(String i : array){
                this.params.add(i);
            }
        }
    }

    public void addPrints(){
        boolean main = true;
        int tam = this.params.size();
        int i;

        /* //Alterado na 3 fase
        //Instruções que sao atribuiçoes
        for(i = 0; i < tam; i++){
            String h = this.params.get(i);
            if(h.contains("Store")){
                if(!this.params.get(i-3).contains("Call") && !this.params.get(i+1).contains("Call")){
                    this.ni++;
                    this.newPrint('i', this.ni, i);
                    i += 2;
                    tam += 2;
                }
            }
            if(h.contains("Call")){
                    this.ni++;
                    this.newPrint('i', this.ni, i);
                    i += 2;
                    tam += 2;
            }

        }*/

        //If/else/while/for
        for(i = 0; i < tam; i++){
            String h = this.params.get(i);
            if(h.contains("Jumpf \"senao")){
                this.nif++;
                this.newPrint('c', this.nif, i);
                i += 2;
                tam += 2;
            }
            else if (h.contains("Jump \"fse")){
                if(!this.params.get(i+2).contains("ALabel \"fse")){
                    this.nif++;
                    this.newPrint('c', this.nif, i+1);
                    i += 3;
                    tam += 2;
                }
            }
            else if (h.contains("Jumpf \"fenq")){
                this.nc++;
                this.newPrint('w', this.nc, i);
                i += 2;
                tam += 2;
            }
            else if (h.contains("Jumpf \"ffor")){
                this.nc++;
                this.newPrint('w', this.nc, i);
                i += 2;
                tam += 2;
            }
        }

        //Blocos
        for(i = 0; i < tam; i++){
            String h = this.params.get(i);
            if(h.equals("Halt") || h.equals("Ret")){
                this.nb++;
                this.newPrint('b', this.nb, i-1);
                i += 2;
                tam += 2;
            }
            //Bloco anterior a um ciclo for
            if(h.contains("Jumpf \"ffor")){
                this.nb++;
                this.newPrint('b', this.nb, i-1);
                i += 2;
                tam += 2;
            }
            //Bloco interior de um for
            if(h.contains("Jump \"for")){
                this.nb++;
                this.newPrint('b', this.nb, i-1);
                i += 2;
                tam += 2;
            }
            //Bloco anterior a um if
            if(h.contains("Jumpf \"senao")){
                this.nb++;
                this.newPrint('b', this.nb, i-1);
                i += 2;
                tam += 2;
            }
            //Bloco de um if
            if (h.contains("Jump \"fse")){
                //Bloco interior de um else
                if(!this.params.get(i+4).contains("ALabel \"enq") && !this.params.get(i+2).contains("ALabel \"fse") &&
                        !this.params.get(i+4).contains("ALabel \"for")){
                    //Bloco interior de um if
                    this.nb++;
                    this.newPrint('b', this.nb, i-1);
                    i += 2;
                    tam += 2;

                    this.nb++;
                    this.newPrint('b', this.nb, i+1);
                    i += 3;
                    tam += 2;
                }
            }
            //Bloco anterior a um while
            if(h.contains("Jumpf \"fenq")){
                this.nb++;
                this.newPrint('b', this.nb, i-1);
                i += 2;
                tam += 2;
            }//Bloco interior de um while
            if(h.contains("Jump \"enq")){
                this.nb++;
                this.newPrint('b', this.nb, i-1);
                i += 2;
                tam += 2;
            }
        }

        //Apos colocar todos os prints, inserir os valores totais no fim da main
        for(i = 0; i < tam && main; i++){
            String h = this.params.get(i);
            if(h.equals("Halt") && main){
                main = false;
                this.params.add(i, "Pushi "+ this.ni +",IOut");
                this.params.add(i, "Pushc 't',IOut");

                this.params.add(i, "Pushi "+ this.nb +",IOut");
                this.params.add(i, "Pushc 'p',IOut");

                this.params.add(i, "Pushi "+ this.nif +",IOut");
                this.params.add(i, "Pushc 'h',IOut");

                this.params.add(i, "Pushi "+ this.nc +",IOut");
                this.params.add(i, "Pushc 'f',IOut");
            }
        }

        /*
        //Imprime o msp
        for(String k : this.params){
            System.out.println(k);
        }*/
    }

    //Funçao que cria um novo print com o char a, o int i no index recebido
    public void newPrint(char a, int i, int index){
        this.params.add(index+1, "Pushc '" + a + "',IOut");
        this.params.add(index+2, "Pushi "+ i +",IOut");
    }

    //Funcao que guarda o novo res.msp com os prints
    public void writeFile(String filename) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        String res = "";
        for(int i = 0; i < this.params.size(); i++) {
            if(i == this.params.size() - 1)
                res = res + this.params.get(i);
            else
                res = res + this.params.get(i) + ",";
        }
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            writer.write(res);
        }
    }

    //Função que adiciona os prints das instruções a um c--
    public void printInst(String filename) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            ArrayList<String> codigo = new ArrayList<String>();

            //Leitura do ficheiro c--
            while (line != null) {
                codigo.add(line);
                line = br.readLine();
            }
            //Colocar prints das instrucoes
            for(int j = 0; j < codigo.size(); j++){
                String linha = codigo.get(j);
                if(linha.contains("return") || linha.contains("=") &&
                        !linha.contains("if") &&
                        !linha.contains("while") && !linha.contains("for(")) {
                    this.ni++;
                    codigo.set(j, linha + "print(\'i\'); print("+this.ni+");");
                }
            }
            //Imprimir o novo codigo
            for(String linha : codigo){
                System.out.println(linha);
            }
        }
    }
}
