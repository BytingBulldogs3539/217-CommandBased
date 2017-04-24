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
    	
//    	the shooter knows where it is at all times. It knows this because it knows where it isn't. By subtracting where it is from where it isn't, or where it isn't from where it is (whichever is greater), it obtains a difference, or deviation. The guidance subsystem uses deviations to generate corrective commands to drive the shooter from a position where it is to a position where it isn't, and arriving at a position where it wasn't, it now is. Consequently, the position where it is, is now the position that it wasn't, and it follows that the position that it was, is now the position that it isn't.
//    	In the event that the position that it is in is not the position that it wasn't, the system has acquired a variation, the variation being the difference between where the shooter is, and where it wasn't. If variation is considered to be a significant factor, it too may be corrected by the GEA. However, the shooter must also know where it was.
//    	 
//    	The shooter guidance computer scenario works as follows. Because a variation has modified some of the information the shooter has obtained, it is not sure just where it is. However, it is sure where it isn't, within reason, and it knows where it was. It now subtracts where it should be from where it wasn't, or vice-versa, and by differentiating this from the algebraic sum of where it shouldn't be, and where it was, it is able to obtain the deviation and its variation, which is called error.
//    	
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
