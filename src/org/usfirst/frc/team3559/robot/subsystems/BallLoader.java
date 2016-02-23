/**
 * BallLoader.class code for 2016 Robot
 * Written By: Frederick A. Routson
 * Supervised By: Mr. Routson
 * Created: 20 FEB 2016
 * Edited: 20 FEB 2016
 * 
 **/

package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *  Use a Talon in CAN mode to load and unload a game piece.
 */
public class BallLoader extends Subsystem {
	private static CANTalon feedMotor = new CANTalon(5);
	
	private DigitalInput ballLimit;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public BallLoader(){
		super();
		ballLimit = new DigitalInput(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void ballIn (){
    	feedMotor.set(-.7);
    }
    public void ballstop(){
    	feedMotor.set(0.0);
    }
    public void ballOut(){
    	feedMotor.set(1);
    }
    public boolean isLoaded(){
    	return ballLimit.get();
    }
}
