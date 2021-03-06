package org.usfirst.frc.team217.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team217.robot.Robot;

/**
 *
 */
public class ShootingCommand extends Command {

    public ShootingCommand() 
    {
    	requires(Robot.Shooting);
    }

    @SuppressWarnings("deprecation")
	protected void initialize() 
    {
    	Robot.Shooting.setShooterRPM(SmartDashboard.getDouble("Shooter Set RPM"));
    }

    @SuppressWarnings("deprecation")
	protected void execute() 
    {
    	if (Robot.Shooting.getShooterRPM() >= SmartDashboard.getDouble("Shooter Set RPM")*.9)
    	{
    		Robot.Shooting.setkickerPower(1);
    		Robot.Shooting.setLifterPower(1);
    		Robot.Shooting.setwheelOfDoomPower(1);
    	}
    }

    protected boolean isFinished() 
    {
        return !Robot.OI.operButtonTringle.get();
    }

    protected void end() 
    {
    	Robot.Shooting.disableHoodPid();
		Robot.Shooting.setkickerPower(0);
		Robot.Shooting.setLifterPower(0);
		Robot.Shooting.setwheelOfDoomPower(0);
    }

    protected void interrupted() 
    {
    	
    }
}
