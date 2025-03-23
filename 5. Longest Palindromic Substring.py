class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""

        for i in range(len(s)):
            l = i
            r = i
            while r < len(s) - 1 and s[r] == s[r + 1]:
                r += 1
            i = r 

            while l > 0 and r < len(s) - 1 and s[l - 1] == s[r + 1]:
                l -= 1
                r += 1
            if r - l + 1 > len(res):
                res = s[l: r + 1]

        return res