from collections import defaultdict
class TrieNode():
    def __init__(self, val):
        self.children = defaultdict(lambda: None)
        self.terminating = False
        self.val = val
class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.TrieNode = TrieNode(None)

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        root = self.TrieNode
        for i in word:
            if i not in root.children:
                ma = TrieNode(i)
                root.children[i] = ma
                root = ma
            else:
                root = root.children[i]
        root.terminating = True
    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        root = self.TrieNode
        for i in word:
            if i not in root.children:
                return False
            else:
                root = root.children[i]
        return root.terminating
    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        root = self.TrieNode
        for i in prefix:
            if i not in root.children:
                return False
            else:
                root = root.children[i]
        return True