int x = 2, y = 4, z = 5, tmp;

void main() {
	max2bis(x,y,&tmp);
	max2bis(tmp,z,&tmp);
	printf("%d", tmp);
	exit();
}


void max2bis(int a, int b, int* res){
	if (a < b)
		*res = b;
	else
		*res = a;
	return;
}
