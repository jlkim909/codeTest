#include <iostream>
#include <vector>
#include <algorithm>
#include <tuple>
using namespace std;

int map[51][51];
int tArr[51][51];
int n, m, k;
vector<tuple<int, int, int>> ro;
int calF(int row) {
    int sum = 0;
    for (int i = 0; i < m; i++) {
        sum += tArr[row][i];
    }
    return sum;
}
void rR(int y, int x, int s) {
    while (s>0) {
        int temp = tArr[y - s][x + s];
        for (int i = x + s; i > x - s; i--) {
            tArr[y - s][i] = tArr[y - s][i - 1];
        }
        int temp2 = tArr[y + s][x + s];
        for (int i = y + s; i > y - s + 1; i--) {
            tArr[i][x + s] = tArr[i - 1][x + s];
        }
        tArr[y - s + 1][x + s] = temp;
        temp = tArr[y + s][x - s];
        for (int i = x - s; i < x + s; i++) {
            tArr[y + s][i] = tArr[y + s][i + 1];
        }
        tArr[y + s][x + s - 1] = temp2;
        for (int i = y - s; i < y + s - 1; i++) {
            tArr[i][x - s] = tArr[i + 1][x - s];
        }
        tArr[y + s - 1][x - s] = temp;
        s--;
    }
    return;
}
int main() {
    cin >> n >> m >> k;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> map[i][j];
        }
    }
    for (int i = 0; i < k; i++) {
        int r, c, s;
        cin >> r >> c >> s;
        ro.push_back(make_tuple(r-1, c-1, s));
    }
    vector<int> lo;
    int ans = -1;
    for (int i = 0; i < k; i++) {
        lo.push_back(i);
    }
    do {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tArr[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < k; i++) {
            int r, c, s;
            tie(r, c, s) = ro[lo[i]];
            rR(r, c, s);
        }
        for (int i = 0; i < n; i++) {
            int cc = calF(i);
            if (ans == -1 || ans > cc) {
                ans = cc;
            }
        }
    } while (next_permutation(lo.begin(), lo.end()));
    cout << ans;
    return 0;
}