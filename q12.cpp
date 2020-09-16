// by Arad Firoozkuhi






#include <iostream>
#include <string>
using namespace std;
void printSubsets(int n, int array[], int index){
        if(index==n)
        {
            cout<<"{ ";
            for(int i=0;i<n;i++)
                if(array[i])
                    cout<<i+1<<" ";
                cout<<"}\n";
        }
        else
        for(int i=1;i>=0;i--)
        {
            array[index]=i;
            printSubsets(n,array,index+1);
        }
}
int main() {
    int n;
    cin>>n;
    int arr[n];
    printSubsets(n,arr,0);
    return 0;
}