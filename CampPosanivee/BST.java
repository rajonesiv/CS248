
public class BST //implements SortedList
{
	private class treenode
	{
		public Comparable item;
		treenode left;
		treenode right;
	}
	treenode root;
	int count;
	
	public BST()
	{
		makeEmpty();
		Q=new QueueLL();
	}
	

	public void insert(Comparable x)
	{
		root=inserth(x,root);
		count++;
	}
	private treenode inserth(Comparable x, treenode r)
	{
		if(r==null)
		{
			r=new treenode();
			r.left=r.right=null;
			r.item=x;
			return r;
		}
		else
		{
			if(x.compareTo(r.item)<=0)
				r.left=inserth(x,r.left);
			else
				r.right=inserth(x,r.right);
			return r;
		}
	}
	
	public void print() { printh(root); }
	private void printh(treenode r)
	{
		if(r==null) return;
		printh(r.left);
		System.out.println(r.item);
		printh(r.right);
	}

	public Comparable search(Comparable x)
	{
		return searchh(x,root);
	}	
	private Comparable searchh(Comparable x,treenode r)
	{
		if(r==null) { return null; }
		int cmpresult=x.compareTo(r.item);
		if(cmpresult==0) // here it is!
		{ return r.item; }
		if(cmpresult<0)
		{ return searchh(x,r.left); }
		else
		{ return searchh(x,r.right); }
	}
	
	private Comparable deleteditem;
	
	public Comparable delete(Comparable x)
	{ 
		deleteditem=null;
		root=deleteh(x,root);
		return deleteditem;
	}
	
	private treenode deleteh(Comparable x, treenode r)
	{
		if(r==null) return null;
		if(x.compareTo(r.item)<0)
		{
			r.left=deleteh(x,r.left);
			return r;
		}
		else if(x.compareTo(r.item)>0)
		{
			r.right=deleteh(x,r.right);
			return r;
		}
		else // here it is - delete it
		{
			count--;
			deleteditem=r.item;
			if(r.left==null && r.right==null)
			{
				// 0 children
				return null;
			}
			if(r.right==null)
			{
				// one child on the left
				return r.left;
			}
			if(r.left==null)
			{
				// one child on the right
				return r.right;
			}
			// two children
			Comparable is=minh(r.right);
			Comparable saved=r.item;
			r.item=is;
			r.right=deleteh(is,r.right);
			count++;
			deleteditem=saved;
			return r;
		}
	}
/*	
	public Comparable delete(int pos){}
	
	public Comparable get(int pos){}
*/
	private Queue Q;
	public static final int PREORDER=0;
	public static final int INORDER=1;
	public static final int POSTORDER=2;
	
	public void reset() { reset(INORDER); }
	
	public void reset(int order)
	{
		Q.makeEmpty();
		traversal(root,order);
	}
	
	private void traversal(treenode r, int order)
	{
		if(r==null) return;
		if(order==PREORDER) Q.enqueue(r.item);
		traversal(r.left,order);
		if(order==INORDER) Q.enqueue(r.item);
		traversal(r.right,order);
		if(order==POSTORDER) Q.enqueue(r.item);
	}
	
	public boolean hasNext(){ return !Q.isEmpty(); }
	public Comparable getNext()
	{ return (Comparable) Q.dequeue(); }
	
	public Comparable min(){ return minh(root); }
	private Comparable minh(treenode r)
	{
		if(r==null) return null;
		if(r.left==null) return r.item;
		return minh(r.left);
	}
	
	public Comparable max(){ return maxh(root);}
	private Comparable maxh(treenode r)
	{
		if(r==null) return null;
		if(r.right==null) return r.item;
		return maxh(r.right);
	}
	
	public boolean isEmpty() { return count==0; }
	public boolean isFull() { return false; }
	public int size() { return count;}
	public void makeEmpty()
	{ root=null; count=0; }
}