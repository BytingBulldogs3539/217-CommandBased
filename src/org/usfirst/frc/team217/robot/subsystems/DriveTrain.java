package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;
import org.usfirst.frc.team217.robot.commands.DriveCommand;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	CANTalon RBMotor,LBMotor,RFMotor,LFMotor;
	Solenoid BackSolenoid, FrontSolenoid;
	private RobotDrive drive;
	
	ADXRS450_Gyro Gyro;

	The robot knows where it is at all times. It knows this because it knows where it isn't. By subtracting where it is from where it isn't, or where it isn't from where it is (whichever is greater), it obtains a difference, or deviation. The guidance subsystem uses deviations to generate corrective commands to drive the robot from a position where it is to a position where it isn't, and arriving at a position where it wasn't, it now is. Consequently, the position where it is, is now the position that it wasn't, and it follows that the position that it was, is now the position that it isn't.
//	In the event that the position that it is in is not the position that it wasn't, the system has acquired a variation, the variation being the difference between where the robot is, and where it wasn't. If variation is considered to be a significant factor, it too may be corrected by the GEA. However, the robot must also know where it was.
//	 
//	The robot guidance computer scenario works as follows. Because a variation has modified some of the information the robot has obtained, it is not sure just where it is. However, it is sure where it isn't, within reason, and it knows where it was. It now subtracts where it should be from where it wasn't, or vice-versa, and by differentiating this from the algebraic sum of where it shouldn't be, and where it was, it is able to obtain the deviation and its variation, which is called error.
	public DriveTrain()
	{
		super("DriveTrain");
		
		RBMotor = new CANTalon(RobotMap.RBMotor);
		RFMotor = new CANTalon(RobotMap.RFMotor);
		LBMotor = new CANTalon(RobotMap.LBMotor);
		LFMotor = new CANTalon(RobotMap.LFMotor);
		
		RFMotor.changeControlMode(TalonControlMode.Follower);
		LFMotor.changeControlMode(TalonControlMode.Follower);
		
		RBMotor.set(RFMotor.getDeviceID());
		LBMotor.set(LFMotor.getDeviceID());
		
		RBMotor.changeControlMode(TalonControlMode.PercentVbus);
		LBMotor.changeControlMode(TalonControlMode.PercentVbus);
		
		LBMotor.setCurrentLimit(38);
		RBMotor.setCurrentLimit(38);
		
		LBMotor.configNominalOutputVoltage(0.0f, -0.0f);
		LBMotor.configPeakOutputVoltage(12.0f, -12.0f);
		
		RBMotor.configNominalOutputVoltage(0.0f, -0.0f);
		RBMotor.configPeakOutputVoltage(12, -12);
		
		RBMotor.configMaxOutputVoltage(12);
		LBMotor.configMaxOutputVoltage(12);
		
		LBMotor.enableBrakeMode(true);
		RBMotor.enableBrakeMode(true);
		
		RBMotor.EnableCurrentLimit(true);
		LBMotor.EnableCurrentLimit(true);
		
		RBMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		LBMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		BackSolenoid = new Solenoid(1);
		FrontSolenoid = new Solenoid(2);
		
		Gyro = new ADXRS450_Gyro();
		
		
		
	}
	public double getAverageEncoders()
	{
		return (RBMotor.getPosition()+LBMotor.getPosition())/2;
	}
	@SuppressWarnings("deprecation")
	public double getAverageEncodersInInches()
	{
		return ((getAverageEncoders()/4098)*Math.PI)*SmartDashboard.getDouble("Distance Adjustment");
	}
	
	public double getGyroAngle()
	{
		return Gyro.getAngle();
	}
	
	public void driveArcade(double speed, double turnSpeed)
	{
		drive.arcadeDrive(speed, turnSpeed);
	}
	
	public void stopDriveTrain()
	{
		RBMotor.changeControlMode(TalonControlMode.PercentVbus);
		LBMotor.changeControlMode(TalonControlMode.PercentVbus);
		RBMotor.set(0);
		LBMotor.set(0);
	}
	
	public void zeroGyro()
	{
		Gyro.reset();
	}
	
	public void frontOmni()
	{
		BackSolenoid.set(false);
		FrontSolenoid.set(true);
	}
	public void backOmni()
	{
		FrontSolenoid.set(false);
		BackSolenoid.set(true);
	}
	public void bothOmni()
	{
		BackSolenoid.set(true);
		FrontSolenoid.set(true);
	}
	
	public void zeroEncoders()
	{
		RBMotor.setEncPosition(0);
		LBMotor.setEncPosition(0);
	}
	
    public void initDefaultCommand() 
    {
    	setDefaultCommand(new DriveCommand());
    }
    
    @SuppressWarnings("deprecation")
	public void Update()
    {
    	//SmartDashboard.putDouble("EX", EX)
    	SmartDashboard.putDouble("RBMotor Talon Temp", RBMotor.getTemperature());
    	SmartDashboard.putDouble("LBMotor Talon Temp", LBMotor.getTemperature());
    	SmartDashboard.putDouble("RFMotor Talon Temp", RFMotor.getTemperature());
    	SmartDashboard.putDouble("LFMotor Talon Temp", LFMotor.getTemperature());
    	
    	SmartDashboard.putDouble("RBMotor Talon Current", RBMotor.getOutputCurrent());
    	SmartDashboard.putDouble("LBMotor Talon Current", LBMotor.getOutputCurrent());
    	SmartDashboard.putDouble("RFMotor Talon Current", RFMotor.getOutputCurrent());
    	SmartDashboard.putDouble("LFMotor Talon Current", LFMotor.getOutputCurrent());
    	
    	SmartDashboard.putDouble("RBMotor Talon Current", RBMotor.getPosition());
    	SmartDashboard.putDouble("LBMotor Talon Current", LBMotor.getPosition());
    	
    	RobotMap.turnP = SmartDashboard.getDouble("Turn P");
    	RobotMap.turnI = SmartDashboard.getDouble("Turn I");
    	RobotMap.turnD = SmartDashboard.getDouble("Turn D");
    	RobotMap.turnF = SmartDashboard.getDouble("Turn F");
    	
    }
    @SuppressWarnings("deprecation")
	public void SmartInit()
    {
    	//SmartDashboard.putDouble("EX", EX)
    	SmartDashboard.putDouble("RBMotor Talon Temp", RBMotor.getTemperature());
    	SmartDashboard.putDouble("LBMotor Talon Temp", LBMotor.getTemperature());
    	SmartDashboard.putDouble("RFMotor Talon Temp", RFMotor.getTemperature());
    	SmartDashboard.putDouble("LFMotor Talon Temp", LFMotor.getTemperature());
    	
    	SmartDashboard.putDouble("RBMotor Talon Current", RBMotor.getOutputCurrent());
    	SmartDashboard.putDouble("LBMotor Talon Current", LBMotor.getOutputCurrent());
    	SmartDashboard.putDouble("RFMotor Talon Current", RFMotor.getOutputCurrent());
    	SmartDashboard.putDouble("LFMotor Talon Current", LFMotor.getOutputCurrent());
    	
    	SmartDashboard.putDouble("RBMotor Talon Current", RBMotor.getPosition());
    	SmartDashboard.putDouble("LBMotor Talon Current", LBMotor.getPosition());
    	SmartDashboard.putDouble("Distance Adjustment", RobotMap.DistanceAdjust);
    	
    	SmartDashboard.putDouble("Turn P", RobotMap.turnP);
    	SmartDashboard.putDouble("Turn I", RobotMap.turnI);
    	SmartDashboard.putDouble("Turn D", RobotMap.turnD);
    	SmartDashboard.putDouble("Turn F", RobotMap.turnF);
    }
	public void setVPercentBus() 
	{		
		RBMotor.changeControlMode(TalonControlMode.PercentVbus);
		LBMotor.changeControlMode(TalonControlMode.PercentVbus);
	}
	public void calGyro() 
	{
		Gyro.calibrate();
	}
}

