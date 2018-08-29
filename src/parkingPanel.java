
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class parkingPanel extends JPanel
{
	public Tile[][] grid;
	// position values for drawing items
	int gridXstart = 40;
	int gridYstart = 40;
	int gridBuffer = 3;
	int tileSize = 50;
	// positions for placing buttons
	Location buttonDrop = new Location(200,500);
	Location buttonRetrieve = new Location(240,500);
	// the buttons we will be using
	JButton drop = new JButton("Drop");
	JButton retrieve = new JButton("Retrieve");
	
	// color assignments
	private Color unknownColor = Color.red;
	private Color emptyColor = Color.black;
	private Color noCar = Color.gray;
	private Color oneColor = new Color(0,255,0); // brightest green
	private Color twoColor = new Color(0,150,20);
	private Color threeColor = new Color(0,100,0);
	private Color fourColor = new Color(0,43,0);// darkest green being used
	
	
	// Instantiate a parkingPanel with a 2-D array matrix
	public parkingPanel(Tile[][] a)
	{
		// set grid equal to the given 2-D array
		grid = a;
		addCosmetics();
	}
	public parkingPanel()
	{
		
	}
	
	// This is where everything will be drawn (This is ran automatically )
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);// call the super to handle the base aspects of paintComponent
		this.setBackground(Color.DARK_GRAY);
		
		// Lets paint the grid
		paintGrid(g);
	}
	
	public Location positionToPixels(int x, int y)
	{
		int pixelX = (gridXstart + (tileSize + gridBuffer)*x);
		int pixelY = (gridYstart + (tileSize + gridBuffer)*y);
		Location l = new Location( pixelX, pixelY);
		
		return l;
	}
	
	
	public void paintGrid(Graphics g)// call to print the grid;
	{
		g.setColor(Color.black);// Set the color of the background of the 
		g.fillRect(gridXstart-gridBuffer, gridYstart-gridBuffer, grid.length*(tileSize+gridBuffer)+gridBuffer, grid.length*(tileSize+gridBuffer)+gridBuffer);// draw the background  
		
		
		
		for(int x =0; x< grid.length; x++)
		{
			for(int y =0; y< grid.length; y++)
			{
				g.setColor(  getColor(x,y) );// set the color to the current tile.
				Location l = positionToPixels(x,y);
				g.fillRect(l.getX(), l.getY(), tileSize, tileSize);
			}
		}
		
	}
	public Color getColor(int x, int y)
	{
		Color r = noCar;
		Tile t = grid[x][y];
		if(t.getTime() == Tile.EMPTY)
		{
			return Color.black;
		}
		if(t.getTime() == Tile.ONE)
		{
			return oneColor;
		}
		else if(t.getTime() == Tile.TWO)
		{
			return twoColor;
		}
		else if(t.getTime() == Tile.THREE)
		{
			return threeColor;
		}
		else if(t.getTime() == Tile.UKNOWN)
		{
			return fourColor;
		}
		else if(t.getTime() == Tile.MARKED)
		{
			return Color.red;
		}
		else if(t.getTime() == Tile.NOTFILLED)
		{
			return r;// returns gray since no car is located here
		}
		return r;
	}
	public void addCosmetics()
	{
		JLabel lblNewLabel = new JLabel("High-Density Parking System");
		lblNewLabel.setBounds(50, 0, 250, 50);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		this.add(lblNewLabel);
	}
}

