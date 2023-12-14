import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class DoublyLinkedList<E> implements Iterable<E>
{
	private class Node<E>
	{
		public Node<E> next;
		public Node<E> prev;
		public E data;
		public Node(E data) 
		{
			if(data==null) 
			{
				throw new NullPointerException("Invalid Data!");
			}
			this.next=null;
			this.prev=null;
			this.data=data;
		}
	}
	private Node<E> head;
	private Node<E> tail;
	private int size;
	public DoublyLinkedList() 
	{
		head=null;
		tail=null;
		size=0;
	}
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() 	
		{
			private Node<E> current=head;
			public boolean hasNext() 
			{
				return current!=null;
			}
			public E next() 
			{
				if(!hasNext()) 
				{
					throw new NoSuchElementException("No further elements!");
				}
				E data= current.data;
				current=current.next;
				return data;
			}
		};
	}
	public boolean add(E e) throws ClassCastException
	{
		try 
		{
			Node<E> newNode= new Node<E>(e);
			if(isEmpty()) 
			{
				head=tail=newNode;
			}
			else 
			{
				tail.next=newNode;
				newNode.prev=tail;
				tail=newNode;
			}
			size++;
			return true;
		}
		catch(ClassCastException c) 
		{
			throw new ClassCastException("Invalid Class for addition!");
		}
	}
	public boolean add(E e, int pos) throws ClassCastException
	{
		try 
		{
			if(pos<0 || pos>size) 
			{
				throw new IndexOutOfBoundsException("Position out of range!");
			}
			else 
			{
				if(pos==size) 
				{
					return add(e);
				}
				else 
				{	
					Node<E> newNode= new Node<E>(e);
					if (pos==0) 
					{
						head.prev=newNode;
						newNode.next=head;
						head=newNode;
					} 
					else 
					{
						Node<E> current= getNode(pos-1);
						newNode.next=current.next;
						newNode.prev=current;
						current.next.prev=newNode;
						current.next=newNode;
					}
				}				
			}
			size++;
			return true;
		}
		catch(ClassCastException c) 
		{
			throw new ClassCastException("Invalid Class for addition at position!");
		}
	}
	public void clear() 
	{
		head=tail=null;
		size=0;
	}
	
	public boolean contains(Object o)
	{
		for(E element: this) 
		{
			if(Objects.equals(o,element)) 
			{
				return true;
			}
		}
		return false;
	}
	public boolean equals (Object o) 
	{
		if(this==o) 
		{
			return true;
		}
		if(!(o instanceof DoublyLinkedList)) 
		{
			return false;
		}
		DoublyLinkedList<?> temp=(DoublyLinkedList<?>) o;
		if(size!=temp.size) 
		{
			return false;
		}
		Iterator<E> thisIterator= iterator();
		Iterator<?> tempIterator= temp.iterator();
		while(thisIterator.hasNext()) 
		{
			if(!(Objects.equals(thisIterator.next(),tempIterator.next()))) 
			{
				return false;
			}
		}
		return true; 
	}
	public E get (int pos)
	{
		if(pos<0 || pos>=size) 
		{
			return null;
		}
		return getNode(pos).data;
	}
	public boolean isEmpty() 
	{
		return size==0;
	}
	public int indexOf(Object o) 
	{
		int answer=0;
		for(E element: this) 
		{
			if(Objects.equals(o, element)) 
			{
				return answer;
			}
			answer++;
		}
		return -1;
	}
	public boolean remove(Object o) throws ClassCastException
	{
		if(o==null) 
		{
			throw new NullPointerException("Invalid object to remove!");
		}
		try 
		{
			Node<E> current=head;
			while(current!=null) 
			{
				if(Objects.equals(o, current.data)) 
				{
					unlink(current);
					return true;
				}
				current=current.next;
			}
			return false;
		}
		catch(ClassCastException e) 
		{
			throw new ClassCastException("Invalid Class for object to remove");
		}
	}

	public E remove (int pos) 
	{
		if(pos<0 || pos>=size) 
		{
			throw new IndexOutOfBoundsException("Index out of range!");
		}
		Node<E> removalNode= getNode(pos);
		unlink(removalNode);
		return removalNode.data;
	}
	
	public int size() 
	{
		return size;
	}
	@Override
	public String toString() 
	{
		StringBuilder answer= new StringBuilder("[");
		for(E element: this) 
		{
			answer.append(String.valueOf(element)).append(", ");
		}
		if(size>0) 
		{
			answer.setLength(answer.length()-2);
		}
		answer.append("]");
		return answer.toString();
	}
	private Node<E> getNode(int pos) 
	{
		Node<E> current;
		if(pos<=size/2) 
		{
			current=head;
			for(int i=0;i<pos;i++) 
			{
				current=current.next;
			}
		}else 
		{
			current=tail;
			for(int i=size-1;i>pos;i--) 
			{
				current=current.prev;
			}
		}
		return current;
	}
	private void unlink(Node<E> current)
	{
		if(current.prev==null) 
		{
			head=current.next;
		}else 
		{
			current.prev.next=current.next;
		}
		if(current.next==null) 
		{
			tail=current.prev;
		}
		else 
		{
			current.next.prev=current.prev;
		}
		size--;
	}
}
