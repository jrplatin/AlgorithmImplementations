def sort(array):
    for i in range (0, len(array)):
        minIndex = i
        for j in range(i+1, len(array)):
            if array[j] < array[minIndex]:
                minIndex = j
            temp = array[minIndex]
            array[minIndex] = array[i]
            array[i] = temp

if __name__ == '__main__':
    arr =[10,9,8,7,11,19,20,100,60,2,-1]
    sort(arr)
    print(arr)