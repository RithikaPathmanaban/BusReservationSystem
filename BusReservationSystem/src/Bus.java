
public class Bus {
	private int BusNo;
	private boolean AC;
	private int Capacity;
	Bus(int No,boolean AC,int Capacity){
		this.BusNo = No;
		this.AC = AC;
		this.Capacity = Capacity;
	}
	public int getBusNo() {
		return BusNo;
	}
	public boolean isAC() {
		return AC;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setAC(boolean val) {
		AC = val;
	}
	public void setCapacity(int cap) {
		Capacity = cap;
	}
	
}
