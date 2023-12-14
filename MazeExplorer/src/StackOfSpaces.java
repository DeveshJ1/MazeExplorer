

public class StackOfSpaces implements PossibleLocations {
	private DoublyLinkedList<Location> storage;
	public StackOfSpaces() 
	{
		this.storage= new DoublyLinkedList<Location>();
	}
	@Override
	public void add(Location s) {
		// TODO Auto-generated method stub
		if(s==null) 
		{
			throw new NullPointerException("Null locations aren't allowed");
		}
		storage.add(s);
	}

	@Override
	public Location remove() {
		// TODO Auto-generated method stub
		if(isEmpty()) 
		{
			return null;
		}
		return storage.remove(storage.size()-1);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return storage.isEmpty();
	}
	@Override
	public String toString() 
	{
		return storage.toString();
	}

}
