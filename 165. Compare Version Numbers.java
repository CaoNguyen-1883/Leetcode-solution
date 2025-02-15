
import java.io.StringReader; 

class Solution {
    public int compareVersion(String version1, String version2) throws IOException {
        StringReader reader1 = new StringReader(version1);
        StringReader reader2 = new StringReader(version2);
        
        int v1 = 0, v2 = 0;
        int ch1, ch2;

        while ((ch1 = reader1.read()) != -1 || (ch2 = reader2.read()) != -1) {
            while (ch1 != -1 && ch1 != '.') { 
                v1 = v1 * 10 + (ch1 - '0'); 
                ch1 = reader1.read();
            }

            while (ch2 != -1 && ch2 != '.') {
                v2 = v2 * 10 + (ch2 - '0');
                ch2 = reader2.read();
            }

            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
            
            v1 = 0; 
            v2 = 0;
        }

        return 0;
    }
}