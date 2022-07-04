#include <iostream>

using namespace std;

int memoization(int* arr, int size) {
    arr[1] = 1;

    if (size >= 2) {
        arr[2] = 2;

        for (int i = 3; i <= size; i++) {
            arr[i] = arr[i - 1] % 10007 + arr[i - 2] % 10007;
        }
    }

    return arr[size];
}

int main()
{
    int n;
    cin >> n;

    int* dp = new int[n+1];

    cout << memoization(dp, n) % 10007;

    delete[] dp;

    return 0;
}