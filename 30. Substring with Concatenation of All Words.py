from collections import Counter

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return [    ]
        res = []
        m = len(s)
        n = len(words)
        k = len(words[0])
        count = Counter(words)

        for offset in range(k):
            seen = Counter()
            left = offset
            matched = 0
            for right in range(offset, m  - k + 1, k):
                word = s[right: right + k]
                if word in count:
                    seen[word] += 1
                    matched += 1

                    while(seen[word] > count[word]):
                        leftWord = s[left: left + k]
                        seen[leftWord] -= 1
                        matched -= 1
                        left += k

                    if matched == n:
                        res.append(left)
                else:
                    seen.clear()
                    matched = 0
                    left = right + k
        

        return res