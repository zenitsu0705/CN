#include<stdio.h>
#define LARGE 10000
#define MAX 30

struct state{
    int len;
    int pre;
    int label;
};

struct state states[MAX];
int a[MAX][MAX];

int main(){
    int i,j,s,d,n,tem,min,mini;

    printf("enter no of vertices:");
    scanf("%d",&n);

    printf("\nEnter adjacency matrix\n");
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
        printf("a[%d][%d]=",i,j);
        scanf("%d",&a[i][j]);
        }
    }
    
    for(i=0;i<n;i++){
        states[i].len=LARGE;
        states[i].label=0;
        states[i].pre=-1;
    }

    printf("\nEnter source vertex:");
    scanf("%d",&s);

    printf("\nEnter destination vertex:");
    scanf("%d",&d);

    states[d].len=0;
    states[d].label=1;
    tem=d;

    while(tem!=s){
        for(i=0;i<n;i++){
            if(a[tem][i]!=0 && states[tem].len+a[tem][i]<states[i].len && states[i].label==0){
                states[i].len=states[tem].len+a[tem][i];
                states[i].pre=tem;
            }
        }
        min=LARGE;
        mini=0;
        for(i=0;i<n;i++){
            if(states[i].len<LARGE && states[i].label==0){
                min=states[i].len;
                mini=i;
            }
        }
        states[mini].label=1;
        tem=mini;
    }

    tem=s;
    printf("\nPath length:%d",states[s].len);
    printf("\nPath\n");
    printf("%d",tem);

    do{
        tem=states[tem].pre;
        printf("%d",tem);
    }while(tem!=d);

    return(0);
}
