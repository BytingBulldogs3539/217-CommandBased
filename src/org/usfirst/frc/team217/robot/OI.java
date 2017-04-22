package org.usfirst.frc.team217.robot;

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

	public JoystickButton operbuttonx = new JoystickButton(oper,1);

	public OI()
	{
	}
}