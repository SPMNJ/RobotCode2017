package org.usfirst.frc.team87.robot;

import javax.naming.LimitExceededException;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team87.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//////////////
	// DEVICES //
	//////////////

	static Spark driveR1;
	static Spark driveR2;
	static Spark driveL1;
	static Spark driveL2;

	static RobotDrive tankDrive;

	static TalonSRX fuelIn;
	static Relay fuelOutDoor;

	static Relay winch;

	static DigitalInput fuelOutLimit;
	static AnalogGyro gyro;
	static Encoder leftEncoder;
	static Encoder rightEncoder;

	public OI() {
		driveR1 = new Spark(RobotMap.DRIVE_R1);
		driveR2 = new Spark(RobotMap.DRIVE_R2);
		driveL1 = new Spark(RobotMap.DRIVE_L1);
		driveL2 = new Spark(RobotMap.DRIVE_L2);

		tankDrive = new RobotDrive(driveL1, driveL2, driveR1, driveR2);

		fuelIn = new TalonSRX(RobotMap.FUEL_IN);
		fuelOutDoor = new Relay(RobotMap.FUEL_OUT);

		winch = new Relay(RobotMap.WINCH);

		fuelOutLimit = new DigitalInput(RobotMap.FUEL_OUT_LIMIT);
		gyro = new AnalogGyro(RobotMap.GYROSCOPE);

		leftEncoder = new Encoder(RobotMap.ENC_1_IN, RobotMap.ENC_1_OUT);
		leftEncoder = new Encoder(RobotMap.ENC_2_IN, RobotMap.ENC_2_OUT);

	}

	////////////////
	// TELEOP //
	// CONTROLS //
	////////////////
	/**
	 * Controls the drive of the robot. Will change which side of the robot is
	 * the "front" based on the reversedSet parameter.
	 * 
	 * @param leftValue
	 * @param rightValue
	 * @param reversedSet
	 */
	public static void drive(double leftValue, double rightValue, boolean reversedSet) {
		if (reversedSet) {
			tankDrive.tankDrive(-1 * rightValue, -1 * leftValue);
		} else {
			tankDrive.tankDrive(leftValue, rightValue);
		}
	}

	public static void intake(Relay.Value value) {

	}

	public static void fuelOut(Relay.Value value) {

		if (fuelOutLimit.get() == false || value != Relay.Value.kForward) {
			fuelOutDoor.set(value);
		} else {
			fuelOutDoor.set(Relay.Value.kOff);
		}
	}

	////////////////
	// AUTONOMOUS //
	// CONTROLS   //
	////////////////
	/**
	 * Controls the drive of the robot.
	 * 
	 * @param leftValue
	 * @param rightValue
	 */
	public static void drive(double leftValue, double rightValue) {
		tankDrive.tankDrive(leftValue, rightValue);
	}

	/**
	 * Resets the gyroscope.
	 */
	public static void resetGyro() {
		gyro.reset();
		gyro.calibrate();
	}

	/**
	 * Gets the angle of the gyroscope.
	 * 
	 * @return
	 */
	public static double getGyro() {
		return gyro.getAngle();
	}

	/**
	 * Resets both encoders on the robot.
	 */
	public static void resetEncoder() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * Returns the value of the left encoder.
	 * 
	 * @return
	 */
	public static int getLeftEncoder() {
		return leftEncoder.get();
	}

	/**
	 * Returns the value of the right encoder.
	 * 
	 * @return
	 */
	public static int getRightEncoder() {
		return rightEncoder.get();
	}

}
