def song_decoder(song):
    return ' '.join(song.replace('WUB',' ').split())

def song_decoder(song):
    words,wub,i = [],False,0
    while i < len(song):
        if i + 3 <= len(song):
            if song[i:i+3] == 'WUB' and wub == False:
                words.append(' ')
                i += 3
                wub = True
                continue
            elif song[i:i+3] == 'WUB' and wub == True:
                i += 3
                continue
            else:
                words.append(song[i])
                wub = False
            i += 1
        else:
            words.append(song[i])
            i += 1
        print(words)
    return ''.join(words).strip()
