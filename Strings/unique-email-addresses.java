//Problem: https://leetcode.com/problems/unique-email-addresses/description/




import java.io.*;
import java.util.*;



class EmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        for(int i=0; i<emails.length; i++) {
            String curr = validateEmail(emails[i]);
            ans.add(curr);
        }
        return ans.size();
    }

    public String validateEmail(String email) {
        StringBuilder ans = new StringBuilder("");
        String[] seperated = email.split("\\@");
        String localName = seperated[0], domainName = seperated[1];
        for(char ch: localName.toCharArray()) {
            if(ch=='+') {
                break;
            } else if(ch!='.') {
                ans.append(ch);
            }
        }
        ans.append('@');
        ans.append(domainName);
        return ans.toString();
    }
}

class Main {
    public static void main(String[] args) {
        EmailAddresses addresses = new EmailAddresses();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(addresses.numUniqueEmails(emails));
        
        String[] emails1 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(addresses.numUniqueEmails(emails1));
    }
}