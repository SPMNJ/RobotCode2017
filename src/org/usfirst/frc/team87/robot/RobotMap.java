package org.usfirst.frc.team87.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	static final int PLACEHOLDER = 0;
	
	///////////////
	// JOYSTICKS //
	///////////////
	
	public static final int JOYSTICK = PLACEHOLDER;
	public static final int GAMEPAD = PLACEHOLDER;
	
	////////////
	// MOTORS //
	////////////
	
	public static final int DRIVE_L1 = PLACEHOLDER; 
	public static final int DRIVE_L2 = PLACEHOLDER;
	public static final int DRIVE_R1 = PLACEHOLDER;
	public static final int DRIVE_R2 = PLACEHOLDER;
	
	public static final int FUEL_IN = PLACEHOLDER;
	public static final int FUEL_OUT = PLACEHOLDER;
	
	public static final int WINCH = PLACEHOLDER;
	
	/////////////
	// SENSORS //
	/////////////
	
	public static final int GYROSCOPE = PLACEHOLDER;
	
	public static final int ENC_1_IN = PLACEHOLDER;
	public static final int ENC_1_OUT = PLACEHOLDER;
	public static final int ENC_2_IN = PLACEHOLDER;
	public static final int ENC_2_OUT = PLACEHOLDER;
	
	public static final int FUEL_OUT_LIMIT = PLACEHOLDER;
	
	////////////////
	// NAVIGATION //
	////////////////
	
	
	public static final double INCHES_TO_ENCODER = 256 / (6 * Math.PI); // STEPS IN ENCODER / (DIAMETER * PI)
	
	
	public static final int DIST_TO_LINE = PLACEHOLDER;
	
}
