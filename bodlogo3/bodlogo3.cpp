#include <bits/stdc++.h>
using namespace std;

int nonDivisibleSubset(int k, vector<int> s) {
    vector<int> freq(k, 0);

    for (int num : s) {
        freq[num % k]++;
    }

    int count = min(freq[0], 1);

    for (int i = 1; i <= k / 2; i++) {
        if (i == k - i) {
            count += 1;
        } else {
            count += max(freq[i], freq[k - i]);
        }
    }

    return count;
}

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);
    int k = stoi(first_multiple_input[1]);

    string s_temp_temp;
    getline(cin, s_temp_temp);

    vector<string> s_temp = split(rtrim(s_temp_temp));
    vector<int> s(n);

    for (int i = 0; i < n; i++) {
        s[i] = stoi(s_temp[i]);
    }

    int result = nonDivisibleSubset(k, s);
    fout << result << "\n";
    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);
    s.erase(s.begin(), find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace))));
    return s;
}

string rtrim(const string &str) {
    string s(str);
    s.erase(find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(), s.end());
    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;
    string::size_type start = 0, end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));
        start = end + 1;
    }

    tokens.push_back(str.substr(start));
    return tokens;
}
