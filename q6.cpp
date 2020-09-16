// by Arad Firoozkuhi


#include <iostream>
#include <string>
using namespace std;
int main() {
    string str="";
    int k;
    cin>>k;
    int i=1;
    while(str.length()<k)
    {
        str+=to_string(i);
        i++;
    }
    cout<<str[k-1];
    return 0;
}