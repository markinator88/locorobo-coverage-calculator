import java.util.*;

public class Room {
	private String roomName;
	private ArrayList<Surface> surfaceList = new ArrayList<Surface>();
	
	Room() {
		roomName = new String("new room");
	}
	Room(Room r) { // copy constructor
		this.roomName = new String(r.getName());
		this.surfaceList = new ArrayList<Surface>();
		for (Surface surface : surfaceList) {
			this.surfaceList.add(new Surface(surface));
		}
	}
	public void addSurface(Surface s) {
		surfaceList.add(s);
	}
	public void replaceSurface(int index, Surface modifiedSurface) {
		surfaceList.set(index, modifiedSurface);
	}
	public void removeSurface(int index) {
		surfaceList.remove(index);
	}
	public Surface getSurfaceAtIndex(int index) {
		return surfaceList.get(index);
	}
	public int getListSize() {
		return surfaceList.size();
	}
	public void setName(String s) {
		roomName = s;
	}
	public String getName() {
		return roomName;
	}
	public ArrayList<Surface> getSurfaceList() {
		return (ArrayList<Surface>)surfaceList.clone();
	}
	public String[] toStringArray() {
		String returnArray[] = new String[surfaceList.size()];
		for (int n=0; n<surfaceList.size(); n++) {
			returnArray[n] = surfaceList.get(n).getName();
		}
		return returnArray;
	}
}