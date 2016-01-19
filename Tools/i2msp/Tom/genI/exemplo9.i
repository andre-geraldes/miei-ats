void main() {
    int a;
    int b;
    int c;
    int res;
    a = 10;
    b = 5;
    c = 1;
    res = max(a,b,c);
    print(';');
    print(res);
}

int max(int a, int b, int c){
    int res;
    if (a > b) {
        res = a;
    }
    else {
        res = b;
    }
    return res;
}
