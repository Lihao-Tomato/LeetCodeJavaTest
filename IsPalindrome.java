class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while (l <= r){
            char chL = s.charAt(l);
            if (('a'<=chL&&chL<='z') || Character.isDigit(chL)){
                char chR = s.charAt(r);
                while (l<=r && (('a'>chR||chR>'z') || (!Character.isDigit(chR)))){
                    chR = s.charAt(r);
                    if(('a'<=chR && chR<='z') || (Character.isDigit(chR))){
                        break;
                    }
                    r--;
                }
                if(l>r || chL != chR){
                    return false;
                }
                l++;
                r--;
            } else {
                l++;
            }
        }
        return true;
    }
}