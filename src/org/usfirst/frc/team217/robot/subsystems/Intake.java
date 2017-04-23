package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;
import org.usfirst.frc.team217.robot.commands.Intakeing;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	CANTalon Intake;
	public Intake()
	{
		Intake = new CANTalon(RobotMap.Intake);
	}
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new Intakeing());
    }
    public void setIntakePower(double Power)
    {
    	Intake.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	Intake.set(Power);
    	
    }
}

