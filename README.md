## Robot_Simulator
Welcome to my Robot Simulator!

Navigate to the src folder to compile and run the program. 

#Assumptions: 
1.  User will type commands in upper case e.g MOVE instead of Move, or move to be accepted by the program. 
2.  PLACE command is entered correctly with the right syntax, e.g PLACE *space* X,Y,Direction

#Test Data Coverage
The test data provided in .txt covers: 
1.  The edge cases for both x and y axis 
2.  Correct and fake commands being entered pre and post correct placement of the robot
3.  Correct placement of the robot
4.  Exit condition of the simulator
5.  Post-error position of the Robot, indicating it hasn't been altered by the error.
6.  Different direction outputs relative for the same turn commands(Left, Right) depending on initial direction
