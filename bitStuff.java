import java.util.*;
class bitStuff{
    public static void main(String args[]){
        System.out.println("Enter the Binary message ");
        try (Scanner sc = new Scanner(System.in)) {
            String data = sc.next();
            String res = new String();
            String out = new String();
            int cnt=0;
            for(int i=0;i<data.length();i++){
                if(data.charAt(i) != '1' && data.charAt(i) != '0'){
                    System.out.println("Enter only binary values!!");
                    return;
                }
                res += data.charAt(i);
                if(data.charAt(i) == '1')
                    cnt+=1;
                else
                    cnt=0;
                if(cnt==5){
                    res = res +'0';
                    cnt = 0;
                }
            }
            String inc = "01111110" + res + "01111110";
            System.out.println("The message to be transferred :" +inc);
            System.out.println("Sending Message..");
            cnt=0;
            for(int i=8;i<inc.length()-8;i++){
                out += inc.charAt(i);
                cnt+=1;
                if(cnt == 5){
                    i+=1;
                    cnt = 0;
                }
            }
            System.out.println("Final Message : " + out);
        }
    }
}