package org.usfirst.frc.team3559.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3559.robot.commands.ArmDown;
import org.usfirst.frc.team3559.robot.commands.ArmUp;
// import org.usfirst.frc.team3559.robot.commands.ExampleCommand;
import org.usfirst.frc.team3559.robot.commands.LoadBall;
import org.usfirst.frc.team3559.robot.commands.TurboMode;
import org.usfirst.frc.team3559.robot.commands.UnloadBall;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick gamepad = new Joystick(0);
	// Button greenA 		= new JoystickButton(gamepad, 2);
	// Button redB 		= new JoystickButton(gamepad, 3);
	// Button blueX 		= new JoystickButton(gamepad, 1);
	//Button orangeY		= new JoystickButton(gamepad, 4);
	Button lBumper 		= new JoystickButton(gamepad, 5);
	Button rBumper 		= new JoystickButton(gamepad, 6);
	Button lTrigger 	= new JoystickButton(gamepad, 7);
	Button rTrigger 	= new JoystickButton(gamepad, 8);
	
	public OI() {
		lTrigger.whileHeld(new ArmDown());
		rTrigger.whileHeld(new ArmUp());
		lBumper.whileHeld(new UnloadBall());
		//lBumper.whenInactive(new UnloadBall());
		rBumper.whileHeld(new LoadBall());
		//rBumper.whenInactive( new LoadBall());
		
		
	}
	public Joystick getJoystick() {
		return gamepad;
	}

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
