import java.util.*;
class charStuff{
    public static void main(String args[]){
        String str;
        try (Scanner sc = new Scanner(System.in)) {
            str = sc.nextLine();
        }
        System.out.println("Initial String : "+str);
        String res = new String();
        String ans = new String();
        for(int i=0;i<str.length();i++){
            res += str.charAt(i);
            if(str.charAt(i) ==' ')
            res += "DLE ";
        }
        ans = "DLE STX " +res+ " DLE ETX";
        System.out.println("After character Stuffing : " +ans);
        String out = new String();
        for(int i=8;i<ans.length()-8;i++){
            out += ans.charAt(i);
            if(ans.charAt(i)==' ')
            i+=4;
        }
        System.out.println("After Destuffing : " +out);
    }
}
