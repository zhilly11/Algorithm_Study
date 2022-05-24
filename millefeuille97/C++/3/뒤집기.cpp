#include <iostream>

using namespace std;

int main() {
	string S;
	int zero = 0, one = 0;

	cin >> S;
	for (int i = 0; i < S.length(); i++) {
		if (S[i] != S[i + 1]) {
			if (S[i] == '0')
				zero++;
			else if (S[i] == '1')
				one++;
			else {
				cout << "error";	// 이외의 문자
				return 0;
			}
		}
	}

	cout << zero << one;
	cout << min(zero, one);

	return 0;
}
