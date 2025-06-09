#include <bits/stdc++.h>
using namespace std;

int queensAttack(int n, int k, int r_q, int c_q, vector<vector<int>> obstacles) {
    set<pair<int, int>> obs;
    for (auto &o : obstacles) {
        obs.insert({o[0], o[1]});
    }

    int directions[8][2] = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    int total = 0;
    for (auto &dir : directions) {
        int r = r_q + dir[0];
        int c = c_q + dir[1];
        while (r >= 1 && r <= n && c >= 1 && c <= n && obs.find({r, c}) == obs.end()) {
            total++;
            r += dir[0];
            c += dir[1];
        }
    }

    return total;
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

    string second_multiple_input_temp;
    getline(cin, second_multiple_input_temp);
    vector<string> second_multiple_input = split(rtrim(second_multiple_input_temp));
    int r_q = stoi(second_multiple_input[0]);
    int c_q = stoi(second_multiple_input[1]);

    vector<vector<int>> obstacles(k);
    for (int i = 0; i < k; i++) {
        obstacles[i].resize(2);
        string obstacles_row_temp_temp;
        getline(cin, obstacles_row_temp_temp);
        vector<string> obstacles_row_temp = split(rtrim(obstacles_row_temp_temp));
        for (int j = 0; j < 2; j++) {
            obstacles[i][j] = stoi(obstacles_row_temp[j]);
        }
    }

    int result = queensAttack(n, k, r_q, c_q, obstacles);
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
