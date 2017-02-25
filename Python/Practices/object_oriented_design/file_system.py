import time
# Super class of File and Directory
class Entry:
    # Class Variables:
        # parent directory (Directory)
        # created_at (datetime)
        # updated_at (datetime)
        # last_access_at (datetime)
        # entry_name (string)

    # initialization:
    # initialize all the class variables
    def __init__(self, parent,name):
        self.__parent = parent
        self.__name = name
        self.__created_at = time.strftime("%b %d %Y %H:%M:%S")
        self.__updated_at = time.strftime("%b %d %Y %H:%M:%S")
        self.__access_at = time.strftime("%b %d %Y %H:%M:%S")

    # a method that deletes a file or directory from parent
    def delete(self):
        # check if parent is null
        if not(self.parent):
            raise RunTimeError('the parent directory does exist.')
        return self.parent.delete_entry(self)
    # a method that gets the full path of an entry
    def fullpath(self):
        if not(self.parent):
            return self.name
        return self.parent.fullpath()+"/"+self.name

    # getters and setters
    # ...


# File subclass
class File(Entry):
    # Class Variables:
        # content (string)
        # size (integer)

    # initialization:
    def __init__(self,parent,name,content,size):
        super().__init__(parent,name)
        self.__content = content
        self.__size = size
    # getters and setters
    def size(self):
        return

    def __lt__(self, other):
      # return comparison
    def __le__(self, other)
      # return comparison
    def __eq__(self, other)
      # return comparison
    def __ne__(self, other)
      # return comparison
    def __gt__(self, other)
      # return comparison
    def __ge__(self, other)
      # return comparison

# Directory subclass
# ...

class Directory(Entry):
    # Class Variables:
        # list of entries (string)
        # size (integer)
    def __init(self, parent,name):
        super().__init__(parent, name)
        self.__contents = []

    def number_of_files(self):
        count = 0
        for e in contents:
            if isinstance(e,Directory):
                count += e.number_of_files()
            else:
                count += 1
        return count
    def delete_entry(self,entry):
        return self.__contents.remove(entry)

    # getters and setters
