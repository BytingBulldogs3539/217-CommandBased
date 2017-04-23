package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearUp extends Command {

    public GearUp() 
    {
    	requires(Robot.Gearing);
    }

    protected void initialize() 
    {
    	Robot.Gearing.setGearPos(RobotMap.GearArmup);
    }

    protected void execute() 
    {
    	
    }

    protected boolean isFinished() 
    {
        return Robot.Gearing.onTarget();
    }
    
    protected void end() 
    {
    	Robot.Gearing.disableGearArmPID();
    }

    protected void interrupted() 
    {
    	end();
    }
}
