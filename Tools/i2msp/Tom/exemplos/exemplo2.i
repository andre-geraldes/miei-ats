void main() {
    int i;
    i = 0; print('i');print(1);
    int a = 1; print('i');print(2);
    int b = 4; print('i');print(3);
    int c = 2; print('i');print(4);

    print('b');print(1);
    if(a > b){ print('c');print(1);
        b = 5; print('i');print(5);
        print('b');print(2);
    }
    else { print('c');print(2);
        b = 3; print('i');print(6);
        print('b');print(3);
    }

    c = a + b; print('i');print(7);
    print('b');print(4);
    /*  t -> total de instruçoes */
    /*  p -> total de blocos */
    /*  h -> total de if elses */
    print('t');print(7);
    print('p');print(4);
    print('h');print(2);
}
