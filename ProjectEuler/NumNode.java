/**
 * This class defines a node, representing a long and 
 * a reference to a next node. 
 */
public class NumNode {
	public long	data;
	public NumNode	next;
	
   /**
    * This constructs one node. 
    * 
    * @param data The long that the node represents
    * @param next The reference to the next node in the list
    */
	public NumNode(long data, NumNode next) {
		this.data =	data;
		this.next =	next;
	}
}