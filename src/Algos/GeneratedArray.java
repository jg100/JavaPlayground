package Algos;

class GeneratedArray {
    public int getMaximumGenerated(int n) {
        if(n==0) return 0;
        int[] values = new int[2+(n-1)];
        values[0] = 0;
        values[1] = 1;

        int index = 1;
        int max = values[1];
        while((2*index+1 <= n) && (2*index <= n )) {

            values[2*index] = values[index];
            values[2*index+1] = values[index] + values[index + 1];

            if(values[2*index] > max) max = values[2*index];
            else if((values[2*index+1]) > max) max = values[2*index+1];

            index++;
            //System.out.println("Test");
        }
        return max;
    }

}