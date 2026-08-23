//Problem: https://leetcode.com/problems/generate-tag-for-video-caption/description/





import java.io.*;
import java.util.*;


class VideoCaption {
    public String generateTag(String caption) {
        String[] words = caption.split("\\ ");
        StringBuilder ans = new StringBuilder("#");
        int flag = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0 && flag == 0) {
                ans.append(words[i].toLowerCase());
                flag = 1;
            } else {
                String str = convertToCamelCase(words[i]);
                ans.append(str);
            }
        }

        String res = ans.toString();

        if (res.length() > 100) {
            return res.substring(0, 100);
        }

        return res;
    }

    public String convertToCamelCase(String s) {
        StringBuilder str = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i == 0) {
                str.append(Character.toUpperCase(ch));
            } else {
                str.append(Character.toLowerCase(ch));
            }
        }

        return str.toString();
    }
}

class Main {
    public static void main(String[] args) {
        VideoCaption video = new VideoCaption();

        System.out.println(video.generateTag("Leetcode daily streak achieved"));
        System.out.println(video.generateTag("can I Go There"));
        System.out.println(video.generateTag("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"));
        System.out.println(video.generateTag(" fPysaRtLQLiMKVvRhMkkDLNedQKffPnCjbITBTOVhoVjiKbfSawvpisDaNzXJctQkn"));
        System.out.println(video.generateTag("  "));
    }
}
