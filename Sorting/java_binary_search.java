public Class BinarySearch(){
    public void do_search(int[] array, int left, int right, int number_to_find){
    if (right >= left){
        int midpoint = int((left + right) / 2)
    
        if (array[midpoint] == number_to_find){
            System.out.println("The desired number is at index " + str(midpoint+1))
        }
        else if(array[midpoint] < number_to_find){
            return binary_search(array, midpoint + 1, right, number_to_find)
        }
        else{
            return binary_search(array, left, midpoint -1, number_to_find)
        }
    } else{
        System.out.println("The number is not in the array")
       }
    }

    public static void main(String[] args){
        arr =[-1,2,3,4,5, 6]
        number_to_find = 6
        binary_search(arr, 0, len(arr)-1, number_to_find)
        BinarySearch binary_search = new BinarySearch();
        binary_search.do_search()
    }


}

        