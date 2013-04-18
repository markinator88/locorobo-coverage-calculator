import java.util.*;

public class Room {
	private String roomName = new String("new room");
	private ArrayList<Surface> surfaceList = new ArrayList<Surface>();
	
	public void addSurface(Surface s) {
		surfaceList.add(s);
	}
	public void replaceSurface(int index, Surface modifiedSurface) {
		surfaceList.set(index, modifiedSurface);
	}
	public void deleteSurface(int index) {
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
}
