package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class Arm extends Subsystem {
	private static Victor armMotor = new Victor(1);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void armRaise(){
    	armMotor.set(.5);
    }
    public void armLower(){
    	armMotor.set(-.5);
    }
}

