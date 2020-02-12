package multithreading.assignment.ass1.q7;
/*
 * Tanmayee Kalluri - 001400957
 */
public class Input {
    int index;
    int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};

    public Input(){
        index = 0;
    }

    public void print(int index){
        System.out.println(input[index]);
    }

    synchronized public int getIndex(){
        if(index == 25)
            return -1;
        return index++;
    }
}

