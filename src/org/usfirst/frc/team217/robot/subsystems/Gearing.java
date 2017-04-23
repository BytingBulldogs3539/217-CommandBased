package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Gearing extends PIDSubsystem {

    // Initialize your subsystem here

	
	private double GearArmP = 0;
	private double GearArmI = 0;
	private double GearArmD = 0;
	private double GearArmF = 0;
	
	CANTalon GearArm;
	CANTalon GearIntake;
	public Gearing()
	{
		super("Gearing",0,0,0,0);
		GearArm = new CANTalon(RobotMap.GearArm);
		GearIntake = new CANTalon(RobotMap.GearIntake);
		
		GearArm.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		
		GearIntake.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		GearArm.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }

    public void initDefaultCommand() 
    {
    }

    public void setGearPos(double pos)
    {
    	this.getPIDController().enable();
    	this.getPIDController().setPID(this.GearArmP,this.GearArmI ,this.GearArmD ,this.GearArmF );
    	this.setSetpoint(pos);
    }
    
    public void disableGearArmPID()
    {
    	this.getPIDController().disable();
    	setGearArm(0);
    }
    
    public void zeroGearingEncoders()
    {
    	GearArm.setPosition(0);
    }
    
    public void setGearArm(double Power)
    {
    	GearArm.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	GearArm.set(Power);
    }
    
    public void setGearIntakePower(double Power)
    {
    	GearIntake.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	GearIntake.set(Power);
    }
    
    protected double returnPIDInput() {
        return GearArm.getPosition();
    }

    protected void usePIDOutput(double output) 
    {
    	setGearArm(output);
    }
    
    @SuppressWarnings("deprecation")
	public void SmartInit()
    {
    	SmartDashboard.putDouble("GearArmP", RobotMap.GearArmP );
    	SmartDashboard.putDouble("GearArmI", RobotMap.GearArmI);
    	SmartDashboard.putDouble("GearArmD", RobotMap.GearArmD);
    	SmartDashboard.putDouble("GearArmF", RobotMap.GearArmF);
    }
    @SuppressWarnings("deprecation")
	public void Update()
    {
    	this.GearArmP = SmartDashboard.getDouble("GearArmP");
    	this.GearArmI = SmartDashboard.getDouble("GearArmI");
    	this.GearArmD = SmartDashboard.getDouble("GearArmD");
    	this.GearArmF = SmartDashboard.getDouble("GearArmF");
    	
    }
}
