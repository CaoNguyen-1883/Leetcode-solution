class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;

            sb.append((char)('A' + columnNumber%26));

            columnNumber = columnNumber / 26;
        }

        return sb.reverse().toString();
    }
    public String convertToTitle1(int columnNumber) {
        return columnNumber == 0 ? "" : 
            convertToTitle((columnNumber - 1) / 26) + (char)('A'+ (columnNumber - 1) % 26);
    }
}