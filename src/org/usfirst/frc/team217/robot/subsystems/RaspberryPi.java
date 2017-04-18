package org.usfirst.frc.team217.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

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

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

