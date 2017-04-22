package org.usfirst.frc.team217.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RaspberryPi extends Subsystem {
	
	static NetworkTable table = NetworkTable.getTable("SmartDashboard");
	
	public RaspberryPi()
	{
		super("RaspberryPi");
		double COGX = 0;
		double COGY = 0;
		table.putNumber("COG_X", COGX);
		table.putNumber("COG_Y", COGY);
	}
	
	@SuppressWarnings("deprecation")
	public static double getAngle()
	{
		return table.getDouble("COG_X");
    }
	@SuppressWarnings("deprecation")
	public static double getDistance()
	{
		return table.getDouble("COG_Y");
	}

	@Override
	protected void initDefaultCommand() 
	{
		
	}
	public void SmartInit()
	{
		
	}
	@SuppressWarnings("deprecation")
	public void Update()
	{
		SmartDashboard.putDouble("COG_X", getAngle());
		SmartDashboard.putDouble("COG_Y", getDistance());
	}
}

