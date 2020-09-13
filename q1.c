#include <stdio.h>
#include <stdlib.h>
#include <math.h>


#define ll long long


long findLen(int num, int base)
{
    long len = 0;

    while (powl(base, len) <= num)
        len++;
    
    return len;
}


void print(ll input)
{
    if (input < 10)
    {
        printf("%lld", input);
        return;
    }
    
    input = input%10;
    printf("%c", (char)(65+input));
}


int main()
{
    ll num, base;
    scanf("%lld %lld", &num, &base);


    ll len = findLen(num, base);
    ll output[len];
    

    long currIndex = 0;
    while (num >= base)
    {
        output[currIndex] = num%base;
        num = num/base;
        currIndex++;
    }
    output[currIndex] = num;


    for (int i = len-1; i >= 0; i--)
        print(output[i]);


    printf("\n");
    return 0;
}
