import java.util.*;

public class Project {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private String projectName = new String();
	
	public void addRoom(Room r) {
		roomList.add(r);
	}
	public void replaceRoom(int index, Room modifiedRoom) {
		roomList.set(index, modifiedRoom);
	}
	public void removeRoom(int index){
		roomList.remove(index);
	}
	public Room getRoomAtIndex(int index) {
		return roomList.get(index);
	}
	public void setName(String n) {
		projectName = n;
	}
	public String getName() {
		return projectName;
	}
}
