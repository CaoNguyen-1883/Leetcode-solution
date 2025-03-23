
func longestPalindrome(s string) string {
	if (len(s) < 1) {return s}

    res := ""

	for i := 0; i < len(s); {
		l := i
		r := i
		for r < len(s) - 1 &&  s[r] == s[r + 1]{
			r++
		}
		i = r + 1
		
		for l > 0 && r < len(s) - 1 && s[l - 1] == s[r + 1]{
			l--
			r++
		}

		if(r - l + 1 > len(res)){
			res = s[l: r + 1]
		}
	}

	return res
}