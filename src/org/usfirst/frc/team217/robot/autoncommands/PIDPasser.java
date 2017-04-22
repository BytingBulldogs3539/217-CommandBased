package org.usfirst.frc.team217.robot.autoncommands;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 *
 */
public class PIDPasser implements PIDOutput
{
	private double pidValue;
	
	public void pidWrite(double output)
	{
		pidValue = output;
	}
	
	public void Reset()
	{
		pidValue = 0;
	}
	
	public double Get()
	{
		return pidValue;
	}
}
