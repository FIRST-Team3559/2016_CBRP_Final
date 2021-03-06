/**
 *   TankDriveWithGamepad.java 
 *   Team3559 Code for 2016 FRC season "Stronghold"
 *   Written by: Nathaniel L. James
 *   Supervised by: Mr. Routson
 *   Created on: 12 FEB 2016
 *   Edited on: 15 FEB 2016
 **/


package org.usfirst.frc.team3559.robot.commands;

import org.usfirst.frc.team3559.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *  Have the robot controlled tank style using Logitech gamepad thumbsticks.
 */
public class TankDriveWithGamepad extends Command {

    public TankDriveWithGamepad() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive(Robot.oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;		// Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
