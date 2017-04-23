package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class TurretCommand extends Command {


	public TurretCommand() 
    {
		super("TurretCommand");
    	requires(Robot.Turret);
    }


	protected void initialize() 
    {
		Robot.Turret.setTurretAngle();
    }
    protected void execute() 
    {
    }

    protected boolean isFinished() 
    {
        return Robot.Turret.onTarget() || !Robot.OI.operButtonTouch.get();
    }

    protected void end() 
    {
    	Robot.Turret.disableTurretPID();
    }

    protected void interrupted() 
    {
    	end();
    }
}
