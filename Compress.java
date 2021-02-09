class Solution {
    public int compress(char[] chars) {
        int t=0;
        int i=0;
        while (i <chars.length && t<chars.length) {
            chars[t++]=chars[i];
            int temp=i;
            while (i<chars.length &&chars[i]==chars[t-1])
                i++;
            if(i-temp>1){
                for(char c:String.valueOf(i-temp).toCharArray()){
                    chars[t++]=c;
                }
            }
        }
        return t;
    }
}