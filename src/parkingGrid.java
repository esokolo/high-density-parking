import java.util.ArrayList;

public class parkingGrid // the grid of parking
{
private int numberOfCars =0; // initialize it to zero.
private static int gridSize; // size of n of the NxN grid

Tile[] list = new Tile[64];// holds an array of 64 tiles, to be used to search the list of cars.
Tile[][] grid; // grid of tiles to manipulate

Location emptySpace = new Location(3,6);

// constructor.
public parkingGrid(int gSize)
{
	initGrid(gSize);
}

public void addCarToList(int ID)// add car to the array of Tiles in correct position
{
	// place a not filled tile at the entrance
	
	
	// fill the tile with the appropriate ID, Estimate time of departure
	
	
	//create a movement path for the tile.
	numberOfCars++;
}
public Tile returnCarTile(int ID)// will use a binarySearch to go through the sorted list of tiles and return the tile needed
{
	Tile r = new Tile();// empty tile that will be later assigned and returned.
	// given the ID, search through the regular arraylist of filled tiles for the position of the car needed
	
	
	//once you have found the appropriate tile, allow r to be equal to that tile
	return r;
}
public void swap(Tile a, Tile b)// will be used to swap an empty space with an actual tile
{
	int temp = a.getTime();
	grid[a.getX()][a.getY()].setTime(b.getTime());
	grid[b.getX()][b.getY()].setTime(temp);
	String temps = a.id;
	grid[a.getX()][a.getY()].id = b.id;
	grid[b.getX()][b.getY()].id = temps;
}
public void swap(Location d)// swaps the current EMPTY location with location b.
{
	Tile a = grid[emptySpace.getX()][emptySpace.getY()];
	Tile b = grid[d.getX()][d.getY()];
	
	int temp = a.getTime();
	grid[a.getX()][a.getY()].setTime(b.getTime());
	grid[b.getX()][b.getY()].setTime(temp);
	String temps = a.id;
	grid[a.getX()][a.getY()].id = b.id;
	grid[b.getX()][b.getY()].id = temps;
	int stamp = a.timeStamp;
	grid[a.getX()][a.getY()].timeStamp = b.timeStamp;
	grid[b.getX()][b.getY()].timeStamp = stamp;
	
	// swaps time value, swaps 
	emptySpace = d;
}
private void initGrid(int gSize)// creates a grid of "EMPTY"/"No Car" tiles.
{
	grid = new Tile[gSize][gSize];
	for(int x =0; x < gSize; x++)
	{
		for(int y =0; y< gSize; y++)
		{
			grid[x][y] = new Tile(x,y,Tile.EMPTY,Tile.NOTIME);// create a Tile at (X,Y) that is void of Car, and Time Slot (EMPTY TILE)
		}
	}
}
public Location firstNotFilled()
{
	Location temp = new Location(7,7);
	for(int y=0; y<8;y++)
	{
		for(int x=0;x<8;x++)
		{
			if(grid[x][y].getTime() == Tile.NOTFILLED)
			{
				return new Location(x,y);
			}
		}
	}
	return temp;
}
// tested and working ( EPath , 
public ArrayList<Location> EPath(Location current, Location desired)
{
	ArrayList<Location> r = new ArrayList<Location>();
	int cx = current.getX();
	int cy = current.getY();
	int dx = desired.getX();
	int dy = desired.getY();
	
	
	if(current.equals(desired))
	{
		return r;
	}
	// move along the X axis if the values don't match
	if( cx != dx )
	{
		if( cx < dx)
		{
			for(int x = cx+1; x <= dx; x++)
			{
				Location temp = new Location( x, cy);
				r.add(temp);
			}
			cx = dx;
		}
		else if(cx > dx)
		{
			for(int x = cx-1; x >= dx; x--)
			{
				Location temp = new Location( x, cy);
				r.add(temp);
			}
			cx = dx;
		}
	}
	if( cy != dy)
	{
		if( cy < dy)
		{
			for(int y = cy+1; y <= dy; y++)
			{
				Location temp = new Location( cx, y);
				r.add(temp);
			}
			cy = dy;
		}
		else if(cy > dy)
		{
			for(int y = cy-1; y >= dy; y--)
			{
				Location temp = new Location( cx, y);
				r.add(temp);
			}
			cy = dy;
		}
	}
	
	return r;
}
public ArrayList<Location> YPath(Location current, Location desired)
{
	ArrayList<Location> r = new ArrayList<Location>();
	int cx = current.getX();
	int cy = current.getY();
	int dx = desired.getX();
	int dy = desired.getY();
	
	
	if(current.equals(desired))
	{
		return r;
	}
	// move along the X axis if the values don't match
	if( cy != dy)
	{
		if( cy < dy)
		{
			for(int y = cy+1; y <= dy; y++)
			{
				Location temp = new Location( cx, y);
				r.add(temp);
			}
			cy = dy;
		}
		else if(cy > dy)
		{
			for(int y = cy-1; y >= dy; y--)
			{
				Location temp = new Location( cx, y);
				r.add(temp);
			}
			cy = dy;
		}
	}
	if( cx != dx )
	{
		if( cx < dx)
		{
			for(int x = cx+1; x <= dx; x++)
			{
				Location temp = new Location( x, cy);
				r.add(temp);
			}
			cx = dx;
		}
		else if(cx > dx)
		{
			for(int x = cx-1; x >= dx; x--)
			{
				Location temp = new Location( x, cy);
				r.add(temp);
			}
			cx = dx;
		}
	}
	
	return r;
}
public ArrayList<Location> HPath(Location current, Location desired, Location blocked)
{
	/* Notes
	HPath 1.1
	As of 4/6/2017 HPath works accordingly up to the functions of EPath, But Epath will still be used when there is
	no such need to check for blocked locations, and thus increasing effeciency with a reduction of comparisons
	
	HPath 1.2
	
	*/
	ArrayList<Location> r = new ArrayList<Location>();
	int cx = current.getX();
	int cy = current.getY();
	int dx = desired.getX();
	int dy = desired.getY();
	
	
	if(current.equals(desired))
	{
		return r;
	}
	// move along the X axis if the values don't match
	if( cx != dx )
	{
		if( cx < dx)
		{
			for(int x = cx+1; x <= dx; x++)
			{
				Location temp = new Location( x, cy);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(x-1,cy).UP();
					Location temp3 = new Location(x-1,cy).DOWN();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,HPath(temp2,desired,blocked));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,HPath(temp3,desired,blocked));
					}
				}
				r.add(temp);
			}
			cx = dx;
		}
		else if(cx > dx)
		{
			for(int x = cx-1; x >= dx; x--)
			{
				Location temp = new Location( x, cy);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(x+1,cy).UP();
					Location temp3 = new Location(x+1,cy).DOWN();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,HPath(temp2,desired,blocked));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,HPath(temp3,desired,blocked));
					}
				}
				r.add(temp);
			}
			cx = dx;
		}
	}
	if( cy != dy)
	{
		if( cy < dy)
		{
			for(int y = cy+1; y <= dy; y++)
			{
				Location temp = new Location( cx, y);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(cx,y-1).RIGHT();
					Location temp3 = new Location(cx,y-1).LEFT();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,YHPath(temp2,desired,blocked));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,YHPath(temp3,desired,blocked));
					}
				}
				r.add(temp);
			}
			cy = dy;
		}
		else if(cy > dy)
		{
			for(int y = cy-1; y >= dy; y--)
			{
				Location temp = new Location( cx, y);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(cx,y+1).RIGHT();
					Location temp3 = new Location(cx,y+1).LEFT();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,YPath(temp2,desired));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,YPath(temp3,desired));
					}
				}
				r.add(temp);
			}
			cy = dy;
		}
	}
	
	return r;
}
public ArrayList<Location> YHPath(Location current,Location desired,Location blocked)
{
	ArrayList<Location> r = new ArrayList<Location>();
	int cx = current.getX();
	int cy = current.getY();
	int dx = desired.getX();
	int dy = desired.getY();
	
	
	if(current.equals(desired))
	{
		return r;
	}
	// move along the X axis if the values don't match
	if( cy != dy)
	{
		if( cy < dy)
		{
			for(int y = cy+1; y <= dy; y++)
			{
				Location temp = new Location( cx, y);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(cx,y-1).RIGHT();
					Location temp3 = new Location(cx,y-1).LEFT();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,YPath(temp2,desired));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,YPath(temp3,desired));
					}
				}
				r.add(temp);
			}
			cy = dy;
		}
		else if(cy > dy)
		{
			for(int y = cy-1; y >= dy; y--)
			{
				Location temp = new Location( cx, y);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(cx,y+1).RIGHT();
					Location temp3 = new Location(cx,y+1).LEFT();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,YPath(temp2,desired));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,YPath(temp3,desired));
					}
				}
				r.add(temp);
			}
			cy = dy;
		}
	}
	if( cx != dx )
	{
		if( cx < dx)
		{
			for(int x = cx+1; x <= dx; x++)
			{
				Location temp = new Location( x, cy);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(x-1,cy).UP();
					Location temp3 = new Location(x-1,cy).DOWN();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,HPath(temp2,desired,blocked));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,HPath(temp3,desired,blocked));
					}
				}
				r.add(temp);
			}
			cx = dx;
		}
		else if(cx > dx)
		{
			for(int x = cx-1; x >= dx; x--)
			{
				Location temp = new Location( x, cy);
				if(temp.equals(blocked))
				{
					Location temp2 = new Location(x+1,cy).UP();
					Location temp3 = new Location(x+1,cy).DOWN();
					if(inBounds(temp2))
					{
						r.add(temp2);
						return merge(r,HPath(temp2,desired,blocked));
					}
					else if(inBounds(temp3))
					{
						r.add(temp3);
						return merge(r,HPath(temp3,desired,blocked));
					}
				}
				r.add(temp);
			}
			cx = dx;
		}
	}
	
	return r;
}


