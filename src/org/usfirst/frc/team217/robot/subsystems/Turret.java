package org.usfirst.frc.team217.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team217.robot.*;
import com.ctre.CANTalon;

/**
 *
 */
public class Turret extends PIDSubsystem
{
	private CANTalon turretMotor;
	private double turretMotorF;
	private double turretMotorP;
	private double turretMotorI;
	private double turretMotorD;
	public Turret()
	{
		
		super("Turret",0, 0, 0);
		turretMotor = new CANTalon(RobotMap.turretMotor);
		turretMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		turretMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		this.setAbsoluteTolerance(1);
		this.setOutputRange(-.35, .35);
		this.setSetpoint(0);
		
	}
	public void setTurretAngle()
	{
		this.getPIDController().setPID(this.turretMotorP,this.turretMotorI,this.turretMotorD,this.turretMotorF);
		this.getPIDController().enable();
		this.setSetpoint(0);
	}
	
	public void setTurretPower(double power)
	{
		turretMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		turretMotor.set(power);
	}
	
	public void disableTurretPID()
	{
		this.getPIDController().disable();
		setTurretPower(0);
	}
	
	public int getTurretAngle()
	{
		return turretMotor.getEncPosition();
	}
	
    protected double returnPIDInput() {
        return RaspberryPi.getAngle();
    }

    protected void usePIDOutput(double output) 
    {
    	turretMotor.set(output);
    }
    protected boolean OnTaget()
    {
    	return this.getPIDController().onTarget();
    }
    
    
    @SuppressWarnings("deprecation")
	public void Update()
    {
    	this.turretMotorF = SmartDashboard.getDouble("TurretF");
    	this.turretMotorP = SmartDashboard.getDouble("TurretP");
    	this.turretMotorI = SmartDashboard.getDouble("TurretI");
    	this.turretMotorD = SmartDashboard.getDouble("TurretD");
    }
    @SuppressWarnings("deprecation")
	public void SmartInit()
    {
    	SmartDashboard.putDouble("TurretF", RobotMap.turretMotorF);
    	SmartDashboard.putDouble("TurretP", RobotMap.turretMotorP);
    	SmartDashboard.putDouble("TurretI", RobotMap.turretMotorI);
    	SmartDashboard.putDouble("TurretD", RobotMap.turretMotorD);
    }
	@Override
	protected void initDefaultCommand()
	{
	}
}
