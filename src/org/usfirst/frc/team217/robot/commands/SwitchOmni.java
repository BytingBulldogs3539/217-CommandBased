package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchOmni extends Command {

    private String dirrection;

	public SwitchOmni(String Dirrection) 
    {
    	this.dirrection = Dirrection;
    }

    protected void initialize() 
    {
    	if (this.dirrection == "Front"|| this.dirrection == "front")
    	{
    		Robot.DriveTrain.frontOmni();
    	}
    	else if (this.dirrection == "Back"|| this.dirrection == "back")
    	{
    		Robot.DriveTrain.backOmni();
    	}
    	else if (this.dirrection == "None"|| this.dirrection =="none");
    	{
    		Robot.DriveTrain.noOmni();
    	}
    		
    }

    protected void execute() 
    {
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() 
    {
    }

    protected void interrupted() 
    {
    }
}
