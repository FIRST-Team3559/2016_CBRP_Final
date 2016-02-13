/**
 * DriveTrain.class code for 2016 Robot
 * Written By: Nathaniel L. James
 * Supervised By: Mr. Routson
 * Created: 11 FEB 2016
 * Edited: 13 FEB 2016
 * 
 **/

package org.usfirst.frc.team3559.robot.subsystems;

import org.usfirst.frc.team3559.robot.commands.TankDriveWithGamepad;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends Subsystem {
	private SpeedController left_motor, right_motor;
	private RobotDrive drive;
	private AnalogGyro gyro;
	public DriveTrain(){
		super();
		left_motor = new CANTalon(1);
		// TODO: add code to get QuadEncoder data from left_motor
		right_motor = new CANTalon(2);
		// TODO: add code to get QuadEncoder data from right_motor
		drive = new RobotDrive(left_motor, right_motor);
		

		//Let's show everything on the LiveWindow
		LiveWindow.addActuator("Drive Train", "Front_Left Motor", (CANTalon) left_motor);
		LiveWindow.addActuator("Drive Train", "Front Right Motor", (CANTalon) right_motor);
		// TODO: Send the QuadEncoder data to the SmartDashboard _next two lines_
		// LiveWindow.addSensor("Drive Train", "Left Encoder", left_encoder);
		// LiveWindow.addSensor("Drive Train", "Right Encoder", right_encoder);
		LiveWindow.addSensor("Drive Train", "Gyro", gyro);
		
	}
		/**
		 * When no other command is running let the operator drive around
		 * using the Logitech gamepad.
		 **/
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDriveWithGamepad());
    }
    
    public void log(){
    	// TODO: Fix next 4 lines for QuadEncoder data
    	// SmartDashboard.putNumber("Left Distance", left_encoder.getDistance());
    	// SmartDashboard.putNumber("right Distance", right_encoder.getDistance());
    	// SmartDashboard.putNumber("Left Speed", left_encoder.getRate());
    	// SmartDashboard.putNumber("Right Speed",  right_encoder.getRate());
    	SmartDashboard.putNumber("Gyro",  gyro.getAngle());
    }
    public void drive(double left, double right){
    	drive.tankDrive(left,  right);
    }
    /**
     * @param joy The ps# style Joystick to use to drive tank style.
     */
    public void drive(Joystick gamepad){
    	drive(-gamepad.getY(), -gamepad.getRawAxis(4));
    }
    /**
     * @return The robots heading in degrees.
     */
    public double getHeading(){
    	return gyro.getAngle();
    }
    /**
     * Reset the robots sensors to the zero states.
     */
    public void reset(){
    	gyro.reset();
    	// TODO: Fix next two lines to reset the QuadEncoder data from CAN bus
    	// left_encoder.reset();
    	// right_encoder.reset();
    }
    
}



