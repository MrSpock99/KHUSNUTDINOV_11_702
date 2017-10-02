import java.util.Scanner;
class Program{
    static int lastIndex = 0;
    static int[] array;
    public static void main(String[] args) {
        while (true){

            System.out.println("Введите номер комманды");
            String[] commands = {"1. Создать массив", "2. Добавить число в конец массива","3. Удалить число из массива","4. Вставить число в массив","5. Вывести массив на экран", "6. Выход"};
            System.out.println("");


            for(String command : commands){
                System.out.println(command);
            }

            System.out.print("command = ");


            Scanner scanner = new Scanner(System.in);
            int commandNum = scanner.nextInt();



            switch(commandNum){
                case 1:
                    System.out.println("Введите размер массива");
                    System.out.print("length = ");
                    int length = scanner.nextInt();
                    array = new int[length];
                    for (int i = 0; i < array.length; i++) {
                        array[i] = 0;
                    }
                    lastIndex = 0;
                    break;
                case 2:
                    System.out.println("Введите число");
                    System.out.print("n = ");
                    int n = scanner.nextInt();
		
                    array[lastIndex] = n;
                    lastIndex++;
                    break;
                case 3:
                    System.out.println("Введите индекс");
                    System.out.print("index = ");
                    int index = scanner.nextInt();

                    for (int i = index; i < array.length-1 ; i++) {
                        int val = array[i+1];
                        array[i+1] = array[i];
                        array[i] = val;
                    }

                    array[array.length - 1] = 0;
                    lastIndex--;

                    break;
                case 4:
                    System.out.println("Введите число");
                    System.out.print("num = ");
                    int num = scanner.nextInt();
                    System.out.println("");

                    System.out.println("Введите индекс");
                    System.out.print("index = ");
                    int index1 = scanner.nextInt();

                    if (index1 < lastIndex) {
                        int v = 0;
                        int j = 0;
                        for (int i = index1; i < array.length; i++) {
                            if (i == index1) {
                                v = array[i];
                                array[i] = num;
                            } else {
                                j = array[i];
                                array[i] = v;
                                v = j;
                            }
                        }
                    }else {
                        array[lastIndex] = num;
                        lastIndex++;
                    }
                    break;
                case 5:
                    System.out.println("");

                    System.out.print("array = ");
                    for(int item : array){
                        System.out.print(item + " ");
                    }
                    break;

                case 6:
                    System.exit(0);
            }


            System.out.println("");
            System.out.println("------------------------------------------------------------------");

        }



    }
}