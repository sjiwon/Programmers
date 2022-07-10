package Level1.Level1_NewID;
// Level 1 : 신규 아이디 추천

class Solution {
    public String solution(String new_id) {
        String answer;
        // 1단계 : 전부 소문자로
        String step1 = new_id.toLowerCase();

        // 2단계 : 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)아니면 다 제거
        char [] arr = step1.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for(char c : arr){
            if((c>='a' && c<='z') || (c>='0' && c<='9') || (c=='-') || (c=='_') || (c=='.'))
                step2.append(c);
        }

        // 3단계 : '.'이 2번 이상있으면 하나로 변경
        String step3 = step2.toString().replace("..", ".");
        while(step3.contains(".."))
            step3 = step3.replace("..", ".");

        // 4단계 : '.'이 처음이나 끝에 있으면 제거
        String step4 = step3;
        if(step4.startsWith("."))
            step4 = step4.substring(1, step4.length());
        else if(step4.endsWith("."))
            step4 = step4.substring(0, step4.length()-1);

        // 5단계 : 빈문자열이면 "a" 대입
        String step5 = step4;
        if(step5.equals(""))
            step5 = "a";

        // 6단계 : 16이상이면 15개문자만 저장
        String step6 = step5;
        if(step6.length() >= 16)
            step6 = step6.substring(0, 15);
        if(step6.endsWith("."))
            step6 = step6.substring(0, step6.length()-1);

        // 7단계 : 길이가 2 이하면, 마지막문자를 3이될떄까지 반복
        StringBuilder step7 = new StringBuilder(step6);
        if(step7.length()<=2){
            char last = step7.charAt(step7.length()-1);
            while(step7.length() != 3){
                step7.append(last);
            }
        }
        answer = String.valueOf(step7);
        return answer;
    }
}