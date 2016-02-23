package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class Arm extends Subsystem {
	private static Victor armMotor;
	private static DigitalInput outLimit, inLimit;
    
    // Put methods for controlling this subsystem/
    // here. Call these from Commands.
	public Arm(){
		super();
		armMotor = new Victor(1);
		outLimit = new DigitalInput(2);
		inLimit = new DigitalInput(1);
		
	}

    public void initDefaultCommand() {}
    
    
    public void armRaise(){
    	armMotor.set(1);
    }
    public void armLower(){
    	armMotor.set(-1);
    }
    public void armStop(){
    	armMotor.set(0);
    }
    public boolean isExtended(){
    	return outLimit.get();
    }
    public boolean isRetracted(){
    	return inLimit.get();
    }
}

