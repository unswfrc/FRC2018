package org.usfirst.frc.team4729.robot.subsystems;

import org.usfirst.frc.team4729.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	TalonSRX leftFrontDrive = new TalonSRX(1);
	TalonSRX leftBackDrive = new TalonSRX(2);
	TalonSRX rightFrontDrive = new TalonSRX(3);
	TalonSRX rightBackDrive = new TalonSRX(4);
	
	double leftSpeed = 0;
	double rightSpeed = 0;
	double turnSpeed = 0;
	double forwardSpeed = 0;
	
	double acceleration = 0.05;
	double speed = 1;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void arcade(double desiredMove, double desiredTurn) {
    	if ((desiredMove < 0.1) && (desiredMove > -0.1)){
    		desiredMove = 0;
    		forwardSpeed = 0;
    	}
    	if ((desiredTurn < 0.1) && (desiredTurn > -0.1)){
    		desiredTurn = 0;
    		turnSpeed = 0;
    	}
    	
    	if  (((desiredMove > 0) && (forwardSpeed < 0)) || ((desiredMove < 0) && (forwardSpeed > 0))){
    		forwardSpeed = 0;
    	}
    	if (((desiredTurn > 0) && (turnSpeed < 0)) || ((desiredTurn < 0) && (turnSpeed > 0))){
    		turnSpeed = 0;
    	}
    	
    	if (Math.abs(desiredMove) < Math.abs(forwardSpeed)){
    		forwardSpeed = desiredMove;
    	}
    	
    	if (Math.abs(desiredTurn) < Math.abs(turnSpeed)) {
    		turnSpeed = desiredTurn;
    	}
    	
    	turnSpeed += (desiredTurn-turnSpeed)*acceleration;
    	forwardSpeed += (desiredMove-forwardSpeed)*acceleration;
    	
    	SmartDashboard.putString("#2", "Setting values");
    	
    	leftFrontDrive.set(forwardSpeed*speed - turnSpeed*speed);
    	leftBackDrive.set(forwardSpeed*speed - turnSpeed*speed);
    	rightFrontDrive.set(forwardSpeed*speed + turnSpeed*speed);
    	rightBackDrive.set(forwardSpeed*speed + turnSpeed*speed);
    }
    
    
    
    public void tank (double desiredLeft, double desiredRight) {
    	if ((desiredLeft < 0.1) && (desiredLeft > -0.1)){
    		desiredLeft = 0;
    		leftSpeed = 0;
    	}
    	if ((desiredRight < 0.1) && (desiredRight > -0.1)){
    		desiredRight = 0;
    		rightSpeed = 0;
    	}
    	
    	if  (((desiredLeft > 0) && (leftSpeed < 0)) || ((desiredLeft < 0) && (leftSpeed > 0))){
    		leftSpeed = 0;
    	}
    	if (((desiredRight > 0) && (rightSpeed < 0)) || ((desiredRight < 0) && (rightSpeed > 0))){
    		rightSpeed = 0;
    	}
    	
    	if (Math.abs(desiredLeft) < Math.abs(leftSpeed)){
    		leftSpeed = desiredLeft;
    	}
    	
    	if (Math.abs(desiredRight) < Math.abs(rightSpeed)) {
    		rightSpeed = desiredRight;
    	}
    	rightSpeed += (desiredRight-rightSpeed)*acceleration;
    	leftSpeed += (desiredLeft-leftSpeed)*acceleration;
    	
    	leftFrontDrive.set(leftSpeed*speed);
    	leftBackDrive.set(leftSpeed*speed);
    	rightFrontDrive.set(rightSpeed*speed);
    	rightBackDrive.set(rightSpeed*speed);
	}
    
}

