package SatAndWedClass20182020;

public class dailyTemp {
    public int[] dailyTemperatures(int[] T) {
        int[] answer = new int[T.length];
        int temp = 0;
        //int intHolder = 0;
        for(int i = 0; i < answer.length; i++) {
            for(int j = i + 1; j < answer.length; j++) {
                temp++;
                if(T[j] > T[i]) {
                    answer[i] = temp;
                    break;
                }
            }
            temp = 0;
        }
        return answer;
    }
}
