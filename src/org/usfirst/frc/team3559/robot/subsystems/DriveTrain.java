/**
 * DriveTrain.class code for 2016 Robot
 * Written By: Nathaniel L. James
 * Supervised By: Mr. Routson
 * Created: 11 FEB 2016
 * Edited: 14 FEB 2016
 * 
 **/

package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.TankDriveWithGamepad;

// import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
// import edu.wpi.first.wpilibj.SpeedController;		// I don't think I use this.
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
	private CANTalon left_motor, right_motor;
	private CANTalon left_slave, right_slave;
	private RobotDrive drive;
	// TODO: All gyro code is disabled until gyro is installed and working
	// private AnalogGyro gyro;
	
	private double speedModifier = 0.3;
	
	public DriveTrain(){
		super();
		left_motor = new CANTalon(1);
		left_slave = new CANTalon(2);
		left_slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		left_slave.set(left_motor.getDeviceID());		// Second left motor, CANTaonl(2), follows CANTalon(1)
		left_motor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		left_motor.configEncoderCodesPerRev(360);
		right_motor = new CANTalon(3);
		right_slave = new CANTalon(4);
		right_slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		right_slave.set(right_motor.getDeviceID());		// Second right motor, CANTalon(4), follows CANTalon(3)
		right_motor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		right_motor.configEncoderCodesPerRev(360);
		
		drive = new RobotDrive(left_motor, right_motor);
		

		//Let's show everything on the LiveWindow
		LiveWindow.addActuator("Drive Train", "Left Motor", (CANTalon) left_motor);
		LiveWindow.addActuator("Drive Train", "Right Motor", (CANTalon) right_motor);
		// TODO: Send the QuadEncoder data to the SmartDashboard _next two lines_
		LiveWindow.addSensor("Drive Train", "Left Encoder", left_motor);
		LiveWindow.addSensor("Drive Train", "Right Encoder", right_motor);
		// TODO: Add gyro sensor data to the livewindow
		// LiveWindow.addSensor("Drive Train", "Gyro", gyro);
		
	}
		/**
		 * When no other command is running let the operator drive around
		 * using the Logitech gamepad.
		 **/
		
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDriveWithGamepad());
    }
    
    public void log(){
    	SmartDashboard.putNumber("Left Distance", left_motor.getPosition());
    	SmartDashboard.putNumber("right Distance", right_motor.getPosition());
    	SmartDashboard.putNumber("Left Speed", left_motor.getSpeed());
    	SmartDashboard.putNumber("Right Speed",  right_motor.getSpeed());
    	// TODO: Add gyro output to smart dashboard
    	// SmartDashboard.putNumber("Gyro",  gyro.getAngle());
    }
    public void drive(double left, double right){
    	drive.tankDrive(left,  right);
    }
    /**
     * @param gamepad The Logitech style Gamepad to use to drive tank style.
     */
    public void drive(Joystick gamepad){
    	drive(-speedModifier*gamepad.getY(), -speedModifier*gamepad.getRawAxis(4));
    }
    /**
     * @return The robots heading in degrees.
    
    // TODO: All gyro code is disabled until it is installed and working
  
    public double getHeading(){
    	return gyro.getAngle();
    }
    */
    
    /**
     * Reset the robots sensors to the zero states.
     */
    public void reset(){
    	// TODO: gryo reset - enable when gyro is installed and working
    	// gyro.reset();
    	left_motor.setEncPosition(0);
    	right_motor.setEncPosition(0);
    }
    
    /**
     *   This is a modifier to change the rate of the gamepad inputs.
     */
    public void modifySpeed(double newSpeed){
    	this.speedModifier = newSpeed;
    }
    
}



