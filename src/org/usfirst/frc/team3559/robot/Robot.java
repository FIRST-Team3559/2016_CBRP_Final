/*-----------------------------------------------------------------*/
/*  Team 3559 - Code for 2016 StrongHold Robot                     */
/*  Chief Programmer -> Nathaniel L. James (Nate--X)               */
/*  Advisor -> Mr. Routson (froutson)                              */
/*  https://github.com/FIRST-Team3559/2016_CBRP_Final              */
/*  Created On -> 12FEB2016                                        */
/*  Most Recent Update -> 14FEB2016								   */
/*-----------------------------------------------------------------*/

package org.usfirst.frc.team3559.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3559.robot.commands.Autonomous;
import org.usfirst.frc.team3559.robot.commands.Autonomous2;
import org.usfirst.frc.team3559.robot.subsystems.Arm;
import org.usfirst.frc.team3559.robot.subsystems.BallLoader;
// import org.usfirst.frc.team3559.robot.commands.ExampleCommand;
// import org.usfirst.frc.team3559.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3559.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final BallLoader ballloader = new BallLoader();
	public static final Arm arm = new Arm();
	public static OI oi;
	CameraServer cameraserver = CameraServer.getInstance();
	CameraServer cameraserver1 = CameraServer.getInstance();

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		
		oi = new OI();
		// TODO: Fix next 4 lines - SendableChooser - to get choice on SmartDashboard
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", new Autonomous());
		chooser.addObject("Autonomous2", new Autonomous2());
		SmartDashboard.putData("Auto mode", chooser);
		cameraserver.setQuality(20);
		cameraserver.startAutomaticCapture("cam0");
		//cameraserver1.setQuality(20);
		//cameraserver1.startAutomaticCapture("cam1");
		
		// autonomousCommand = new Autonomous();
		
		// Show what command your subsystem is running on SmartDashboard
		SmartDashboard.putData(drivetrain);
		//SmartDashboard.putData(ballloader);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
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
	public void autonomousInit() {
		autonomousCommand.start(); 
		autonomousCommand = (Command) chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	public void teleopInit() {
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
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	private void log() {
		drivetrain.log();
		arm.log();
	}
}
