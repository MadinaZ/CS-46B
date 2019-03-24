package weather;

public class CirrusCloud extends Cloud{

	public CirrusCloud(float bottom, float top){
		super(bottom, top);
	}
	
	//Overrides the rain method from the cloud class
	public String rain(){
		return "I cannot make rain";
	}
}
