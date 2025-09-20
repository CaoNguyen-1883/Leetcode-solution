class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int arr[] = new int[n + m];

        for(int i = n - 1; i >= 0; --i){
            for(int j = m - 1; j >= 0; --j){
                int l1 = i + j, l2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + arr[l2];
                arr[l1] += mul / 10;
                arr[l2] = mul % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < arr.length && arr[i] == 0) ++i;

        for(; i < arr.length; ++i){
            res.append(arr[i]);
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}

//         123
//         456

//         738
    //        615
    //       861   
    //       92988   