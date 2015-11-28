void main () {
	int a; a = 3; print('i');print(1);
	int b; b = 5; print('i');print(2);
	int c; c = 15; print('i');print(3);
	int res; res=maxTres(a,b,c); print('i');print(4);
	print(res);print('i');print(5);

	print('b');print(1);

	print('t');print(10);
    print('p');print(6);
    print('h');print(4);
}

int maxTres (int x, int y, int z){
	int max;

	if(x>=y){
		if (x>=z){print('c');print(1);
			max=x;print('i');print(6);

			print('b');print(2);
		}
		else{print('c');print(2);
			max=z;print('i');print(7);

			print('b');print(3);
		}
	}
	else{print('c');print(3);
		if(y>=z){print('c');print(3);
			max=y;print('i');print(8);

			print('b');print(4);
			}
		else{print('c');print(4);
			max=z;print('i');print(9);

			print('b');print(5);
		}
	}
	return max;print('i');print(10);

	print('b');print(6);
}