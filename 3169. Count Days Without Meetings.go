package main

import (
	"slices"
	"sort"
)

func countDays1(days int, meetings [][]int) int {
    freeDays := 0;
	prevEnd := 0;
	sort.Slice(meetings, func (i int, j int) bool {
		return meetings[i][0] < meetings[j][0];
	})

	for _, meeting := range meetings{
		start, end := meeting[0], meeting[1];
		if start > prevEnd{
			freeDays += start - prevEnd - 1;
		}
		prevEnd = max(prevEnd, end);
	}
	return freeDays + max(0, days - prevEnd);
}

func countDays(days int, meetings [][]int) int {
    freeDays := 0;
	prevEnd := 0;

	slices.SortFunc(meetings, func(a, b []int) int {
		return a[0] - b[0]
	})

	for _, meeting := range meetings{
		start, end := meeting[0], meeting[1];
		if(start > prevEnd){
			freeDays += start - prevEnd - 1;
		}
		prevEnd = max(prevEnd, end)
	}

	return freeDays + max(0, days - prevEnd);
}

