public static class Node {
	private int id;
	LinkedList<Node> adjacent = new LinkedList<Node>();
	private Node(int _id)
	{
		this.id = _id;
	}
}
private Node getNode(int id){}
public void addEdge(int source, int destination){}

public boolean hasPathDFS(int source, int destination)
{
	Node s = getNode(source);
	Node d = getNode(destination);
	HashSet<Integer> visited = new HashSet<Integer>();
	return (hasPathDFS(s, d, visited));
}

private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited)
{
	if (visited.contains(source.id))
	{
		return (false);
	}
	visited.add(source.id);
	if (source == destination)
		return (true);
	for (Node child : source.adjacent)
	{
		if (hasPathDFS(child, destination, visited))
			return (true);
	}
	return (false);
}

public boolean hasPathBFS(Node source, Node destination)
{
	//this will track the nodes that need to be visited
	LinkedList<Node> nextToVisit = new LinkedList<Node>();
	//track the nodes that are already visited
	HashSet<Integer> visited = new HashSet<Integer>();
	//add the source to the queue as next node to visit.
	nextToVisit.add(source);
	//while the queue is not empty
	while(!nextToVisit.isEmpty())
	{
		//remove the first node from the linkedlist (queue)
		Node node = nextToVisit.remove();
		//if node is equal to destination
		if (node == destination)
			return (true);
		//if visited
		if (visited.contains(node.id))
			continue ;
		//add to the queue as nodes that have been visited
		visited.add(node.id);
		//add the adjacent neighbor nodes (or children nodes) to the queue
		for (Node neighbor : node.adjacent)
		{
			nextToVisit.add(neighbor);
		}

	}
}