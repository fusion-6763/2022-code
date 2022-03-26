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
    private final double speedWhenIntaking = Constants.DriveConstants.speedWhenIntaking;
    private JoystickButton intakeButton;
    private XboxController drivController;
    private Joystick vroomstick;
    private DriveTrain driveTrain;
    private RotatingClimber rotatingClimber;

    public teleop(XboxController _driveController, Joystick _vroomstick, DriveTrain _driveTrain,
            JoystickButton _intakeButton, RotatingClimber _rotatingClimber) {
        drivController = _driveController;
        driveTrain = _driveTrain;
        vroomstick = _vroomstick;
        intakeButton = _intakeButton;
        rotatingClimber = _rotatingClimber;
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
        double localMaxForwardSpeed = maxForwardSpeed;
        if (intakeButton.get()) {
            localMaxForwardSpeed = speedWhenIntaking;
        }
        driveTrain.drive(-drivController.getRawAxis(1) * localMaxForwardSpeed,
                -drivController.getRawAxis(0) * turnSpeed);
        //rotatingClimber.run(vroomstick.getRawAxis(1) * Constants.ClimberConstants.rotatingSpeed);
        //rotatingClimber.run(1.0);
        // }
        if (vroomstick.getPOV() == 0){
            rotatingClimber.run(Constants.ClimberConstants.rotatingSpeed);
        }
        else if (vroomstick.getPOV() == 180){
            rotatingClimber.run(Constants.ClimberConstants.rotatingSpeed);
        }
        else {
            rotatingClimber.run(0.0);
        }
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
