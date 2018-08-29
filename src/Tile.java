
public class Tile 
{
// The amount of TIME car will be present for, represented as integers
public static final int ONE =1, TWO = 2,  THREE =3, UKNOWN = 4 ,NOTFILLED = 0, MARKED = 450;
public static final int EMPTY = -1;// Empty space TIME
public static final int NOTIME = -2;//no car present so no time can be assigned.


public Location position;
private int ID;// literally won't be used, but is placed to avoid error's
private int time; // -2 if there is no time.
public int timeStamp; // will have values between 0 -> 2399
public String id = ""; // if size =0 then the Tile has no car.
private boolean DNE = false;
public String name;
public Tile()
{
	
}
public Tile( int x, int y, int ID, int time)//constructor for Tile.
{
	position = new Location(x,y);
	this.ID = ID;
	this.time = time;
	
	// testing
}

public int getX()
{
	return position.getX();
}
public int getY()
{
	return position.getY();
}
//getters and setters for time.
public int getTime()
{
	return this.time;
}
public void setTime(int time) 
{
	this.time = time;
}
public boolean is(String s)
{
	if( this.id != null && this.id.equals(s))
	{
		return true;
	}
	return false;
}

}
