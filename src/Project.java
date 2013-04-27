import java.util.*;

/**
 * used to store and modify information about the project 
 */
public class Project {
	private ArrayList<Room> roomList = new ArrayList<Room>();
	private String projectName = new String();
	private LinkedList<Material> materialsList;
	
	/**
	 * 
	 */
	/*public Project() {
		//this.materialsList = m;
	}*/
	
	/**
	 * adds a room to the project
	 * @param r room to be added
	 */
	public void addRoom(Room r) {
		roomList.add(r);
	}
	
	/**
	 * replaces a room in the project with a modified one
	 * @param index index of room to be replaced
	 * @param modifiedRoom replacement room
	 */
	public void replaceRoom(int index, Room modifiedRoom) {
		roomList.set(index, modifiedRoom);
	}
	
	/**
	 * removes a room at the specified index from the project
	 * @param index index of room to be removed
	 */
	public void removeRoom(int index){
		roomList.remove(index);
	}
	
	/**
	 * returns the specified room in the project
	 * @param index room to get
	 * @return selected room 
	 */
	public Room getRoomAtIndex(int index) {
		return roomList.get(index);
	}
	/**
	 * returns the number of rooms in the project
	 * @return number of rooms in the project
	 */
	public int getListSize() {
		return roomList.size();
	}
	/**
	 * sets the name of the project
	 * @param n the name of the project
	 */
	public void setName(String n) {
		projectName = n;
	}
	/**
	 * returns the name of the project
	 * @return the name of the project
	 */
	public String getName() {
		return projectName;
	}
	
	/**
	 * returns the list of rooms in the project
	 * @return list of rooms in the project
	 */
	public ArrayList<Room> getRoomList() {
		return (ArrayList<Room>)roomList.clone();
	}
	
	/**
	 * returns the names of all the rooms in the project
	 * @return the names of all the rooms in the project
	 */
	public String[] toStringArray() {
		String returnArray[] = new String[roomList.size()];
		for (int n=0; n<roomList.size(); n++) {
			returnArray[n] = roomList.get(n).getName();
		}
		return returnArray;
	}
	
	/**
	 * returns a list of materials usable in the project
	 * @return list of materials usable in the project
	 */
	public LinkedList<Material> getMaterialsList() {
		return materialsList;
	}
	
}