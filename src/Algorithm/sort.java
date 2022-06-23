package Algorithm;

public class sort {
    public static void insertSort(int[] arr){
        for(int i = 1 ;i< arr.length; i++){
            int key = arr[i];
            int j = i -1;
            while(j >=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]= key;
        }
    }
    public static void selectSort(int[] arr){
        int[] newArr = arr;
        for(int i = 0 ;i< newArr.length; i++){
            int min = newArr[i];
            for(int j = i+1; j < newArr.length;j++){
                if(min > newArr[j]){
                    int temp = min;
                    min = newArr[j];
                    newArr[j] = temp;
                }
            }
            newArr[i] =  min;
        };
    }

    public static void bubboSort(int[] arr){
        for(int i =0; i < arr.length; i++){
            for(int j= i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
        }
    }


    public static void maxheapity(int[] arr, int start){
        int temp = arr[start];
        int len = arr.length;
        System.out.println("start:"+start);
        for(int i = 2 * start +1; i < arr.length; i = 2 * i + 1){
           System.out.println("i:"+i);
           if(i+1< len&& arr[i]<arr[i+1]){
               i++;
               System.out.println("max i:"+i);
           }
           if(temp < arr[i]){
               arr[start] = arr[i];
               arr[i] = temp;
           }
           System.out.println("temp:"+temp);
        }
        System.out.println("===== done =========");
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length/2-1; i > 0 ;i--){
            maxheapity(arr, i);
        }
    }

    public static void swap(int a, int b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;

    }


    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        printArray(array);
        heapSort(array);
        printArray(array);
    }
}
