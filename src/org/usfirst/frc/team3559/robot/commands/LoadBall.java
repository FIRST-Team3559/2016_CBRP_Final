package org.usfirst.frc.team3559.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3559.robot.Robot;

/**
 *
 */
public class LoadBall extends Command {

    public LoadBall() {
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ballloader);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.ballloader.isLoaded() == false){
    		Robot.ballloader.ballIn();	
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.ballloader.isLoaded();
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	Robot.ballloader.ballstop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
