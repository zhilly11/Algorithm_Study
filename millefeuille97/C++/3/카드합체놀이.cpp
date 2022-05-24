#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, m;	// 카드 개수와 합체 수
	long long sum = 0;
	long long num[1000], temp;

	cin >> n >> m;

	for (int i = 0; i < n; i++)
		cin >> num[i];

	for (int i = 0; i < m; i++) {
		sort(num, num + n);
		temp = num[0] + num[1];
		num[1] = temp; num[0] = temp;
	}

	for (int i = 0; i < n; i++)
		sum += num[i];

	cout << sum;

	return 0;
}
