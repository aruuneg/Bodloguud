#include <bits/stdc++.h>
using namespace std;

// Функц: том тоог string-аар хадгалж үржих
string multiply(string num1, int num2) {
    int carry = 0;
    string result = "";

    for (int i = num1.length() - 1; i >= 0; i--) {
        int product = (num1[i] - '0') * num2 + carry;
        result += (product % 10) + '0';
        carry = product / 10;
    }

    while (carry) {
        result += (carry % 10) + '0';
        carry /= 10;
    }

    reverse(result.begin(), result.end());
    return result;
}

void extraLongFactorials(int n) {
    string result = "1";
    for (int i = 2; i <= n; i++) {
        result = multiply(result, i);
    }
    cout << result << endl;
}

int main()
{
    string n_temp;
    getline(cin, n_temp);
    int n = stoi(n_temp);
    extraLongFactorials(n);
    return 0;
}
