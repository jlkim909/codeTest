#include<iostream>
using namespace std;

struct Node {
	int left;
	int right;
};

Node node[30];

void preorder(int x) {
	if (x == -1) return;
	cout << (char)(x + 'A');
	preorder(node[x].left);
	preorder(node[x].right);
}
void inorder(int x) {
	if (x == -1) return;
	inorder(node[x].left);
	cout << (char)(x + 'A');
	inorder(node[x].right);
}
void postorder(int x) {
	if (x == -1) return;
	postorder(node[x].left);
	postorder(node[x].right);
	cout << (char)(x + 'A');
}
int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		char x, l, r;
		cin >> x >> l >> r;
		x = x - 'A';
		if (l == '.')
			node[x].left = -1;
		else
			node[x].left = l - 'A';
		if (r == '.')
			node[x].right = -1;
		else
			node[x].right = r - 'A';
	}
	preorder(0);
	cout << '\n';
	inorder(0);
	cout << '\n';
	postorder(0);
}