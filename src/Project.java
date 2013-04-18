import java.util.*;

public class Project {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private String projectName = new String();
	private MaterialsList materialsList = new MaterialsList();
	
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
	public int getListSize() {
		return roomList.size();
	}
	public void setName(String n) {
		projectName = n;
	}
	public String getName() {
		return projectName;
	}
	public ArrayList<Room> getRoomList() {
		return (ArrayList<Room>)roomList.clone();
	}
	public String[] toStringArray() {
		String returnArray[] = new String[roomList.size()];
		for (int n=0; n<roomList.size(); n++) {
			returnArray[n] = roomList.get(n).getName();
		}
		return returnArray;
	}
	
}