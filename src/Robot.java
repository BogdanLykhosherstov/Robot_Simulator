import java.util.Scanner;

public class Robot {
	//variable declaration and encapsulation
	public static boolean positionFlag = false;
	public  int x;
	public  int y;
	public  String direction;
	
	//Constructor
	public Robot(){	
	}
	//Move command
	public void move(){
		if(this.direction.equals("WEST")){
			if((this.x - 1)>=0){
				this.x-=1;
			}
			else{
				System.out.println("This move will cause the Robot to fall off the grid. Please try again.");
			}
			
		}
		else if(this.direction.equals("EAST")){
			if((this.x + 1)<=4){
				this.x+=1;
			}
			else{
				System.out.println("This move will cause the Robot to fall off the grid. Please try again.");
			}
			
		}
		else if(this.direction.equals("SOUTH")){
			if((this.y - 1)>=0){
				this.y-=1;
			}
			else{
				System.out.println("This move will cause the Robot to fall off the grid. Please try again.");
			}	
		}
		else if(this.direction.equals("NORTH")){
			if((this.y + 1)<=4){
				this.y+=1;
			}
			else{
				System.out.println("This move will cause the Robot to fall off the grid. Please try again.");
			}
			
		}
	}
	//Turn based on the direction given
	public void turn(String dir){
		if(dir.equals("LEFT"))
		{
			if(this.direction.equals("NORTH")){
				this.direction = "WEST";
			}
			else if(this.direction.equals("WEST")){
				this.direction = "SOUTH";
			}
			else if(this.direction.equals("SOUTH")){
				this.direction = "EAST";
			}
			else if(this.direction.equals("EAST")){
				this.direction = "NORTH";
			}
		}
		else if(dir.equals("RIGHT")){
			if(this.direction.equals("NORTH")){
				this.direction = "EAST";
			}
			else if(this.direction.equals("EAST")){
				this.direction = "SOUTH";
			}
			else if(this.direction.equals("SOUTH")){
				this.direction = "WEST";
			}
			else if(this.direction.equals("WEST")){
				this.direction = "NORTH";
			}
		}
		
	}
	//Places the robot onto the grid
	public void place(int x,int y, String pos){
		if(x>=0 && x<=4 && y>=0 && y<=4){
			this.x=x;
			this.y=y;
			this.direction = pos;
		}
		//Prompt error, set the position flag to false to prevent further commands, until another PLACE is given
		else{
			System.out.println("Error, placing Robot outside of the grid");
			positionFlag =false;
		}
	}
	//Report current state
	public void report(){
		System.out.println("Output: "+this.x+","+this.y+","+this.direction);
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Robot robot = new Robot();
		System.out.println("Welcome to Robot Traversal Simulation 1.0.\nEnter your commands below (-1 to quit): ");
		String command="";
		//Running command until the -1
		while(!(command.equals("-1"))){
			command =  scan.nextLine();
			//If command = PLACE, extract the values and input them accordingly
			if(command.contains("PLACE")){
				int x_new = Integer.parseInt(command.substring(6, 7));
				int y_new = Integer.parseInt(command.substring(8, 9));
				String direction_new = command.substring(10);
				
				//Now the robot has been positioned and initialized, so other commands may be performed
				positionFlag=true;
				robot.place(x_new, y_new, direction_new);
					
			}
			//Otherwise enter command as it is
			else if(!(command.equals("-1"))){
				//Don't take commands unless robot has been placed
				if(!positionFlag){
					System.out.println("Error, Robot must be placed first before commands are issued!");
				}
				//Move
				else if(command.equals("MOVE")){
					robot.move();
				}
				//Return report
				else if(command.equals("REPORT")){
					robot.report();
				}
				//Turn
				else{
					robot.turn(command);
				}
			}
		}
		//closing scan
		scan.close();
	}
}
