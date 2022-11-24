#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<math.h>

int n,r;
struct frame{
    char ack;
    int data;
}frm[10];

int sender(void);
void recvack(void);
void resend_gb(void);
int main(){
    int c;
    sender();
    recvack();
    resend_gb();
    printf("\n ALL FRAMES ARE SENT SUCCESSFULLY");
}

int sender(){
    int i;
    printf("\nEnter no of frames to be sent:");
    scanf("%d",&n);
    for(i=1;i<=n;i++){
        printf("\n Enter data for frames[%d]",i);
        scanf("%d",&frm[i].data);
        frm[i].ack='y';
    }
    return 0;
}

void recvack(){
    int i;
    rand();
    r=rand()%n;
    frm[r].ack='n';
    for(i=1;i<=n;i++){
        if(frm[i].ack=='n')
        printf("\n The Frame Number %d is not recieved",r);
    }
}

void resend_gb(){
    int i;
    printf("\n Resending Frame %d",r);
    for(i=r;i<=n;i++){
        sleep(2);
        frm[i].ack='y';
        printf("\n The recieved frame is %d",frm[i].data);
    }
}