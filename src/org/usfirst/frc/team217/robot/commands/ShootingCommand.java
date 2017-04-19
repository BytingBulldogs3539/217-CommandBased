package org.usfirst.frc.team217.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.subsystems.*;

/**
 *
 */
public class ShootingCommand extends Command {

    public ShootingCommand() 
    {
    	
    }

    protected void initialize() 
    {
    	Robot.Shooting.setShooterRPM(SmartDashboard.getDouble("Shooter Set RPM"));
    }

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
        return false;
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
