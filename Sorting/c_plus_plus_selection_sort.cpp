#include <iostream>
#include <string> 


using namespace std;


int* selection_sort(int array[], int size_of_array)
{
    for(int i = 0; i < size_of_array; i=i+1){
        int minIndex = i;
        for(int j = i + 1; j < size_of_array; j = j +1){
            if(array[j] < array[minIndex]){
                minIndex = j;
            }
        }
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
        
    } 
    

    
    return array; 
    
}

int main()
{
    int array[] = {10,4,1,5};
    int size_of_array = sizeof(array) / sizeof(array[0]);
    int* result = selection_sort(array, size_of_array);

    for (int i = 0; i < size_of_array; i++){
        cout << result[i] << '\n';
    }
    return 0;
}
