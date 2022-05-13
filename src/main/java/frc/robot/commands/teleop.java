package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.RotatingClimber;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class teleop extends CommandBase {
    private final double maxForwardSpeed = Constants.DriveConstants.maxSpeed;
    private final double turnSpeed = Constants.DriveConstants.maxTurnSpeed;
    private Joystick guitar;
    private DriveTrain driveTrain;

    public teleop(Joystick _guitar, DriveTrain _driveTrain) {
        driveTrain = _driveTrain;
        guitar = _guitar;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        // if (drivController.getRawButton(XboxController.Button.kLeftBumper.value)) {
        // driveTrain.drive(0.5,0.0);
        // }
        // else {
        //double localMaxForwardSpeed = maxForwardSpeed;
        //driveTrain.drive(0,0);
        //rotatingClimber.run(vroomstick.getRawAxis(1) * Constants.ClimberConstants.rotatingSpeed);
        //rotatingClimber.run(1.0);
        // }

        double forward = 0;
        double left = 0;
        if (guitar.getPOV() == 315) {
            forward = 1;
        }
        else if (guitar.getPOV() == 315 - 90) {
            forward = -1;
        }

        if (guitar.getRawButton(Constants.ControlConstants.guitarGreen)) {
            left = 1;
        }
        else if (guitar.getRawButton(Constants.ControlConstants.guitarRed)) {
            left = -1;
        }

        driveTrain.drive(-forward * maxForwardSpeed, left * turnSpeed);


        // if (vroomstick.getPOV() == 0){
        //     rotatingClimber.run(Constants.ClimberConstants.rotatingSpeed);
        // }
        // else if (vroomstick.getPOV() == 180){
        //     rotatingClimber.run(-Constants.ClimberConstants.rotatingSpeed);
        // }
        // else {
        //     rotatingClimber.run(0.0);
        // }
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
