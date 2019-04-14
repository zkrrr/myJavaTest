package leetcode;


import java.util.ArrayList;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(chars.toString().contains(""+s.charAt(j))){
                    if(chars.length()>length){
                        length = chars.length();
                    }
                    chars.delete(0,chars.length()-1);
                    break;
                }else {
                    chars.append(s.charAt(j));
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }
}
