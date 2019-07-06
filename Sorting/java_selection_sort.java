public class SelectionSort{
    
    public void sort(int list[]){
        for(int i = 0; i < list.length -1; i++){
            int minIndex = i;
            for(int j = i+1; j < list.length; j++){
                if(list[j] < list[minIndex]){
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }
    
    public void print_arr(int list[]){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
    }
     public static void main(String []args){
         SelectionSort sortInstance = new SelectionSort();
         int[] arr = {10,9,8,7,11,19,20,100,60,2,-1};
         sortInstance.sort(arr);
         sortInstance.print_arr(arr);
         
     }
}