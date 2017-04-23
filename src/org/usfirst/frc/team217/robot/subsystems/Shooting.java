package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooting extends PIDSubsystem
{
	CANTalon flyWheel;
	CANTalon flyWheel2;
	CANTalon wheelOfDoom;
	CANTalon kicker;
	CANTalon lifter;

	private double shooterF;
	private double shooterP;
	private double shooterI;
	private double shooterD;
	
    public Shooting() 
    {
    	super("Shooting", 0, 0, 0);
    	flyWheel = new CANTalon(RobotMap.flyWheel1);
    	flyWheel2 = new CANTalon(RobotMap.flyWheel2);
    	flyWheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
    	flyWheel.changeControlMode(TalonControlMode.Speed);
    	flyWheel2.changeControlMode(TalonControlMode.Follower);
    	flyWheel2.set(10);
    	
    	wheelOfDoom = new CANTalon(RobotMap.wheelOfDoom);
    	
    	kicker = new CANTalon(RobotMap.kicker);
    	
    	lifter = new CANTalon(RobotMap.lifter);
    	
    }
    public void setLifterPower(double Power)
    {
    	lifter.changeControlMode(TalonControlMode.PercentVbus);
    	lifter.set(Power);
    }
    
    public void setkickerPower(double Power)
    {
    	kicker.changeControlMode(TalonControlMode.PercentVbus);
    	kicker.set(Power);
    }
    public void setFlyWheelPower(double Power) 
    {
    	flyWheel.changeControlMode(TalonControlMode.PercentVbus);
    	flyWheel.set(Power);
	}
    public void setwheelOfDoomPower(double Power)
    {
    	wheelOfDoom.changeControlMode(TalonControlMode.PercentVbus);
    	wheelOfDoom.set(Power);
    }
    public void setShooterRPM(double RPM)
    {
    	this.getPIDController().setPID(shooterP, shooterI, shooterD, shooterF);
    	this.getPIDController().enable();
    	this.setSetpoint(RPM);
    }
    
    public int getShooterRPM()
    {
    	return flyWheel.getPulseWidthVelocity();
    }
    
    public void initDefaultCommand() 
    {
    	
    }
    
	public void disableHoodPid()
	{
		this.getPIDController().disable();
		setFlyWheelPower(0);
	}

    protected double returnPIDInput() 
    {
        return flyWheel.getPulseWidthVelocity();
    }

    protected void usePIDOutput(double output) 
    {
    	setFlyWheelPower(output); 
    }

	@SuppressWarnings("deprecation")
	public void Update() 
	{
		SmartDashboard.getDouble("shooterF", this.shooterF);
		SmartDashboard.getDouble("shooterP", this.shooterP);
		SmartDashboard.getDouble("shooterI", this.shooterI);
		SmartDashboard.getDouble("shooterD", this.shooterD);
	}
	@SuppressWarnings("deprecation")
	public void SmartInit()
	{
		SmartDashboard.putDouble("shooterF", RobotMap.shooterF);
		SmartDashboard.putDouble("shooterP", RobotMap.shooterP);
		SmartDashboard.putDouble("shooterI", RobotMap.shooterI);
		SmartDashboard.putDouble("shooterD", RobotMap.shooterD);
	}
}
