import time 


#algoritmos de ordenacao 

def selection_sort():
    array = [9,25,0,2,66, 1, 10, 7 ]
    for i in range(0, len(array)): 

        for j in range(0, len(array)): 
            if(array[i] < array[j]): # isso daqui muda a ordenação 
                array[i], array[j] = array[j], array[i]
 


def bubble_sort(): 
    array = [9,25,0,2,66, 1, 10, 7 ]
    for i in range(0, len(array)-1 )   : 
        for j in range(0, len(array)-1-i ) : 
            if(array[j] > array[j+1]): 
                array[j+1], array[j] = array[j], array[j+1]


def insertion_sort(): # tá errado, preciso arrumar a key  
    array = [9,25,0,2,66, 1, 10, 7 ]
    for i in range(len(array) ): 
        for j in range(len(array)): 
            if(array[i] < array[j]): 
                array[i], array[j] = array[j], array[i]
                i=0
                j=0 
        
def calc_time( sort, method): 
    inicio = time.time() 
    method
    fim = time.time()
    return f"{sort} : {fim-inicio}" 

types = [["selection sort", selection_sort()], ["bubble sort",bubble_sort()], ["insertion sort", insertion_sort()]] 

def main() : 
    for type in types: 
        print(calc_time(type[0],type[1]))



main()