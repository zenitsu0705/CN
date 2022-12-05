#include<stdio.h>
int main(){
	int a[10],b[10],c1,c2,c3,i;
	printf("Enter 4 bits\n");
	scanf("%d",&a[3]);
	scanf("%d",&a[5]);
	scanf("%d",&a[6]);
	scanf("%d",&a[7]);
	a[1]=a[3]^a[5]^a[7];
	a[2]=a[3]^a[6]^a[7];
	a[4]=a[5]^a[6]^a[7];
	for(i=1;i<8;i++){
		printf("%d",a[i]);
	}
	printf("Enter 7 bits");
	for(i=1;i<8;i++){
		scanf("%d",&b[i]);
	}	
	c1=b[1]^b[3]^b[5]^b[7];
	c2=b[2]^b[3]^b[6]^b[7];
	c3=b[4]^b[5]^b[6]^b[7];
	int p=c1*1+c2*2+c3*4;
	if(p==0){
		printf("No error");
	}
	else{
		printf("Error at: %d\n",p);
		if(b[p]==0)
			b[p]=1;
		else
			b[p]=0;

	}
	for(i=1;i<8;i++)
		printf("%d",b[i]);
}
