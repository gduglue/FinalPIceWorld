import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class IsometricTile extends JComponent{

	private int scrX = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int scrY = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int col, row, width, height;
	private Point start;
	private Polygon p;
	private Boolean target;
	
	public IsometricTile (int col, int row) {
		this.col = col;
		this.row = row;
		target = false ;

		width = scrX/250;
     	height = scrY/250;
        start = new Point (scrX/2,height+(scrY-height*241)/2);
        
    	int originLine = start.x - col*width ; 
    	int originRow = start.y + col*height;
    	int[] px = {originLine + width*row, originLine + width*(row+1), originLine+ width*row, originLine + width*(row-1) };
        int[] py = { originRow + height*(row-1), originRow + height*row, originRow + height*(row+1), originRow + height*row };
        p = new Polygon(px, py, 4);
        
	}
	
    


    public void paintComponent(Graphics g) {
        		

                
             
                
                g.setColor(Color.BLACK);
        		g.drawPolygon(p);
        		 g.setColor(Color.YELLOW);
         		g.fillPolygon(p);
         		
         	   if (target){
                   g.setColor(Color.BLUE);
                   g.fillPolygon(p);
                   }
            }
    
    public int getLine () {
    	return col;
    }
    
    public int getRow () {
    	return row;
    }
    
    
    public boolean contains ( Point point) {
    	return p.contains(point);
    }

    public void setHighlighted (boolean t) {
    	this.target = t;
    }
    
    }