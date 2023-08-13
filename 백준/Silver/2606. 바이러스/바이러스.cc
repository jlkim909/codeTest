#include<iostream>
using namespace std;

int parent[101];
int Rank[101];
int Find(int x) {
	if (parent[x] == x)
		return x;
	else 
		return parent[x] = Find(parent[x]);
}

void Union(int x, int y) {
	x = Find(x);
	y = Find(y);
	if (x == y)
		return;
	if (Rank[x] < Rank[y]) swap(x, y);
	parent[y] = x;
	if (Rank[x] == Rank[y])
		Rank[x] = Rank[y] + 1;
	return;
}
int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		parent[i] = i;
	}
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		Union(x, y);
	}
	int ans = 0;
	for (int i = 2; i <= n; i++) {
		if (Find(i) == Find(1))
			ans++;
	}
	cout << ans;
	return 0;
}