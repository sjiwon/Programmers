package Level1.Level1_NumChangeToEng;
// Level 1 : 숫자 문자열과 영단어

class Solution {
    public int solution(String s) {
        String [] eng = {"zero", "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine"};

        for (String value : eng) {
            s = s.replace(value, change(value));
        }

        return Integer.parseInt(s);
    }
    static String change(String eng){
        switch(eng){
            case "zero":
                return "0";
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                break;
        }
        return null;
    }
}