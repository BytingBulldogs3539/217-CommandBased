package org.usfirst.frc.team217.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Climber extends Subsystem 
{
	CANTalon climber1;
	CANTalon climber2;
	public Climber()
	{
		climber1 = new CANTalon(2);
		climber2 = new CANTalon(3);
		
		climber2.changeControlMode(TalonControlMode.Follower);
		climber2.set(climber1.getDeviceID());
		
		climber1.configMaxOutputVoltage(12);
		climber1.configNominalOutputVoltage(0, 0);
		climber1.configPeakOutputVoltage(12, -12);
		climber1.EnableCurrentLimit(true);
		climber1.setCurrentLimit(60);
	}
	public void setClimbPower(double power)
	{
		climber1.changeControlMode(TalonControlMode.PercentVbus);
		climber1.set(power);
	}
    public void initDefaultCommand() 
    {
    	
    }
    @SuppressWarnings("deprecation")
	public void SmartInit()
    {
    	SmartDashboard.putDouble("Climber1 Amperage", climber1.getOutputCurrent());
    	SmartDashboard.putDouble("Climber2 Amperage", climber2.getOutputCurrent());
    }
    @SuppressWarnings("deprecation")
	public void Update()
    {
    	SmartDashboard.putDouble("Climber1 Amperage", climber1.getOutputCurrent());
    	SmartDashboard.putDouble("Climber2 Amperage", climber2.getOutputCurrent());
    }
}

