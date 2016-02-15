/**
 *   TurboMode.java
 *   Team3559 Code for 2016 FRC season "Stronghold"
 *   Written by: Fred Routson
 *   Supervised by: same
 *   Created on: 15 FEB 2016
 *   Edited on: 15 FEB 2016
 **/


package org.usfirst.frc.team3559.robot.commands;

import org.usfirst.frc.team3559.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *  Programatically change the top speed of the robot with a trigger button.
 */
public class TurboMode extends Command {
	
	private double highSpeed = 1.0;
	private double lowSpeed = 0.3;

    public TurboMode() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.modifySpeed(highSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.modifySpeed(lowSpeed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
