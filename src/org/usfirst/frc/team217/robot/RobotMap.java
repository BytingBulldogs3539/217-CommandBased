package org.usfirst.frc.team217.robot;

import com.ctre.CANTalon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// PIDS
	public static double turretMotorF = 0;
	public static double turretMotorP = 0;
	public static double turretMotorI = 0;
	public static double turretMotorD = 0;
	
	public static double shooterF = 0;
	public static double shooterP = 0;
	public static double shooterI = 0;
	public static double shooterD = 0;
	
	public static double hoodF = 0;
	public static double hoodP = 0;
	public static double hoodI = 0;
	public static double hoodD = 0;
	
	
	// Talons
	
	//drive Talons
	public static final int LeftMaster = 0;
	public static final int LeftSlave = 1;
	public static final int RightMaster = 14;
	public static final int RightSlave = 15;
	
	//
	public static final int turretMotor = 6;
	public static final int wheelOfDoom = 12;
	public static final int kicker = 4;
	public static final int lifter = 5;
	public static final int hood = 9;
	public static final int hoodENC = 1;
	public static final int flyWheel1 = 10;
	public static final int flyWheel2 = 11;
	public static final int RBMotor = 15;
	public static final int RFMotor = 14;
	public static final int LFMotor = 1;
	public static final int LBMotor = 0;
	
	
	
	//CANTalon rightMaster, rightSlave, leftMaster, leftSlave;

	
	
}