public ArrayList<Location> FullPath(Location T1, Location T2)
{
	ArrayList<Location> full = new ArrayList<Location>();
	
	ArrayList<Location> simplePath = EPath(T1, T2);// The path of steps needed to move A to B, technically
	
	Location empty = emptySpace;
	
	
	while(simplePath.size() > 0)// while we still have stuff in the path continue to 
	{
		// move from the current empty space, to the first position needed to be swapped
		ArrayList<Location> List = HPath(empty,simplePath.get(0),T1);
		// swap that position with the currentEmpty spot
		empty = T1;
		if(simplePath.size()-1 >= 0)
		{
			T1 = simplePath.get(0);	
		}
		List.add(empty);
		
		simplePath.remove(0);
		
		full = merge(full,List);
	}
	return full;
}

public ArrayList<Location> Clockwise(Location current, Location desired, Location blocked)
{
	Location up = current.UP();
	Location down = current.DOWN();
	Location right = current.RIGHT();
	Location left = current.LEFT();
	ArrayList<Location> r = new ArrayList<Location>();
	//else if desired is above
	if( desired.above(current))
	{
		if(inBounds(left))// if we can circle around left do so
		{
			if(left.equals(blocked))//check to see if not directly above
			{
				r.add(up);
				return merge(r, HPath(up, desired, blocked));
			}
			Location a = left.UP();
			Location b = left.UP().UP();
			Location c = left.UP().UP().RIGHT();
			
			r.add(left);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c,desired));
		}
		else if(inBounds(right))// else if we can circle around right do so.
		{
			if(right.equals(blocked)) // special case
			{
				r.add(up);
				return merge(r, HPath(up, desired, blocked));
			}
			Location a = right.UP();
			Location b = right.UP().UP();
			Location c = right.UP().UP().LEFT();
			
			r.add(right);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c,desired));
		}
	}
	// desired is below
	else if( desired.below(current))
	{
		if(inBounds(left))// if we can circle around left do so
		{
			if(left.equals(blocked)) // special case
			{
				r.add(down);
				return merge(r, HPath(down, desired, blocked));
			}
			Location a = left.DOWN();
			Location b = left.DOWN().DOWN();
			Location c = left.DOWN().DOWN().RIGHT();
			
			r.add(left);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c,desired));
		}
		else if(inBounds(right))// else if we can circle around right do so.
		{
			if(right.equals(blocked)) // special case
			{
				r.add(down);
				return merge(r, HPath(down, desired, blocked));
			}
			Location a = right.DOWN();
			Location b = right.DOWN().DOWN();
			Location c = right.DOWN().DOWN().LEFT();
			
			r.add(right);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c,desired));
		}
	}
	//else if desired is right
	else if( desired.toRight(current))
	{
		if(inBounds(down))
		{
			if(down.equals(blocked)) // special case
			{
				r.add(right);
				return merge(r, HPath(right, desired, blocked));
			}
			Location a = down.RIGHT();
			Location b = down.RIGHT().RIGHT();
			Location c = down.RIGHT().RIGHT().UP();
			
			r.add(down);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c, desired));
		}
		else if(inBounds(up))
		{
			if(up.equals(blocked)) // special case
			{
				r.add(right);
				return merge(r, HPath(right, desired, blocked));
			}
			Location a = up.RIGHT();
			Location b = up.RIGHT().RIGHT();
			Location c = up.RIGHT().RIGHT().DOWN();
			
			r.add(up);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c, desired));
		}
	}
	//else if desired is left
	else if( desired.toLeft(current))
	{
		if(inBounds(down))
		{
			if(down.equals(blocked)) // special case
			{
				r.add(left);
				return merge(r, HPath(left, desired, blocked));
			}
			Location a = down.LEFT();
			Location b = down.LEFT().LEFT();
			Location c = down.LEFT().LEFT().UP();
			
			r.add(down);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c, desired));
		}
		else if(inBounds(up))
		{
			if(up.equals(blocked)) // special case
			{
				r.add(left);
				return merge(r, HPath(left, desired, blocked));
			}
			Location a = up.LEFT();
			Location b = up.LEFT().LEFT();
			Location c = up.LEFT().LEFT().DOWN();
			
			r.add(up);
			r.add(a);
			r.add(b);
			r.add(c);
			
			return merge( r, EPath(c, desired));
		}
	}
	
	return r;
}
public ArrayList<Location> HClockwise(Location current, Location desired, Location blocked)
{
	ArrayList<Location> ret = new ArrayList<Location>();
	///////////////////////Desired is Below/////////////////////////////////////////////
	if(desired.below(current) && desired.toRight(current))
	{// if Down right
		return Cycle(current,desired,blocked,-2);
	}
	else if( desired.below(current) && desired.toLeft(current))
	{// if Down left
		return Cycle(current,desired,blocked,2);
	}
	else if( desired.below(current))
	{// if double down
		if( inBounds(current.LEFT()) )
		{
			return Cycle(current,desired,blocked,-4);
		}
		else
		{
			return Cycle(current,desired,blocked,4);
		}
	}
	
	/////////////////////ABOVE//////////////////////////////////////////////////
	if(desired.above(current) && desired.toRight(current))
	{
		return Cycle(current,desired,blocked,-2);
	}
	else if( desired.above(current) && desired.toLeft(current))
	{
		return Cycle(current,desired,blocked,2);
	}
	else if( desired.above(current))
	{
		if( inBounds(current.RIGHT()) )
		{
			return Cycle(current,desired,blocked,-4);
		}
		else
		{
			return Cycle(current,desired,blocked,4);
		}
	}
	////////////////////////Desired is Left//////////////////////////////////
	if(desired.toLeft(current) && desired.above(current))
	{// if left above
		return Cycle(current,desired,blocked,-2);
	}
	else if( desired.toLeft(current) && desired.below(current))
	{// if left down
		return Cycle(current,desired,blocked,2);
	}
	else if( desired.toLeft(current))
	{// if double left
		if( inBounds(current.DOWN() ) )
		{
			return Cycle(current,desired,blocked,4);
		}
		else
		{
			return Cycle(current,desired,blocked,-4);
		}
	}
	///////////////////////////Desire is Right///////////////////////////////////////////
	if(desired.toRight(current) && desired.above(current))
	{// 
		return Cycle(current,desired,blocked,-2);
	}
	else if( desired.toRight(current) && desired.below(current))
	{
		return Cycle(current,desired,blocked,2);
	}
	else if( desired.toRight(current))
	{
		if( inBounds(current.UP()))
		{
			return Cycle(current,desired,blocked,-4);
		}
		else
		{
			return Cycle(current,desired,blocked,4);
		}
	}
	return ret;
}
public ArrayList<Location> Cycle(Location current, Location desired, Location blocked,int value)
{
	    Location up = current.UP();
		Location down = current.DOWN();
		Location right = current.RIGHT();
		Location left = current.LEFT();
		ArrayList<Location> r = new ArrayList<Location>();
		int indexOfCurrent =0;
		Location s[] = {blocked.UP(),blocked.UP().RIGHT(),blocked.RIGHT(),blocked.RIGHT().DOWN(),blocked.DOWN(),blocked.DOWN().LEFT(),blocked.LEFT(),blocked.LEFT().UP()};
		
		// find your index
		for(int i =0; i<s.length;i++)
		{
			if(s[i].equals(current))
			{
				indexOfCurrent = i;
			}
		}
		// go through and add all the clockwise positions needed.
		for(int z =1; z<=Math.abs(value); z++)
		{
			if(value > 0)// if were moving around left
			{
			indexOfCurrent++;
			Location add = s[(indexOfCurrent)%s.length];
			r.add( add );
			}
			else if(value < 0)// if were moving right.
			{
			indexOfCurrent--;
			if(indexOfCurrent < 0)
			{
				indexOfCurrent = s.length-1;
			}
			Location add = s[indexOfCurrent];
			r.add( add );
			}
		}
		return merge(r, HPath(r.get(r.size()-1),blocked, desired));
}
public void moveEmptyX()
{
	if( inBounds(emptySpace.UP() ) )
	{
		emptySpace = emptySpace.UP();
	}
	if( inBounds(emptySpace.UP() ) )
	{
		emptySpace = emptySpace.UP();
	}
}
public void moveEmptyY()
{
	if( inBounds(emptySpace.RIGHT() ) )
	{
		emptySpace = emptySpace.RIGHT();
	}
	if( inBounds(emptySpace.LEFT() ) )
	{
		emptySpace = emptySpace.LEFT();
	}
}
public void fillRandomly()
{
	for(int x =0; x < 8; x++ )
	{
		for(int y=0; y<8; y++)
		{
			int ran = (int) (Math.random()*4);
			Tile t = new Tile(x,y,0,ran);
			grid[x][y] = t;
		}
	}
	int ranX = (int) (Math.random()*4);
	int ranY = (int) (Math.random()*4);
	grid[ranX][ranY].setTime(-1);
}

