def binary_search(array, left, right, number_to_find):
    if right >= 1:
        midpoint = int((left + right) / 2)
        if array[midpoint] == number_to_find:
            print("The desired number is at index " + str(midpoint+1))
        elif array[midpoint] < number_to_find:
            return binary_search(array, midpoint + 1, right, number_to_find)
        else:
            return binary_search(array, left, midpoint -1, number_to_find)
    else:
        print("The number is not in the array")
if __name__ == '__main__':
    arr =[-1,2,3,4,5, 6]
    number_to_find = 6
    binary_search(arr, 0, len(arr)-1, number_to_find)