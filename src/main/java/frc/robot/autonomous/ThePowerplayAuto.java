// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous;

import frc.robot.commands.customDrive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class ThePowerplayAuto extends SequentialCommandGroup {

  public ThePowerplayAuto(DriveTrain _driveTrain) {
    super(
      new customDrive(_driveTrain, .8, 0).withTimeout(1),
      new customDrive(_driveTrain, 0, 0).withTimeout(.5),
      new customDrive(_driveTrain, 0, 1).withTimeout(5)
    );
  }
}
