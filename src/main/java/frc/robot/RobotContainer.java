// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.autonomous.CongaAuto;
import frc.robot.autonomous.DineAndDashLeft;
import frc.robot.autonomous.DineAndDashRight;
import frc.robot.autonomous.DriveForwardAuto;
import frc.robot.autonomous.DumpAndJumpAuto;
import frc.robot.autonomous.JustDumpAuto;
import frc.robot.autonomous.ThePowerplayAuto;
import frc.robot.commands.ClimberBackward;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberForward;
import frc.robot.commands.ClimberUp;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeFast;
import frc.robot.commands.IntakeSlow;
import frc.robot.commands.OuttakeFast;
import frc.robot.commands.OuttakeSlow;
import frc.robot.subsystems.ExtendingClimber;
import frc.robot.subsystems.RotatingClimber;
import frc.robot.subsystems.DriveTrain;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Tower;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.teleop;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrain _driveTrain = new DriveTrain();
  private final Tower _tower = new Tower();
  private final ExtendingClimber _extendingClimber = new ExtendingClimber();
  private final RotatingClimber _rotatingClimber = new RotatingClimber();

  //The controllers are defined here.
  private final Joystick vroomstick = new Joystick(Constants.ControlConstants.vroomstickPort);
  private final XboxController driveController = new XboxController(Constants.ControlConstants.driveControllerPort);
  //The buttons on the controllers are defined here.
  private final JoystickButton outtakeButton = new JoystickButton(driveController, XboxController.Button.kLeftBumper.value);
  private final JoystickButton intakeButton = new JoystickButton(driveController, XboxController.Button.kRightBumper.value);
  private final JoystickButton speedUpButton = new JoystickButton(vroomstick, 1);
  private final JoystickButton climberUpButton = new JoystickButton(vroomstick, 6);
  private final JoystickButton climberDownButton = new JoystickButton(vroomstick, 4);
  private final JoystickButton climberForwardButton = new JoystickButton(vroomstick, 7);
  private final JoystickButton climberBackwardButton = new JoystickButton(vroomstick, 8);
 

  //Puts a SendableChooser in Shuffleboard to choose autonomous command.
  private final SendableChooser<Command> autoChooser = new SendableChooser<Command>();
  //private final DriveForwardAuto driveForwardAuto = new DriveForwardAuto();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //Set the default autoMode to DriveForwardAuto.
    autoChooser.setDefaultOption("Drive Forward", new DriveForwardAuto(_driveTrain));

    //Adds new auto commands to the list.
    autoChooser.addOption("Dump and Jump", new DumpAndJumpAuto(_driveTrain, _tower));
    autoChooser.addOption("THE POWERPLAY", new ThePowerplayAuto(_driveTrain));
    autoChooser.addOption("Just Dump", new JustDumpAuto(_driveTrain, _tower));
    autoChooser.addOption("LEFT Dine & Dash", new DineAndDashLeft(_driveTrain, _tower));
    autoChooser.addOption("RIGHT Dine & Dash", new DineAndDashRight(_driveTrain, _tower));
    autoChooser.addOption("Conga Conga Conga", new CongaAuto(_driveTrain, _tower));

    //Put the autoChooser in ShuffleBoard. This line should be 
    //after all .setDefaultOption and .addOption lines.
    SmartDashboard.putData("Auto Mode", autoChooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //While leftBumper and not speedup button, intake slow
    // outtakeButton.and(speedUpButton.negate()).whileActiveContinuous(new IntakeSlow(_tower));
    //While rightBumper and not speedup button, outtake slow
    // intakeButton.and(speedUpButton.negate()).whileActiveContinuous(new OuttakeSlow(_tower));
    
    //While leftBumper and speedup button, intake fast
    // outtakeButton.and(speedUpButton).whileActiveContinuous(new IntakeFast(_tower));
    //While rightBumper and speedup button, outtake fast
    // intakeButton.and(speedUpButton).whileActiveContinuous(new OuttakeFast(_tower));

    intakeButton.whenHeld(new IntakeSlow(_tower));
    outtakeButton.whenHeld(new OuttakeSlow(_tower));
    speedUpButton.whenHeld(new IntakeFast(_tower));

    climberDownButton.whenHeld(new ClimberDown(_extendingClimber));
    climberUpButton.whenHeld(new ClimberUp(_extendingClimber));

    //climberForwardButton.whenHeld(new ClimberForward(_rotatingClimber));
    //climberBackwardButton.whenHeld(new ClimberBackward(_rotatingClimber));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Returns the selected auto mode in the autoChooser.
    return autoChooser.getSelected();
  } 
  public Command getTeleopCommand(){
    return new teleop(driveController, vroomstick, _driveTrain, intakeButton, _rotatingClimber);
  } 
}
