package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearDown extends Command {

    public GearDown() 
    {
    	requires(Robot.Gearing);
    }

    protected void initialize() 
    {
    	Robot.Gearing.setGearPos(RobotMap.GearArmDown);
    }

    protected void execute() {
    }

    protected boolean isFinished() 
    {
    	return Robot.Gearing.onTarget() || Robot.OI.operButtonSquare.get();
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
