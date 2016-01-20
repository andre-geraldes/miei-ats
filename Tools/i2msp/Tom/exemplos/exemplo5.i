void main(){
    int i = 0;
    int n = 20;
    int a = 2;
    int b = 5;
    int res = 0;

    if(a > b){
        while(i < n){
            res = res + 1;
            i = i + 1;
        }
    }
    else {
        while(i < n){
            res = res + 2;
            i = i + 1;
        }
    }
    print(res);
}
