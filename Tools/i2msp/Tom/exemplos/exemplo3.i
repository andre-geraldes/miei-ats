void main () {
    int a;
    a = 3;
    int b;
    b = 5;
    int c;
    c = 15;
    int res;
    res=maxTres(a,b,c);
    print(res);
}

int maxTres (int x, int y, int z){
    int max;
    if(x>=y){
        if (x>=z){
            max=x;
        }
        else{
            max=z;
        }
    }
    else{
        if(y>=z){
            max=y;
        }
        else{
            max=z;
        }
    }
    return max;
}
