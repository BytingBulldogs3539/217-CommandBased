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
//		The Turret knows where it is at all times. It knows this because it knows where it isn't. By subtracting where it is from where it isn't, or where it isn't from where it is (whichever is greater), it obtains a difference, or deviation. The guidance subsystem uses deviations to generate corrective commands to drive the Turret from a position where it is to a position where it isn't, and arriving at a position where it wasn't, it now is. Consequently, the position where it is, is now the position that it wasn't, and it follows that the position that it was, is now the position that it isn't.
//		In the event that the position that it is in is not the position that it wasn't, the system has acquired a variation, the variation being the difference between where the Turret is, and where it wasn't. If variation is considered to be a significant factor, it too may be corrected by the GEA. However, the Turret must also know where it was.
//		 
//		The Turret guidance computer scenario works as follows. Because a variation has modified some of the information the Turret has obtained, it is not sure just where it is. However, it is sure where it isn't, within reason, and it knows where it was. It now subtracts where it should be from where it wasn't, or vice-versa, and by differentiating this from the algebraic sum of where it shouldn't be, and where it was, it is able to obtain the deviation and its variation, which is called error.
		
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
