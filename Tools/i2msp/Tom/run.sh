#/bin/bash
EXAMPLE_DIR=exemplos/
EXAMPLE_FILE=exemplo1b.i
RES_FILE=res.msp
L_FILE=res.txt

#make clean
#make
echo "---------------------------------------"
echo ">> Ficheiro a executar: "$EXAMPLE_FILE
echo "---------------------------------------"
cp $EXAMPLE_DIR$EXAMPLE_FILE genI
cd genI
javac gram/Main.java
java gram/Main < $EXAMPLE_FILE > ../$RES_FILE

cd ..
more $RES_FILE
javac ATS/src/Main2.java ATS/src/Printer.java
java -cp ATS/src/ Main2
more $RES_FILE

cp $RES_FILE genMaqV
cd genMaqV
javac maqv/Main.java
java maqv/Main $RES_FILE > $L_FILE
cp $L_FILE ..
#more $L_FILE

cd ..
javac ATS/src/Main.java ATS/src/Parser.java
java -cp ATS/src/ Main 

