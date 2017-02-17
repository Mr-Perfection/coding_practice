"""
design a system to shuffle music, given a list, shuffle songs and return in a new list
["I love you","Bieber", "Little girl"]

How random can it be?

"""
import random

def swap_order(songs,left,right):
    while left < right:
        temp = songs[left]
        songs[left] = songs[right]
        songs[right] = temp
        left += 1
        right -= 1
    return songs

def swap_with_center(songs, center):
    mid = int(len(songs) / 2)
    # if center < mid, swap only between 0..mid
    if center < mid:
        return swap_order(songs,0,center)
    # if center == mid, swap between 0..len(songs)
    if center == mid:
        return swap_order(songs,0,len(songs)-1)
    # if center > mid, swap only between mid..len(songs)
    if center > mid:
        return swap_order(songs,mid,len(songs)-1)

def shuffle_music(songs):
    # get the random index from [0, len(songs))
    rand = random.randrange(0,len(songs))
    # set this index as a pivot which will swap all the right and left elements
    print(rand)
    return swap_with_center(songs, rand)

songs = ["I love you","Bieber", "mucho", "Hello","starboy","Little girl"]
print(shuffle_music(songs))
