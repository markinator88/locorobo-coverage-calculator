import java.util.*;

public class Room {
	private String roomName = new String("new room");
	private ArrayList surfaceList = new ArrayList();
	
	public void addSurface(Surface s) {
		surfaceList.add(s);
	}
	public void replaceSurface(int index, Surface modifiedSurface){
		surfaceList.set(index, modifiedSurface);
			
	}
	public void removeSurface(int index){
		surfaceList.remove(index);
	}
	public Surface getSurfaceAtIndex(int index){
		return (Surface) surfaceList.get(index);
		
	}
	public void setName(String n) {
		roomName = n;
		
	}
	public String getName(){
		return roomName;
	}

}