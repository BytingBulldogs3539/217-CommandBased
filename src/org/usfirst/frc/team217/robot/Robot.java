
package org.usfirst.frc.team217.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team217.robot.subsystems.*;
import org.usfirst.frc.team217.robot.commands.*;


//import org.usfirst.frc.team217.robot.commands.ExampleCommand;
//import org.usfirst.frc.team217.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

//	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final RaspberryPi RaspberryPi = new RaspberryPi();
	public static final RobotMap RobotMap = new RobotMap();
	public static final Turret Turret = new Turret();
	public static final Shooting Shooting = new Shooting();
	public static OI oi;	

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		SmartInit();
		Update();
		oi = new OI();
		SmartDashboard.putData("Auto mode", chooser);
		
		UsbCamera camera1;
		camera1 = CameraServer.getInstance().startAutomaticCapture();
		camera1.setResolution(160, 120);
		camera1.setFPS(30);
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Update();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		Update();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() 
	{
		Update();
		autonomousCommand = chooser.getSelected();


		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		ADXRS450_Gyro gyro = new ADXRS450_Gyro();
		gyro.calibrate();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Update();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Update();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Update();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		Update();
		LiveWindow.run();
	}
	public void Update()
	{
		Turret.Update();
		Shooting.Update();
	}
	public void SmartInit()
	{
		Turret.SmartInit();
	}
}
