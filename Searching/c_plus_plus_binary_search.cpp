#include <iostream>
#include <string> 


using namespace std;


int binary_search(int array[], int left, int right, int number_to_find)
{
    if(right >= left){
        int midpoint = int((left + right) / 2);
        if(array[midpoint] == number_to_find){
            std::string str_index = std::to_string(midpoint);
            cout << "Your number is at index " << str_index;
        } else if(array[midpoint] < number_to_find){
            return binary_search(array, midpoint + 1, right, number_to_find);
        } else {
            return binary_search(array, left, midpoint - 1, number_to_find);
        }
    } else {
        cout << "The provided number is not in the array";
    }
    
}

int main()
{
    int array[] = {1,2,3};
    int size = sizeof(array)/sizeof(array[0]) - 1;
    binary_search(array, 0, size, 1);

    return 0;
}
