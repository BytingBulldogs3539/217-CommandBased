package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;
import org.usfirst.frc.team217.robot.commands.DriveCommand;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	CANTalon RBMotor,LBMotor,RFMotor,LFMotor;

	public DriveTrain()
	{
		super("DriveTrain");
		
		RBMotor = new CANTalon(RobotMap.RBMotor);
		RFMotor = new CANTalon(RobotMap.RFMotor);
		LBMotor = new CANTalon(RobotMap.LBMotor);
		LFMotor = new CANTalon(RobotMap.LFMotor);
		
		RFMotor.changeControlMode(TalonControlMode.Follower);
		LFMotor.changeControlMode(TalonControlMode.Follower);
		
		RBMotor.changeControlMode(TalonControlMode.PercentVbus);
		LBMotor.changeControlMode(TalonControlMode.PercentVbus);
		
		RBMotor.configMaxOutputVoltage(12);
		LBMotor.configMaxOutputVoltage(12);
		
		RBMotor.set(RFMotor.getDeviceID());
		LBMotor.set(LFMotor.getDeviceID());
		
		RBMotor.EnableCurrentLimit(true);
		LBMotor.EnableCurrentLimit(true);
	}

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new DriveCommand());
    }
    
    
    public void Update()
    {
    	//SmartDashboard.putDouble("EX", EX)
    	
    }
    public void SmartInit()
    {
    	
    }
}

