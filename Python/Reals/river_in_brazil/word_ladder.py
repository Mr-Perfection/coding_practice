import sys

# passed 18/37 test cases
# DFS solution n^n worst case
# working but not fast (timed out.)
# perhaps BFS works?
class Solution(object):
    def word_difference(self, word, word2):
        # assuming word and word2 lengths are the same
        cnt = 0
        for i in range(len(word)):
            if word[i] != word2[i]:
                cnt += 1
        return True if cnt == 1 else False

    def ladder_helper(self, src, dest, visited, wordList,length):
        if src == dest:
            return length + 1

        visited.add(src)
        min_l = sys.maxint
        for word in wordList:
            if word not in visited:
                if self.word_difference(word,src):
                    min_l = min(min_l,self.ladder_helper(word,dest,visited,wordList,length+1))

        visited.remove(src)
        return min_l

    def ladderLength(self, beginWord, endWord, wordList):
        ret = self.ladder_helper(beginWord,endWord,set(),wordList,0)
        return 0 if ret == sys.maxint else ret



# bidirectional search O(n^n/2)

import sys

class Solution(object):


    def ladderLength(self, start, end, word_list):

        end_set, start_set = set(),set()
        visited =set()
        start_set.add(start)
        end_set.add(end)
        word_list = set(word_list)
        result = 1

        # if not(all(x in word_list for x in (start,end))):
        #     return 0
        if end not in word_list: return 0
        while start_set and end_set:

            if len(start_set) > len(end_set):
                end_set,start_set = start_set,end_set

            next_begin_set = set()
            for word in start_set:
                for i in range(len(word)):
                    temp = word[i]
                    for c in [chr(x) for x in range(ord('a'),ord('z')+1)]:
                        target = word[:i]+c+word[i+1:]
                        if target in end_set:
                            return result + 1
                        if target not in visited and\
                           target in word_list:
                            next_begin_set.add(target)
                            visited.add(target)
            start_set = next_begin_set
            result += 1
        return 0




class Solution(object):
    def ladderLength(self, beginWord, endWord, words):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        queue = [beginWord]
        wordList = set(words)
        dist = 1
        while queue:
            for i in range(len(queue)):
                word = queue.pop(0)
                if word == endWord: return dist
                self.add_words(queue,word,wordList)
            dist += 1
        return 0

    def add_words(self, queue, word, wordList):
        x = list(word)
        for i in range(len(word)):
            for j in range(26):
                temp = x[i]
                x[i] = chr(ord('a')+j)
                s = ''.join(x)
                if s in wordList:
                    queue.append(s)
                    wordList.remove(s)
                x[i] = temp

                        
