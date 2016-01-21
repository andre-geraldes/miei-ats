void main() {
    int a;
    int b;
    int c;
    int res;
    a = 10;print('i'); print(1);
    b = 5;print('i'); print(2);
    c = 1;print('i'); print(3);
    res = max(a,b,c);print('i'); print(4);
    print(';');
    print(res);
}

int max(int a, int b, int c){
    int res;
    if (a > b) {
        res = a;print('i'); print(5);
    }
    else {
        res = b;print('i'); print(6);
    }
    return res;print('i'); print(7);
}
