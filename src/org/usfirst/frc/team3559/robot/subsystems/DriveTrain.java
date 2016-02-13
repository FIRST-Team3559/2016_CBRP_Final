package org.usfirst.frc.team3559.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.wpi.first.frc.team3559.robot.Robot;
import edu.wpi.first.wpilib.team3559.robot.commands.TankDriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private SpeedController front_left_motor, back_left_motor, front_right_motor, back_right_motor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive drive;
	private Encoder left_encoder, right_encoder;
	private AnalogGyro gyro;
	private DriveTrain(){
		super();
		drive = new RobotDrive(front_left_motor, back_left_motor, front_right_motor, back_right_motor);
		left_encoder = new Encoder(1, 2);
		right_encoder = new Encoder(3, 4);
		gyro = new AnalogGyro(1);
		//Let's show everything on the LiveWindow
		LiveWindow.addActuator("Drive Train", "Front_Left Motor", (CANTalon) front_left_motor);
		LiveWindow.addActuator("Drive Train", "Front Right Motor", (CANTalon) front_right_motor);
		LiveWindow.addSensor("Drive Train", "Left Encoder", left_encoder);
		LiveWindow.addSensor("Drive Train", "Right Encoder", right_encoder);
		LiveWindow.addSensor("Drive Train", "Gyro", gyro);
		
	}
		/**
		 * When no other command is running let the operator drive around
		 * using the PS3 joystick.
		 */
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDriveWithJoystick());
    }
    
    public void log(){
    	SmartDashboard.putNumber("Left Distance", left_encoder.getDistance());
    	SmartDashboard.putNumber("right Distance", right_encoder.getDistance());
    	SmartDashboard.putNumber("Left Speed", left_encoder.getRate());
    	SmartDashboard.putNumber("Right Speed",  right_encoder.getRate());
    	SmartDashboard.putNumber("Gyro",  gyro.getAngle());
    }
    public void drive(double left, double right){
    	drive.tankDrive(left,  right);
    }
    /**
     * @param joy The ps# style Joystick to use to drive tank style.
     */
    public void drive(Joystick joy){
    	drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
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
    	left_encoder.reset();
    	right_encoder.reset();
    }
    
}



