class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        s = [0] * (len(num1) + len(num2))

        for i in reversed(range(len(num1))):
            for j in reversed(range(len(num2))):
                mul = int(num1[i]) * int(num2[j]) + s[i + j + 1]
                s[i + j + 1] = mul % 10
                s[i + j] += mul // 10

            
        for i, c in enumerate(s):
            if c != 0:
                break

        return ''.join(map(str, s[i:]))