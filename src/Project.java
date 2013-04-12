import java.util.*;

public class Project {
	private LinkedList<Room> roomList = new LinkedList();
	
	public void addRoom(Room r) {
		roomList.add(r);
	}
	public void removeRoom(int index){
		roomList.remove(index);
	}
	public Room getRoomAtIndex(int index) {
		return roomList.get(index);
	}
}
