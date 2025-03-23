package main

import (
	"fmt"
)

func maximalRectangle(matrix [][]byte) int {
	if matrix == nil{
		return 0;
	}
	n := len(matrix[0])
    res := 0;
	hist := make([] int, n);
	for _, row:= range matrix{
		for i := 0; i < n; i++{
			if(row[i] == '0'){
				hist[i] = 0;
			} else{
				hist[i] += 1;
			}
		}
		res = max(res, maxReact(hist));
	}

	return res;
}

func maxReact(heights []int) (res int){
	res = 0;
	stack := [] int {};

	for i := 0; i <= len(heights); i++{

		for len(stack) > 0 && (i == len(heights) || heights[stack[len(stack) - 1]] >= heights[i]){
			h := heights[stack[len(stack) - 1]];
			stack = stack[: len(stack) - 1];
			w := i;
			if(len(stack) > 0){
				w = i - stack[len(stack) - 1] - 1;
			}
			res = max(res, h * w);
		}

		stack = append(stack, i);
	}

	return
}