import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    // 1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 7. 整数反转
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x = x / 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    // 9. 回文数
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNumber = 0;
        int originalX = x;
        while (x > 0) {
            int digit = x % 10;
            reverseNumber = reverseNumber * 10 + digit;
            x /= 10;
        }
        return reverseNumber == originalX;
    }

    // 13. 罗马数字转整数
    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int preNum = getValue(s.charAt(0));
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            int nextNum = getValue(s.charAt(i));
            if (preNum < nextNum) {
                ans -= preNum;
            } else {
                ans += preNum;
            }
            preNum = nextNum;
        }
        ans += preNum;
        return ans;
    }

    // 14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }
            ans = strs[i].substring(0, j);
            if (ans.equals("")) return "";
        }
        return ans;
    }

    // 20. 有效的括号
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch))
                    return false;
                stack.pop();
            } else
                stack.push(ch);
        }
        return stack.isEmpty();
    }

    // 21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 21. 合并两个有序链表
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    // 26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[left + 1] = nums[right];
                left++;
            }
            right++;
        }
        return left + 1;
    }

    // 27. 移除元素
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
                j++;
            } else
                j++;
        }
        return i;
    }

    // 28. 实现 strStr()
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        int i = 0, j = 0;
        while (i < (haystack.length() - needle.length() + 1) && j < needle.length()) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
                j = 0;
                i++;
            } else {
                j++;
                if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }

    // 35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] < target)
                idx++;
            else
                return idx;
        }
        return idx;
    }

    // 53. 最大子数组和
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // 58. 最后一个单词的长度
    public int lengthOfLastWord(String s) {
        // 指针last指向单词的最后一个位置
        int last = s.length() - 1;
        while (last >= 0 && s.charAt(last) == ' ')
            last--;
        // 指针first指向单词的开头的前一个位置
        int first = last;
        while (first >= 0 && s.charAt(first) != ' ')
            first--;
        return last - first;
    }

    // 66. 加一
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    // 67. 二进制求和
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0; // 记录进位
        int sum = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            sum = carry;
            sum += a.charAt(i) - '0';
            sum += b.charAt(j) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            sum = carry + a.charAt(i) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
            i--;
        }
        while (j >= 0) {
            sum = carry + b.charAt(j) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
            j--;
        }
        if (carry == 1) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }
}
