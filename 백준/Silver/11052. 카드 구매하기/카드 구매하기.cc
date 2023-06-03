#include<iostream>
using namespace std;

int card[1001];
int d[1001];
int ans;
int f(int n) {
	if (n == 1)
		return card[1];
	if (d[n] > 0)
		return d[n];
	int temp;
	int ans = card[n];
	for (int i = 1; i <= n/2; i++) {
		temp = f(n - i) + f(i);
		if (temp > ans) {
			ans = temp;
		}
	}
	return d[n]=ans;
}
int main() {
	int n;
	double a;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> card[i];
	}
	cout << f(n);
}