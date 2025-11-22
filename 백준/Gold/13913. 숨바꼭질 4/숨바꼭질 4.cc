#include<iostream>
#include<queue>

using namespace std;

const int MAX = 200000;
bool visited[MAX + 1];
int d[MAX + 1];
int from[MAX + 1];

void print(int n, int m) {
	if (n != m) {
		print(n, from[m]);
	}

	cout << m << ' ';
}
int main() {
	int n, k;
	cin >> n >> k;
	
	visited[n] = true;
	queue<int> q;
	
	q.push(n);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		if (now - 1 >= 0) {
			if (!visited[now - 1]) {
				q.push(now - 1);
				visited[now - 1] = true;
				d[now - 1] = d[now] + 1;
				from[now - 1] = now;
			}
		}

		if (now + 1 < MAX) {
			if (!visited[now + 1]) {
				q.push(now + 1);
				visited[now + 1] = true;
				d[now + 1] = d[now] + 1;
				from[now + 1] = now;
			}
		}

		if (now * 2 < MAX) {
			if (!visited[now * 2]) {
				q.push(now * 2);
				visited[now * 2] = true;
				d[now * 2] = d[now] + 1;
				from[now * 2] = now;
			}
		}
	}

	cout << d[k] << "\n";
	print(n, k);

	cout << "\n";

	return 0;
}