#include <iostream>
using namespace std;

int main()
{
    int hour, min;
    cin >> hour >> min;
    min+=15;
    hour+=min/60;
    hour--;
    if(hour<0)
    	hour=23;
    min%=60;
    cout << hour << " " << min;
	return 0; 
}