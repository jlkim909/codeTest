#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		string num = to_string(i);
		int cnt = 0;
		cnt += count(num.begin(), num.end(), '3');
		cnt += count(num.begin(), num.end(), '6');
		cnt += count(num.begin(), num.end(), '9');

		if (cnt == 0) {
			cout << num << ' ';
		}
		else {
			for (int k = 0; k < cnt; k++) {
				cout << '-';
			}
			cout << ' ';
		}
	}
}