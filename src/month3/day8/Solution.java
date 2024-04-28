package month3.day8;

import java.util.*;

public class Solution {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        if (Objects.equals(digits, "")){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        backTrace(result,0,digits,new StringBuilder());
        return result;
    }

    private void backTrace(List<String> result,int index, String digits,StringBuilder digit){
        if (index == digits.length()){
            result.add(digit.toString());
            return;
        }
        char phoneNum = digits.charAt(index);
        String phoneStr = phoneMap.get(phoneNum);
        for (int i = 0; i < phoneStr.length(); i++) {
            digit.append(phoneStr.charAt(i));
            backTrace(result,index+1,digits,digit);
            digit.deleteCharAt(index);
        }
    }
}