public void fillSystem()
{
	for(int x =0; x < 8; x++ )
	{
		for(int y=0; y<8; y++)
		{
			int value = y*8+x;
			if( value < 10)
			{
				Tile t = new Tile(x,y,0,Tile.UKNOWN);
				grid[x][y] = t;
			}
			else if( value >= 10 && value < 20)
			{
				int ran = (int) (Math.random()*2+2);
				Tile t = new Tile(x,y,0,ran);
				grid[x][y] = t;
			}
			else if( value >= 20 && value < 38)
			{
				int ran = (int) (Math.random()*2+1);
				Tile t = new Tile(x,y,0,ran);
				grid[x][y] = t;
			}
			else if( value >= 38 && value < 48)
			{
				int ran = (int) (Math.random()*2);
				Tile t = new Tile(x,y,0,ran);
				grid[x][y] = t;
			}
			else if( value >=48)
			{
				Tile t = new Tile(x,y,0,Tile.NOTFILLED);
				grid[x][y] = t;
			}
		}
	}
	grid[3][6] = new Tile(3,6,0,Tile.EMPTY);
}

public int numberOfUnfilled()
{
	int r =0;
	for(int y =0; y < 8; y++ )
	{
		for(int x=0; x<8; x++)
		{
			if(grid[x][y].getTime() == Tile.NOTFILLED)
			{
				r++;
			}
		}
	}
	return r;
}
public Location placementSpot(Location entry)
{
	Location end = new Location(0,0);
	
	int timeEntry = grid[entry.getX()][entry.getY()].getTime();
	for(int y =0; y < 8; y++ )
	{
		for(int x=0; x< 8; x++)
		{
			int cTime = grid[x][y].getTime();
			if(cTime != Tile.EMPTY)
			{
				if( timeEntry > cTime)
				{
					return new Location(x,y);
				}
			}
		}
	}
	return end;
}
public Location correctionSpot(Location entry)
{
	int ex = entry.getX();
	int ey = entry.getY();
	int id = 0;
	int Time = grid[ex][ey].getTime();
	
	Tile t = new Tile(ex,ey,id,Time);
	Location temp = new Location(1,4);
	for(int y =0; y < 8; y++ )
	{
		for(int x=0; x<8; x++)
		{
			if( Time < grid[x][y].getTime())
			{
				return new Location(x,y);
			}
		}
	}
	return temp;
}

