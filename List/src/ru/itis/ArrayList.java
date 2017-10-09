package ru.itis;

public class ArrayList {
    private int[] array;
    private int count = 0;

    public ArrayList(int len){
        array = new int[len];
    }
    void addNum(int n){
        if (count > array.length - 1){
            int[] newArray = new int[n * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[count] = n;
            count++;
        }else {
            array[count] = n;
            count++;
        }
    }
    void addNum(int num, int index){
        if (index < count) {
            int v = 0;
            int j = 0;
            for (int i = index; i < array.length; i++) {
                if (i == index) {
                    v = array[i];
                    array[i] = num;
                } else {
                    j = array[i];
                    array[i] = v;
                    v = j;
                }
            }
            count++;
        }else {
            array[count] = num;
            count++;
        }
    }

    void removeNum(int index){
        for (int i = index; i < array.length-1 ; i++) {
            int val = array[i+1];
            array[i+1] = array[i];
            array[i] = val;
        }

        array[array.length - 1] = 0;
        count--;
    }


    void showList(){
        for (int i = 0; i < count; i++){
            System.out.print(array[i] + " ");
        }
    }
}
