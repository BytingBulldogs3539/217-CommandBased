package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseGearPos extends Command {

    public ReleaseGearPos() 
    {

    }

    protected void initialize() 
    {
    	Robot.Gearing.setGearPos(RobotMap.GearArmRelease);
    }


    protected void execute() 
    {
    	
    }

    protected boolean isFinished()
    {
    	return !Robot.OI.operButtonX.get();
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
