package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climbing extends Command 
{

    public Climbing() 
    {
        requires(Robot.Climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.Climber.setClimbPower(1);
    }
    protected void execute() 
    {
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    	Robot.Climber.setClimbPower(0);
    }

    protected void interrupted() 
    {
    }
}
