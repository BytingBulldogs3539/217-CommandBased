package org.usfirst.frc.team217.robot;

import org.usfirst.frc.team217.robot.commands.Climbing;
import org.usfirst.frc.team217.robot.commands.GearUp;
import org.usfirst.frc.team217.robot.commands.GrabGear;
import org.usfirst.frc.team217.robot.commands.ReleaseGear;
import org.usfirst.frc.team217.robot.commands.ReleaseGearPos;
import org.usfirst.frc.team217.robot.commands.ShootingCommand;
import org.usfirst.frc.team217.robot.commands.SwitchOmni;
import org.usfirst.frc.team217.robot.commands.TurretCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	public Joystick driver = new Joystick(RobotMap.controllerOnePort);
	public Joystick oper = new Joystick(RobotMap.controllerTwoPort);

	public JoystickButton operButtonX = new JoystickButton(oper,2);
	public JoystickButton operButtonSquare = new JoystickButton(oper,1);
	public JoystickButton operButtonCircle = new JoystickButton(oper, 3);
	public JoystickButton operButtonTringle = new JoystickButton(oper,4);
	public JoystickButton operButtonTouch = new JoystickButton(oper, 14);
	public JoystickButton operBumperLeft = new JoystickButton(oper, 5);
	public JoystickButton operTriggerLeft = new JoystickButton(oper, 7);
	
	public JoystickButton driverBumperLeft = new JoystickButton(driver,5);
	public JoystickButton driverBumperRight = new JoystickButton(driver,6);
	
	
	public OI()
	{
		//Operator
		operButtonTringle.whenPressed(new ShootingCommand());
		operButtonTouch.whenPressed(new TurretCommand());
		operButtonSquare.whenPressed(new GearUp());
		operBumperLeft.whenPressed(new GrabGear(1000));
		operButtonX.whenPressed(new ReleaseGearPos());
		operTriggerLeft.whenPressed(new ReleaseGear(1000));
		
		
		
		
		//Driver
		driverBumperLeft.whenPressed(new SwitchOmni("Both"));
		driverBumperRight.whenPressed(new SwitchOmni("Both"));
	}
}