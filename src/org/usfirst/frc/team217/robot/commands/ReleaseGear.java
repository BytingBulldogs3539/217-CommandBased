package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseGear extends Command {

    private double seconds;
	private double counter = 0;
	private boolean end;

	public ReleaseGear(double seconds) 
    {
		requires(Robot.Gearing);
    	this.seconds = seconds;
    }

    protected void initialize() 
    {
    	counter = 0;
    	Robot.Gearing.setGearIntakePower(-.75);
    }

    protected void execute() 
    {
		this.counter++;
    	if (counter >= this.seconds)
    	{
    		this.end = true;
    	}
    	else
    	{
    		this.end = false;
    	}
    }

    protected boolean isFinished() 
    {
        return !Robot.OI.operBumperLeft.get() || this.end;
    }

    protected void end() 
    {
    	Robot.Gearing.setGearIntakePower(0);
    }

    protected void interrupted() 
    {
    	end();
    }
}
