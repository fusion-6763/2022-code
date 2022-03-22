// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous;

import frc.robot.commands.customDrive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class DriveForwardAuto extends SequentialCommandGroup {

  public DriveForwardAuto(DriveTrain _driveTrain) {
    super(
      new customDrive(_driveTrain, .8, 0).withTimeout(1)
    );
  }
}
