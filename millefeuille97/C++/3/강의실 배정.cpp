#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;
struct node { int s, t; };
node lecture[200000];

bool compare(node a, node b) {
	return (a.s == b.s) ? a.t < b.t : a.s < b.s;
}

int main() {
	int n;

	ios_base::sync_with_stdio(0);	// 입출력 속도 향샹
	cin.tie(0); cout.tie(0);	// cin, cout 묶인거 풀어서 버퍼 문제 방지
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> lecture[i].s >> lecture[i].t;
	}

	sort(lecture, lecture + n, compare);

	priority_queue<int, vector<int>, greater<int>> q;	// 우선순위 따라 정렬되는 우선순위 큐
	q.push(lecture[0].t);

	for (int i = 1; i < n; i++) {
		int s = lecture[i].s, t = lecture[i].t;
		int now = q.top();		// 끝 시간이 빠른 것 부터 반환

		if (now > s) {//겹치는경우 
			q.push(t);
		}
		else {
			q.pop();
			q.push(t);
		}
	}
	cout << q.size();

	return 0;
}