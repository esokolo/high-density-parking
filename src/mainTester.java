import java.util.ArrayList;

public class mainTester 
{
private static int gridSize = 8;
static parkingGrid p = new parkingGrid(gridSize);
static ArrayList<Location> a = new ArrayList<Location>();

public static void main(String args[])
{
	Location T1 = new Location(3,7);
	Location T2 = new Location(3,5);
	Location current = new Location(2,2);
	Location desired = new Location(2,0);
	Location blocked = new Location(2,1);
	a = p.FullPath(T1, T2);
	//a = p.HPath(current, desired, blocked);
	//a = p.EPath(T1, T2);
	
	printA();
	current = new Location(1,5);
	desired = new Location (1,7);
	a= p.EPath(T1, T2);
	a = p.HPath(new Location(3,6), new Location(3,4), new Location(3,5));
	printA();
}

public static void printA()
{
	for(int i =0; i<a.size(); i++)
	{
		System.out.print( a.get(i) );
	}
	System.out.println();
}

}