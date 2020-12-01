class Node:
    def __init__(self, data, next, prev):
        self.data = data
        self.next = next
        self.prev = prev

class LinkedList:
    def __init__(self):
        self.head = None
        
    def push(self, new_data):
        new_node = Node(new_data, None, None)
        if not self.head:
            self.head = new_node
        else:
            self.head.prev = new_node
            new_node.next = self.head
            self.head = new_node
            
    def print_list(self):
        cur_pointer = self.head
        while cur_pointer != None:
            print(cur_pointer.data)
            cur_pointer = cur_pointer.next
            
    def put_after(self, old_data, new_data):
        cur_pointer = self.head
        while cur_pointer != None and cur_pointer.data != old_data:
            cur_pointer = cur_pointer.next
        if cur_pointer == None:
            print("Not in list")
            return
        
        new_node = Node(new_data, None, None)
        temp = cur_pointer.next
        cur_pointer.next = new_node
        new_node.prev = cur_pointer
        new_node.next = temp
        
    def delete(self, data):
        cur_pointer = self.head
        while cur_pointer != None and cur_pointer.data != data:
            cur_pointer = cur_pointer.next
        if cur_pointer == None:
            print("Not in list")
            return
        
        if cur_pointer == self.head:
            self.head = self.head.next

        last_node = cur_pointer.prev
        if last_node:
            last_node.next = cur_pointer.next
        next_node = cur_pointer.next
        if next_node:
            next_node.prev = last_node
        cur_pointer = None
        
        
            

test_list = LinkedList()
test_list.push(1)
test_list.put_after(1,2)
test_list.put_after(1,3)
test_list.delete(3)
test_list.delete(1)
test_list.delete(2)

test_list.print_list()
