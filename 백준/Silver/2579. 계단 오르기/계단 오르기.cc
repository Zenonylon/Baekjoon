#include<iostream>
#include<algorithm>

#define MAX 301

using namespace std;

int s[MAX];
int dp[MAX];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> s[i];
	}

	dp[1] = s[1];
	dp[2] = s[1] + s[2];
	dp[3] = max(s[1] + s[3], s[2] + s[3]);

	for (int i = 4; i <= n; i++) {
		dp[i] = max(dp[i - 2] + s[i], dp[i - 3] + s[i - 1] + s[i]);
	}

	cout << dp[n];

	return 0;
}