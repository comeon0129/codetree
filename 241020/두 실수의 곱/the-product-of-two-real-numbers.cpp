#include <iostream>

using namespace std;

int main() {
    // 변수 선언
    double a = 5.26;
  	double b = 8.27;
	
	cout << fixed;
	cout.precision(3);
    
    // 출력
    cout << a * b;
    return 0;
}