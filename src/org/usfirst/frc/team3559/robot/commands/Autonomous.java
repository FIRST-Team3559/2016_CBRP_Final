package org.usfirst.frc.team3559.robot.commands;

import org.usfirst.frc.team3559.robot.Robot;
import org.usfirst.frc.team3559.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *  The main autonomous command to drive to the defense.
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
    	//addSequential(new DriveStraight(30));
    	//requires(Robot.drivetrain);
    	
    	Robot.drivetrain.straight();
    	Timer.delay(10);
    	Robot.drivetrain.left();
    	
    	
    	
    }

}
