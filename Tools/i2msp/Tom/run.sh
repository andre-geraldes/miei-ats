#/bin/bash
EXAMPLE_DIR=exemplos/
EXAMPLE_FILE=exemplo1.i
RES_FILE=res.msp

make clean
make
echo "----------------------------------------"
echo "Ficheiro a executar: "$EXAMPLE_FILE
echo "----------------------------------------"
cp $EXAMPLE_DIR$EXAMPLE_FILE genI
cd genI
javac gram/Main.java
java gram/Main < $EXAMPLE_FILE > $RES_FILE

more $RES_FILE

cp $RES_FILE ../genMaqV
cd ../genMaqV
javac maqv/Main.java
java maqv/Main $RES_FILE
