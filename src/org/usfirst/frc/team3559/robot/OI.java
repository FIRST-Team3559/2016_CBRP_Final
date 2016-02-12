package org.usfirst.frc.team3559.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.
import org.usfirst.frc.team3559.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick gamepad = new Joystick(0);
	
	public OI() {
		JoystickButton greenA 		= new JoystickButton(gamepad, 2);
		JoystickButton redB 		= new JoystickButton(gamepad, 3);
		JoystickButton blueX 		= new JoystickButton(gamepad, 1);
		JoystickButton orangeY		= new JoystickButton(gamepad, 4);
		JoystickButton lBumper 		= new JoystickButton(gamepad, 5);
		JoystickButton rBumper 		= new JoystickButton(gamepad, 6);
		JoystickButton lTrigger 	= new JoystickButton(gamepad, 7);
		JoystickButton rTrigger 	= new JoystickButton(gamepad, 8);
		
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
