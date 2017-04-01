 #Write a function that returns the length of the longest leaf-to-leaf path in a binary tree.
def height(root):
  if not(root): return 0
  return 1 + max(height(root.left),height(root.right))

def helper(root,mem):
  if not(root):
    return 0

  if root.left not in mem:
    mem[root.left] = height(root.left)
  else:
    mem[root.right] = height(root.right)


  return max(mem[root.left]+mem[root.right]+1,max(helper(root.left,mem),helper(root.right,mem)))

def length_ltf(root):
  helper()
