package org.usfirst.frc.team217.robot.autoncommands;

import org.usfirst.frc.team217.robot.Robot;
import org.usfirst.frc.team217.robot.RobotMap;
import org.usfirst.frc.team217.robot.subsystems.RaspberryPi;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class AutonDrive extends PIDCommand {

    private double seconds;
	private double inches;
	private int counter;
	private boolean end;
	
	private PIDPasser pidOutput = new PIDPasser();

	private final PIDSource angle_output_source = new PIDSource()
	{
		public void setPIDSourceType(PIDSourceType pidSource)
		{
		}

		public PIDSourceType getPIDSourceType()
		{
			return PIDSourceType.kDisplacement;
		}

		public double pidGet()
		{
			return Robot.DriveTrain.getGyroAngle();
		}
	};
	public double returnAnglePIDInput()
	{
		return RaspberryPi.getAngle();
	}
	public AutonDrive(double inches, double seconds) {
    	super("AutonDrive",RobotMap.DriveF,RobotMap.DriveP,RobotMap.DriveI,RobotMap.DriveD);
        requires(Robot.DriveTrain);
        
        this.seconds = seconds*50;
        this.inches = inches;
        this.counter = 0;
        
        
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.DriveTrain.zeroEncoders();
    	Robot.DriveTrain.zeroGyro();
		PIDController anglePID = new PIDController(RobotMap.turnP, RobotMap.turnI, RobotMap.turnD, angle_output_source,pidOutput);
		anglePID.setSetpoint(0);
    	this.getPIDController().enable();
    	this.getPIDController().setSetpoint(this.inches);
    	
    	this.getPIDController().setAbsoluteTolerance(2000);
		this.getPIDController().setToleranceBuffer(5);
    	
    	anglePID.setAbsoluteTolerance(1);
    	anglePID.setToleranceBuffer(2);
    	this.setSetpoint(inches);
    	
    }

    // Called repeatedly when this Command is scheduled to run
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return this.getPIDController().onTarget() || this.end;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.DriveTrain.zeroEncoders();
    	Robot.DriveTrain.stopDriveTrain();
    	Robot.DriveTrain.zeroGyro();
    }

    protected void interrupted() 
    {
    	end();
    }

	@Override
	protected double returnPIDInput() 
	{
		return Robot.DriveTrain.getAverageEncoders();
	}

	@Override
	protected void usePIDOutput(double output) 
	{
		Robot.DriveTrain.driveArcade(output, pidOutput.Get());
	}
}
