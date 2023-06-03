#include<stdio.h>

int main(void)
{
    int a,b,c,n;
    
    scanf("%d %d",&a,&b);
    scanf("%d",&c);
    
    n=a*60+b+c;
    
    printf("%d %d",(n/60)%24,n%60);
    
    return 0;
}