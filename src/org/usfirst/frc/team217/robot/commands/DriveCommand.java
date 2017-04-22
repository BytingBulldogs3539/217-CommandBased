package org.usfirst.frc.team217.robot.commands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() 
    {
    	requires(Robot.DriveTrain);
    }


    protected void initialize()  
    {
    	Robot.DriveTrain.setVPercentBus();
    }


    protected void execute() 
    {
    	Robot.DriveTrain.driveArcade(Robot.OI.driver.getRawAxis(RobotMap.X_AxisL), Robot.OI.driver.getRawAxis(RobotMap.Y_AxisR));
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() 
    {
    	Robot.DriveTrain.stopDriveTrain();
    }


    protected void interrupted() 
    {
    	end();
    }
}
