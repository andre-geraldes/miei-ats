/*Calcula as potencia de dois até um limite passado como input */

void main(){
	int lim= input(int);
	int j=1;
	int pot=0;

	while(j<=lim){
		pot=multI(j);
		print(pot);
		j=j+1;
	}
	return pot;
}

int multI(int n){
	int res=1;
	int i=0;

	if(n!=0){
		while(i<n){
			res=res*2;
			i=i+1;
			}
	}
	return res;
}