public Location markTile(String s)
{
	Location ret = new Location(-1,-1);
	if(s.length()>0)
	{
	for(int y =0; y < 8; y++ )
	{
		for(int x=0; x<8; x++)
		{
			if(grid[x][y].is(s))
			{
				grid[x][y].setTime(Tile.MARKED);
				return new Location(x,y);
			}
		}
	}
	}
	return ret;
}
public boolean inBounds(Location l)
{
	if(l.getX() < 8 && l.getX() >= 0 && l.getY() < 8 && l.getY() >=0)
	{
		return true;
	}
	return false;
}
public ArrayList<Location> merge(ArrayList<Location> a, ArrayList<Location> b)
{
	for(int i =0; i <= b.size()-1;i++)
	{
		a.add(b.get(i));
	}
	return a;
}
public ArrayList<Location> sortingMoves()
{
	ArrayList<Location> ret = new ArrayList<Location>();
	
	
	for(int y=3; y<8;y++)
	{
		for(int x=0; x<8;x++)
		{
			Location c = new Location(x,y);
			if(inBounds(c.LEFT()) && inBounds(c.LEFT())  )
			{
				int thisColor = grid[x][y].getTime();
				int rightColor = grid[x+1][y].getTime();
				int leftColor = grid[x-1][y].getTime();
				if( thisColor != rightColor || thisColor != leftColor  )
				{
					return FullPath(new Location(x,y), placementSpot(new Location(x,y)) );
				}
			}
			
		}
	}
	return ret;
}
}// end class



/*
 * 
 * Location up = current.UP();
	Location down = current.DOWN();
	Location right = current.RIGHT();
	Location left = current.LEFT();
	ArrayList<Location> r = new ArrayList<Location>();
	int indexOfCurrent =0;
	Location s[] = {blocked.UP(),blocked.UP().RIGHT(),blocked.RIGHT(),blocked.RIGHT().DOWN(),blocked.DOWN(),blocked.DOWN().LEFT(),blocked.LEFT(),blocked.LEFT().UP()};
	
	// find your index
	for(int i =0; i<s.length;i++)
	{
		if(s[i].equals(current))
		{
			indexOfCurrent = i;
		}
	}
	for(int z =1; z<5; z++)
	{
		Location add = s[(indexOfCurrent+z)%s.length];
		r.add( add );
	}
	return merge(r, HPath(r.get(r.size()-1),blocked, desired));
 */



