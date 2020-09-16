/*
 * by:
 *      Amir Hossein Sana
 *      Mohammad Mahdi Malmasi
 */




#include <stdio.h>
#include <stdlib.h>


#define int long long


int main()
{
    int numberOfVs;
    scanf("%lld", &numberOfVs);

    int vs[100002] = {0};
    int holdToRead;
    for (int i = 0; i < numberOfVs; i++)
    {
        scanf("%lld", &holdToRead);
        vs[holdToRead]++;
    }

    
    int output = 0;
    for (int i = 1; i <= 100000; i ++)
    {
        output += vs[i] * (vs[i-1] + vs[i+1]);
    }


    printf("%lld\n", output/2);

    return 0;
}