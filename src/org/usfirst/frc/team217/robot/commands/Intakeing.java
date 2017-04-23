package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intakeing extends Command {
	

    public Intakeing() 
    {
    	requires(Robot.Intake);
    }

    protected void initialize() 
    {
    	
    }
    protected void execute() 
    {
    	Robot.Intake.setIntakePower(Robot.OI.oper.getRawAxis(RobotMap.X_AxisR));
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    	Robot.Intake.setIntakePower(0);
    }

    protected void interrupted() 
    {
    	end();
    }
}
