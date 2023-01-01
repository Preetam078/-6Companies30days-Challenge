//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<long long>st;
        for(auto t:tokens){
            if(t!="+" and t!="-" and t!="*" and t!="/"){
                st.push(stoi(t));
            }else{
                long long a=st.top();
                st.pop();
                long long b=st.top();
                st.pop();
                long long c;
                if(t=="+"){
                    c=a+b;
                }else
                if(t=="-"){
                    c=b-a;
                }else
                if(t=="*"){
                    c=a*b;
                }else
                if(t=="/"){
                    c=b/a;
                }
                st.push(c);
            }
        }
        return (int)st.top();
    }
};