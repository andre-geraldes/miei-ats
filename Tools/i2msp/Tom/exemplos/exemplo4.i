void main (){
    int l1=5;
    int l2=6;
    int res; res = perimetro(2,l1,l2);
    /* fig 1-> quadrado
		fig 2-> retangulo*/
    print(res);
}

int perimetro(int f, int a, int b){
    int p=0;
    if(f==1){
        p=4*a;
    }
    if(f==2){
        p=2*a + 2*b;
    }

    return p;
}
