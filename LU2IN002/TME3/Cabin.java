public class Cabin{
	private int volume;
	private String color;
	public Cabin(int volume, String color){
		this.volume = volume;
		this.color = color;
	}
	public String toString(){
		return "volume: " + String.format("%d",this.volume) + "  color: " + this.color;
	}
	public void setColor(String color){
		this.color = color;
	}
	public String getColor(){
		return this.color;
	}
	public int getVolume(){
		return this.volume;
	}
}
