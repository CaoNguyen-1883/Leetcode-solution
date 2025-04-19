func generate(numRows int) [][]int {
	var res [][]int;

	for i := 1; i <= numRows; i++{
		l := make([]int, i);
		for j := range l{
			l[j] = 1;
		}
		res = append(res, l);
	}

	for i := 2; i < numRows; i++{
		for j := 1; j < len(res[i]) - 1; j++{
			res [i][j] = res[i - 1][j - 1] + res[i - 1][j];
		}
	}

	return res;
}