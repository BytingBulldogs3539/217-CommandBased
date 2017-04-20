package org.usfirst.frc.team217.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	LeftMaster = new CANTalon(0);
	LeftSlave = new CANTalon(1);
	RightMaster = new CANTalon(14);
	RightSlave = new CANTalon(15);
	
	leftMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	leftSlave.changeControlMode(TalonControlMode.Follower);	
	RightSlave.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	RightSlave.changeControlMode(TalonControlMode.Follower);
	
	
	
	
	
	
	
	
	
	
	
    public void initDefaultCommand() {
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
}

