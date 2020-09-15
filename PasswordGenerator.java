import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
class Generate{
    String smallAlphabet="abcdefghijklmnopqrstuvwxyz";
    String largeAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String digits="1234567890";
    String specialCharacters="!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    String all = smallAlphabet+largeAlphabet+digits+specialCharacters;

    public String generatePassword(int length){
        Random random = new Random();
        StringBuilder password = new StringBuilder();
                password.append((smallAlphabet.charAt(random.nextInt(26)))).
                        append(largeAlphabet.charAt(random.nextInt(26))).
                        append(digits.charAt(random.nextInt(10))).
                        append(specialCharacters.charAt(random.nextInt(31)));
        int left = length-4;
        StringBuilder remPass = new StringBuilder();
        while(left-->0){
            remPass.append(all.charAt(random.nextInt(93)));
        }
        password.append(remPass);
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<password.toString().length();i++){
            list.add(password.charAt(i));
        }
        Collections.shuffle(list);
        StringBuilder finalPassword = new StringBuilder();
        for(int i=0;i<list.size();i++){
            finalPassword.append(list.get(i));
        }
        return finalPassword.toString();
    }
}


public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Generate generate = new Generate();
        System.out.println("Enter the length of the password you require: ");
        int lenOfPass = scanner.nextInt();
        if(lenOfPass<8 || lenOfPass>32){
            while(lenOfPass<8||lenOfPass>32) {
                System.out.println("Please enter length greater than 6 and less than 32");
                lenOfPass=scanner.nextInt();
            }
        }
        String password = generate.generatePassword(lenOfPass);
        System.out.println("Your password is: "+password);
    }
}
