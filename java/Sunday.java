public class Sunday {
    static int sunday(String s,String p){
        int i=0,j=0;
        while (j<p.length()){
            if (s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else {
                int next=i-j+p.length();
                if (next<s.length()){
                    int last=p.indexOf(s.charAt(next));
                    if (last==-1){
                        i=next+1;
                    }else {
                        i=next-last;
                    }
                }else{
                    return -1;
                }
                j=0;
            }
        }
        return i-j;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.printf(""+sunday(haystack,needle));
    }
}
