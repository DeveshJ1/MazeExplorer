
public class QueueOfSpaces implements PossibleLocations{
	private DoublyLinkedList<Location> storage;
	public QueueOfSpaces() 
	{
		this.storage= new DoublyLinkedList<>();
	}
	@Override
	public void add(Location s)
	{
		// TODO Auto-generated method stub
		if(s==null) 
		{
			throw new NullPointerException("Null locations are not allowed");
		}
		storage.add(s);
	}

	@Override
	public Location remove() 
	{
		if(isEmpty()) 
		{
			return null;
		}
		return storage.remove(0);
	}

	@Override
	public boolean isEmpty() 
	{
		return storage.isEmpty();
	}
	@Override
	public String toString() 
	{
		return storage.toString();
	}
}
