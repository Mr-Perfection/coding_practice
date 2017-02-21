def duplicate_count(s):
    return len([for x in set(s.lower()) if s.lower().count(x) > 1])
