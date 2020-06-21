package com.selfStudy.baseball;
import java.util.Arrays;
import java.util.Scanner;


public class Baseball {
    Scanner scanner = new Scanner(System.in);

    // 필드
    public int strike;
    public int ball;
    public int cnt;
    
    
    final int LEN; // 맞힐 숫자 개수, 생성자 안에서 초기화됨 // 결과 출력, 종료 메소드에서 매개변수를 없애기 위해
    int[] correct; // 정답
    int[] myAnswer; // 내 답
   

    // 중복 체크 메소드를 위한 i
    private int i;

    // 게임 시작과 종료를 위한 boolean 변수
    public boolean run;



    // 생성자
    public Baseball() {
        run = true;
        System.out.println("야구게임 시작!");
        System.out.print("몇 개의 숫자를 맞히길 원하십니까? > ");
        LEN = scanner.nextInt();
        System.out.println();
    }


    /*
     * 생성자 안에다가 LEN 값 받기를 집어 넣음
    // 맞힐 숫자 개수(정답 배열의 길이)를 return
    public int numsLength() {
        System.out.print("몇 개의 숫자를 맞히길 원하십니까? > ");
        final int LEN = scanner.nextInt();
        System.out.println();
        return LEN;
    }
    */



    // 중복 체크하기
    public void sameNum(int[] nums, int i) {
        for(int j=0; j<i; j++) {
            if(nums[i] == nums[j]) {
                this.i--;
                if(nums == myAnswer) {
                System.out.println("중복입니다! 다시 입력해주세요.\n");
                }
            }
        }

    }


    // 랜덤 숫자 뽑기 ->정답 숫자 배열 return
    // 1에서 9까지
    public int[] randomNums(int LEN) {
        correct = new int[LEN];

        i = 0;
        for(; i<LEN; i++) {
            correct[i] = (int) (Math.random() * 9 + 1);
            sameNum(correct, i);
        }
        return correct;
    }


    // 정답 또는 내 답 보여주기(테스트용, 생략 가능)
    public void printNums(int[] nums) {
    	if(nums == correct) {
    		System.out.print("정답 출력 : ");
    	} else {
    		System.out.print("내 답 출력 : ");
    	}
        System.out.println(Arrays.toString(nums));
        System.out.println();
    }


    // 답 입력
    // 1에서 9까지만 입력 가능
    // 중복되는 숫자 입력 불가능
    public int[] myAnswers(int LEN) {
        myAnswer = new int[LEN];
        cnt++;
        System.out.printf("<<%d번째 시도>>\n", cnt);

        i=0;
        for(; i<LEN; i++) {
            System.out.printf("%d번째 숫자를 입력하세요 > ", i+1);    // 숫자를 하나씩 입력 받음
            myAnswer[i] = scanner.nextInt();

            // 1~9까지만 가능
            if(myAnswer[i] > 0 && myAnswer[i] < 10) {
                sameNum(myAnswer, i); // 중복 체크 메소드
            } else {
                System.out.println("1에서 9 사이의 숫자만 입력해주세요!\n");
                i--; // 범위를 벗어나면 i번째 숫자를 다시 입력해야함
            }
        }

        System.out.println();
        return myAnswer;
    }


    // 스트라이크, 볼 판단
    public void result(int[] correct, int[] myAnswer) {
        strike = 0;
        ball = 0;
        for(int k=0; k<correct.length; k++) {
            for(int j=0; j<correct.length; j++) {
                if(correct[k] == myAnswer[j]) {
                    if(k==j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
    }



    // 결과 출력
    public void printResult() {
        System.out.printf("%d스트라이크 %d볼 %d아웃\n\n", strike, ball, (LEN-strike-ball));
    }

    // 게임 종료
    public void finish() {
        if(strike == LEN) {
            run = false;
            System.out.println("정답입니다!");
            System.out.println(cnt + "번만에 성공하셨습니다.");
            System.out.println("게임종료!");
        }
    }
    
    
    // 전체 게임 시작
    public void start() {
         // 1. 숫자 몇 개 맞힐건지 정하기 -> 생성자에서 시작

         // 2. 랜덤숫자 뽑기
         int[] correct = randomNums(LEN);


         // 2-1. 정답 보여주기(테스트용, 생략 가능)
         // printNums(correct);



         while(run) {
             // 3. 내 답 입력
             int[] myAnswer = myAnswers(LEN);


            // 3-1. 내 답 보여주기(테스트용, 생략 가능)
            // printNums(myAnswer);


             // 4. 결과 판단
             result(correct, myAnswer);

             // 5. 결과 출력
             printResult();

             // 6. 종료
             finish();
         }
    }
    
    
    
}
