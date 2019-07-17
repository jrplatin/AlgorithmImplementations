#include <iostream>
#include <string> 

using namespace std;


int manual_loop_through_array(int * arr){
   for(int a = 0; a < 4; a++) {
        cout << std::to_string(*(arr + a)) << '\n';    
   }
}

int main()
{
    int array[] = {1,2,3,4};
    manual_loop_through_array(array);
}
