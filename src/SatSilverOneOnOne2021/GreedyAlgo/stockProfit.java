package SatSilverOneOnOne2021.GreedyAlgo;

public class stockProfit {
    public static void main(String[] args) {
        int[] stockData = new int[]{7,6,5,8,9,2};
        int maxProfit = 0;
        int currentMin = stockData[0];
        for(int i = 0; i < stockData.length-1; i++) {
           if(stockData[i] < stockData[i+1]) {
               currentMin = Math.min(currentMin, stockData[i]);
           } else {
               maxProfit += stockData[i] - currentMin;
               currentMin = stockData[i];
            }
        }
        if(maxProfit == 0) {
            System.out.println(stockData[stockData.length-1] - currentMin);
        } else if(maxProfit < 0) {
            System.out.println(0);
        } else {
            System.out.println(maxProfit);
        }
        /*
        while((i<length-1 && arr[i]) >= arr[i+1]) {
            i++;
            //if jump out while loop that means you reach a current min point
            }
        while((i<length-1 && arr[i]) <= arr[i+1]) {

            //jump out while loop that means you reach a current max point
        }
         */
    }
}
