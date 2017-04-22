
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
import org.usfirst.frc.team217.robot.subsystems.DriveTrain;


//import org.usfirst.frc.team217.robot.commands.ExampleCommand;
//import org.usfirst.frc.team217.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	public static final RobotMap RobotMap = new RobotMap();
	public static final DriveTrain DriveTrain = new DriveTrain();
	public static final RaspberryPi RaspberryPi = new RaspberryPi();
	public static final Turret Turret = new Turret();
	public static final Shooting Shooting = new Shooting();
	public static final Climber Climber = new Climber();
	public static OI OI;	

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
		OI = new OI();
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
		
		SmartDashboard.putData(Shooting);
		SmartDashboard.putData(Turret);
		SmartDashboard.putData(Shooting);
		SmartDashboard.putData(DriveTrain);
		SmartDashboard.putData(Climber);
	}
	public void SmartInit()
	{
		Turret.SmartInit();
		Shooting.SmartInit();
	}
}
