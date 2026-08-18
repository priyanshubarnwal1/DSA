// class Solution {
//     public String removeOuterParentheses(String s) {
//           StringBuilder ans = new StringBuilder();
//         int depth = 0;

//         for (char ch : s.toCharArray()) {

//             if (ch == '(') {
//                 if (depth > 0) {
//                     ans.append(ch);
//                 }
//                 depth++;
//             } 
//             else {
//                 depth--;

//                 if (depth > 0) {
//                     ans.append(ch);
//                 }
//             }
//         }

//         return ans.toString();
//     }
// }



class Solution {
    public String removeOuterParentheses(String s) {
    int cnt = 0;

    StringBuilder ans = new StringBuilder();

    for(int i=0; i<s.length(); i++){
        if(s.charAt(i) == ')'){
            cnt--;
        }
        if(cnt != 0){
            ans.append(s.charAt(i));
        }
        if(s.charAt(i) == '('){
            cnt++;
        }
    }
    return ans.toString();

    }
}