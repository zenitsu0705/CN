#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<unistd.h>
int main(){
	int i,j,packet[30];
	int fsize=(rand()%32)+1;
	printf("\n\tFrame Size:%d\n",fsize);
	printf("\n\t----Data Log ---\n");
	printf("\nFRAME\t\tDATA\tWAITING\t\tACKNOW\tRESEND");
	for(i=0;i<fsize;i++){
		packet[i]=rand()%10000;
		printf("\n%d\t\t%d",i+1,packet[i]);
		while(j=0||rand()%2==0){
			sleep(1);
			printf("\t1");
			sleep(1);
			for(j=2;rand()%2==0&&j<4;j++){
				printf("%d",j);
				sleep(1);
			}
			if(j==4)
			printf("\t\tNO\tRESENDING....\n%d\t\t%d",i+1,packet[i]);
			else
			break;
		}
		if(j==0){
			sleep(1);
			printf("\t0");
		}
		printf("\t\tYES\tNO");
    }
    printf("\n\n------ALL DATA PACKETS SEND------\n");
    return 0;
}