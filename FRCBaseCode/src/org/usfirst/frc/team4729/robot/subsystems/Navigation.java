package org.usfirst.frc.team4729.robot.subsystems;

import org.usfirst.frc.team4729.robot.utils.Path;
import org.usfirst.frc.team4729.robot.utils.Point;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Navigation extends Subsystem {
	
	//variables
	Path points;
	String gameData;
	
    public void initDefaultCommand() {
    	
    }
    
    public void collectPoints() {
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			//Put left auto code here
			
		} else {
			//Put right auto code here
			
		}
}

