public class Soldier {
    private String name;
    private int points;
    private int row;
    private int column;

    public void setName(String name) {
	this.name = name;
    }
    public void setPoints(int points){
	this.points = points;
    }
    public void setRow(int row){
	this.row = row;
    }
    public void setColumn(int column){
	this.column = column;
    }

    public String getName(){
	return name;
    }
    public int getPoints(){
	return points;
    }
    public int getRow(){
	return row;
    }
    public int getColumn(){
	return column;
    }
    
    @Override
    public String toString(){
	return ("\nName: " + name + "\nPoints: " + points + "\nRow: " + 
		row + "\nColumn: " + column + "\n");
    }
}
