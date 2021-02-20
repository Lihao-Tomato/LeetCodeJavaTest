class Solution {
    public String sortString(String s) {
        int[] countWords = new int[26];
        char[] words = s.toCharArray();
        for (char ch : words) {
            countWords[ch-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        int flg = 0;
        while (flg < s.length()){
            for (int i = 0; i < countWords.length; i++) {
                if(countWords[i] > 0){
                    sb.append((char)(i+'a'));
                    countWords[i]--;
                    flg++;
                }
            }
            for (int j = countWords.length-1; j >= 0; j--) {
                if(countWords[j] > 0){
                    sb.append((char)(j+'a'));
                    countWords[j]--;
                    flg++;
                }
            }
        }
        return sb.toString();
    }
}