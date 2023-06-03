#include <iostream>
using namespace std;

int main()
{
    int start, product, cost, profit;
    int k=0;
    cin >> start >> product >> cost;
    profit=cost-product;
    if(profit>0){
        k=start/profit;
        cout << k+1;
    }
    else
        cout << -1;
        
	return 0;
}