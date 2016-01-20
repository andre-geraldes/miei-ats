#/bin/bash
EXAMPLE_DIR=exemplos/
EXAMPLE_FILE=$1 #Argumento 1
RESULT=printedexample.i
RES_FILE=res.msp
L_FILE=res.txt

#make clean
#make
echo "----------------------------------------------"
echo ">> Ficheiro a executar: "$EXAMPLE_FILE
echo "----------------------------------------------"

#Criar um ficheiro com os prints nas instruções
javac ATS/src/Main.java ATS/src/Printer.java ATS/src/Parser.java
java -cp ATS/src/ Main $EXAMPLE_DIR$EXAMPLE_FILE > $RESULT
cp $RESULT genI

#Compilar para gerar msp
echo "A gerar o msp..."
cd genI
javac gram/Main.java
java gram/Main < $RESULT > ../$RES_FILE

#Adicionar os prints que faltam ao msp
echo "A adicionar os prints..."
cd ..
#more $RES_FILE
java -cp ATS/src/ Main $RES_FILE
#more $RES_FILE

#Correr o msp
echo "A correr o msp..."
cp $RES_FILE genMaqV
cd genMaqV
javac maqv/Main.java
java maqv/Main $RES_FILE > $L_FILE
cp $L_FILE ..
#more $L_FILE

#Gerar os resultados
echo "A gerar os resultados..."
cd ..
javac ATS/src/Main.java ATS/src/Parser.java ATS/src/Printer.java
echo "Resultados:"
java -cp ATS/src/ Main $L_FILE $EXAMPLE_DIR$EXAMPLE_FILE
echo "----------------------------------------------"
