#include<iostream>

using namespace std;

int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };

int map[51][51];

int main() {
	int n, m;
	cin >> n >> m;
	int r, c, d;
	cin >> r >> c >> d;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	int ans = 0;
	while (true) {
		if (map[r][c] == 0) {
			ans++;
			map[r][c] = 2;
		}

		bool isBlank = false;
		for (int i = 0; i < 4; i++) {
			int ny = r + dy[i];
			int nx = c + dx[i];

			// if (ny < 0 || nx < 0 || ny > n || nx > m) break;

			if (map[ny][nx] == 0) {
				isBlank = true;
				break;
			}
		}

		if (isBlank) {
			while (true) {
				d = (d + 3) % 4;
				if (map[r + dy[d]][c + dx[d]] == 0) {
					r += dy[d];
					c += dx[d];
					break;
				}
			}
		}
		else {
			int td = (d + 2) % 4;
			if (map[r + dy[td]][c + dx[td]] == 2) {
				r += dy[td];
				c += dx[td];
			}
			else {
				break;
			}
		}
	}

	cout << ans;
	return 0;
}