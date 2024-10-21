#include <iostream>
using namespace std;

int main() {
    int row, column;
    cin>> row >> column;
    row+=8;
    column*=3;
    cout<<row<<endl<<column<<endl<<row*column;
    return 0;
}