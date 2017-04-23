package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;
import org.usfirst.frc.team217.robot.commands.Intakeing;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	CANTalon Intake;
	Solenoid Ballz;
	public Intake()
	{
		Intake = new CANTalon(RobotMap.Intake);
		Ballz = new Solenoid(4);
	}
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new Intakeing());
    }
    public void BallzUp()
    {
    	Ballz.set(true);
    }
    public void BallzDown()
    {
    	Ballz.set(false);
    }
    public void setIntakePower(double Power)
    {
    	Intake.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	Intake.set(Power);
    	
    }
}

