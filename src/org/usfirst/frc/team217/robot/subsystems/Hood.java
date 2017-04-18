package org.usfirst.frc.team217.robot.subsystems;

import org.usfirst.frc.team217.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Hood extends PIDSubsystem 
{
	AnalogInput hoodENC;
	
	CANTalon hood;
	
	private double hoodF;
	private double hoodP;
	private double hoodI;
	private double hoodD;
	
    public Hood() 
    {
    	super("Hood",0,0,0);
    	hood = new CANTalon(RobotMap.hood);
    	
    	hoodENC = new AnalogInput(RobotMap.hoodENC);
    }
	public void disableHoodPid()
	{
		this.getPIDController().disable();
	}

    public void setHood(double ENC)
    {
    	this.setAbsoluteTolerance(20);
    	this.setOutputRange(-.35, .35);
    	this.getPIDController().setPID(hoodF, hoodP, hoodI, hoodD);
    	this.getPIDController().enable();
    	this.setSetpoint(ENC);
    }
    public void setHoodPower(double Power)
    {
    	hood.changeControlMode(TalonControlMode.PercentVbus);
    	hood.set(Power);
    }
    
    public int getENC()
    {
    	return hoodENC.getValue();
    }

    public void initDefaultCommand() 
    {

    }

    protected double returnPIDInput() 
    {
        return getENC();
    }

    protected void usePIDOutput(double output) 
    {
    	setHoodPower(output);
    }
    @SuppressWarnings("deprecation")
	public void Update()
    {
    	SmartDashboard.putDouble("HoodENC", getENC());
    	SmartDashboard.putDouble("HoodF", this.hoodF);
    	SmartDashboard.putDouble("HoodP", this.hoodP);
    	SmartDashboard.putDouble("HoodI", this.hoodI);
    	SmartDashboard.putDouble("HoodD", this.hoodD);
    }
    @SuppressWarnings("deprecation")
	public void SmartInit()
    {
    	SmartDashboard.putDouble("HoodENC", getENC());
    	SmartDashboard.putDouble("HoodF", RobotMap.hoodF);
    	SmartDashboard.putDouble("HoodP", RobotMap.hoodP);
    	SmartDashboard.putDouble("HoodI", RobotMap.hoodI);
    	SmartDashboard.putDouble("HoodD", RobotMap.hoodD);
    }
}
