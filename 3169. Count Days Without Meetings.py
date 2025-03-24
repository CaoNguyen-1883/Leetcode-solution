

class Solution(object):
    def countDays(self, days, meetings):
        """
        :type days: int
        :type meetings: List[List[int]]
        :rtype: int
        """
        freeDays = 0
        prevEnd = 0
        
        for start, end in sorted(meetings):
            if start > prevEnd:
                freeDays += start - prevEnd - 1
            prevEnd = max(prevEnd, end)
        return freeDays + max(days - prevEnd, 0)