from collections import Counter

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        if not s or not words:
            return []
        
        res = []
        n = len(s)
        m = len(words)
        k = len(words[0])
        count = Counter(words)

        for offset in range(k):
            seen = Counter()
            l = offset
            matched = 0

            for r in range(offset, n - k + 1, k):
                word = s[r: r + k]

                if word in count:
                    seen[word] += 1
                    matched += 1

                    while(seen[word] > count[word]):
                        leftWord = s[l: l + k]
                        seen[leftWord] -= 1
                        matched -= 1
                        l += k

                    if matched == m:
                        res.append(l)

                else:
                    matched = 0
                    l = r + k
                    seen.clear()

        return res