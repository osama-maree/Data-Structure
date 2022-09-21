
package tree;
public class Node<E> {

	E Value;
	Node<E> Left , Right;
	
	Node(E Value)
	{
		this.Value = Value;
		this.Left = this.Right = null;
	}
	
}