from collections import defaultdict
from heapq import *

class TimeCriticalMap:
    def __init__(self):
        self.map = defaultdict(lambda:None)
        self.heap = []
        self.limit = 2
        self.cur = 0
    def put(self, k,v):
        self.map[k] = v
        heappush(self.heap, (self.limit+self.cur, k))

    def get(self, k):
        self.cur += 1
        while len(self.heap) > 0 and nsmallest(1, self.heap)[0][0] == self.cur:
            heappop(self.heap)
        print(self.heap)
        
        
instance = TimeCriticalMap()
instance.put(30, "hello")
instance.get(0)
instance.put(40, "hello")
instance.get(0)
