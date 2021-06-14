package utt.xjy_szy.lo02_projet.game;

/**
 * 
 * The class of Card, the properties are: color, shape, solid/hollow, card ID, and coordinates
 * @author Jiayin XU
 * @author Zhengyang SU
 */
public class Card {
	private Color c;
	private Shape s;
	private Filled f;
	private int Id;
	private int x;
	private int y;
	
	/**
	 * The constructor of Card with parameters.
	 * @param c color of card
	 * @param s shape of card
	 * @param f filled statu of card
	 * @param id ID of card
	 */
	public Card(Color c, Shape s, Filled f, int id) {
		this.c = c;
		this.s = s;
		this.f = f;
		this.Id = id;
	}
	

	/**
	 * @return the color of card
	 */
	public Color getC() {
		return c;
	}
	
	/**
	 * @param c the color of card
	 */
	public void setC(Color c) {
		this.c = c;
	}
	
	/**
	 * @return the shape of card
	 */
	public Shape getS() {
		return s;
	}
	
	/**
	 * @param s the shape of card
	 */
	public void setS(Shape s) {
		this.s = s;
	}

	/**
	 * @return the ID of card
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the ID of card
	 */
	public void setId(int id) {
		this.Id = id;
	}

	/**
	 * @return the filled statu of card
	 */
	public Filled getF() {
		return f;
	}

	/**
	 * @param f the filled statu of card
	 */
	public void setF(Filled f) {
		this.f = f;
	}
	
	/**
	 * @return the coordinate x of card
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the coordinate x of card
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the coordinate y of card
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the coordinate y of card
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return the path of image of a card
	 */
	public String getPath() {
		StringBuffer sb = new StringBuffer();
		sb.append("/Image/");
		sb.append(getId() + ".png");
		return sb.toString();
	}



	/**
	 * print the description of card
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id:" + Id);
		
		switch(c) {
		case red:
			sb.append(" Color:red");
			break;
		case green:
			sb.append(" Color:green");
			break;
		case blue:
			sb.append(" Color:blue");
			break;
		}
		
		switch(s) {
		case triangle:
			sb.append(" Shape:triangle");
			break;
		case circle:
			sb.append(" Shape:circle");	
			break;
		case square:
			sb.append(" Shape:square");
			break;
		}
		
		switch(f) {
		case hollow:
			sb.append(" Filled:hollow");
			break;
		case solid:
			sb.append(" Filled:solid");
			break;
		}
		
		return sb.toString();
	}
	
	
	
}
/**
 * 
 * @author Jiayin XU
 * @author Zhengyang SU
 *
 */
enum Color{
	red,green,blue
	
}
/**
 * 
 * @author Jiayin XU
 * @author Zhengyang SU
 *
 */
enum Shape{
	triangle,circle,square
}
/**
 * 
 * @author Jiayin XU
 * @author Zhengyang SU
 *
 */
enum Filled{
	hollow,solid
}



