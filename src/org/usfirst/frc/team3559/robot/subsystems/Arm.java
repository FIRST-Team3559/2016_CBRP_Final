package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon
;

/**
 *
 */
public class Arm extends Subsystem {
	private static CANTalon armMotor;
	private static DigitalInput outLimit, inLimit;
	private double armSpeed;
    
    // Put methods for controlling this subsystem/
    // here. Call these from Commands.
	public Arm(){
		super();
		armMotor = new CANTalon(5);
		outLimit = new DigitalInput(2);
		inLimit = new DigitalInput(1);
		armSpeed = 0.8;
		
	}

    public void initDefaultCommand() {}
    
    
    public void armRaise(){
    	armMotor.set(armSpeed);
    }
    public void armLower(){
    	armMotor.set(-armSpeed);
    }
    public void armStop(){
    	armMotor.set(0);
    }
    public boolean isExtended(){
    	return !outLimit.get();
    }
    public boolean isRetracted(){
    	return !inLimit.get();
    }
    public void log() {
    	SmartDashboard.putBoolean("Arm Extended", this.isExtended());
    	SmartDashboard.putBoolean("Arm Retracted", this.isRetracted());
    }
}

