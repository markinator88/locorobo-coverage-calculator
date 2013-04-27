import java.util.*;
/**
 * used to store and modify data describing a room
 */
public class Room {
	private String roomName;
	private ArrayList<Surface> surfaceList = new ArrayList<Surface>();
	//private String surfaceType; 
	
	
	/*public String getSurfaceType() {
		return surfaceType;
	}
	public void setSurfaceType(String surfaceType) {
		this.surfaceType = surfaceType;
	}*/
	/**
	 * returns the name of the room
	 * @return name of the room
	 */
	public String getRoomName() {
		return roomName;
	}
	
	/**
	 * sets the name of the room
	 * @param roomName name of the room
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * sets the list of surfaces in this room
	 * @param surfaceList list of surfaces
	 */
	public void setSurfaceList(ArrayList<Surface> surfaceList) {
		this.surfaceList = surfaceList;
	}
	/**
	 * creates a new room with no surfaces
	 */
	Room() {
		roomName = new String("new room");
	}
	/**
	 * creates a copy of a room
	 * @param r the room to be copied
	 */
	Room(Room r) {
		this.roomName = new String(r.getName());
		this.surfaceList = new ArrayList<Surface>();
		for (Surface surface : surfaceList) {
			this.surfaceList.add(new Surface(surface));
		}
	}
	/**
	 * add a surface to the room
	 * @param s surface to be added
	 */
	public void addSurface(Surface s) {
		surfaceList.add(s);
	}
	
	/**
	 * replaces a surface in the room
	 * @param index surface to be replaced
	 * @param modifiedSurface replacement surface
	 */
	public void replaceSurface(int index, Surface modifiedSurface) {
		surfaceList.set(index, modifiedSurface);
	}
	
	/**
	 * remove a surface in the room
	 * @param index of room to be removed
	 */
	public void removeSurface(int index) {
		surfaceList.remove(index);
	}
	
	/**
	 * returns the specified surface
	 * @param index of surface to be returned
	 * @return specified surface
	 */
	public Surface getSurfaceAtIndex(int index) {
		return surfaceList.get(index);
	}
	
	/**
	 * returns the number of surfaces in the room
	 * @return number of surfaces in the room
	 */
	public int getListSize() {
		return surfaceList.size();
	}
	
	/**
	 * sets the name of the room
	 * @param s name of the room
	 */
	public void setName(String s) {
		roomName = s;
	}
	
	/**
	 * returns the name of the room
	 * @return name of the room
	 */
	public String getName() {
		return roomName;
	}
	
	/**
	 * returns the list of surfaces in the room
	 * @return list of surfaces in the room
	 */
	public ArrayList<Surface> getSurfaceList() {
		return (ArrayList<Surface>)surfaceList.clone();
	}
	
	/**
	 * returns all the names of the surfaces
	 * @return all the names of the surfaces
	 */
	public String[] toStringArray() {
		String returnArray[] = new String[surfaceList.size()];
		for (int n=0; n<surfaceList.size(); n++) {
			returnArray[n] = surfaceList.get(n).getName();
		}
		return returnArray;
	}
}