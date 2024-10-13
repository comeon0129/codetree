#include <iostream>

using namespace std;

int main() {
    // 변수 선언
    int a = 13;
  	double b = 0.165;
	
	cout << fixed;
	cout.precision(6);
    
    // 출력
    cout << a << " * " << b << " = " << a * b;
    return 0;
}