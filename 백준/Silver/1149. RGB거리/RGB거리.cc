#include<iostream>
using namespace std;

int rgb[1001][4];
int d[1001][4];
int f(int n, int k) {
	int min = 1000001;
	if (n == 1)
		return d[n][k] = rgb[n][k];
	if (d[n][k] > 0)
		return d[n][k];
	for (int i = 1; i <= 3; i++) {
		if (k == i) {
			continue;
		}
		int temp = f(n - 1, i);
		if (min > temp)
			min = temp;
	}
	return d[n][k] = min + rgb[n][k];
}
int main() {
	int n;
	int min = 10000001;
	cin >> n;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= 3; j++)
			cin >> rgb[i][j];
	for (int i = 1; i <= 3; i++) {
		int temp = f(n, i);
		if (temp < min)
			min = temp;
	}
	cout << min;
	return 0;
}