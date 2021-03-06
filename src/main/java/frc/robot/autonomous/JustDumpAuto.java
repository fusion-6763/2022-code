// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous;

import frc.robot.commands.IntakeFast;
import frc.robot.commands.customTower;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Tower;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class JustDumpAuto extends SequentialCommandGroup {

  public JustDumpAuto(DriveTrain _driveTrain, Tower _tower) {
    super(
      //new customDrive(_driveTrain, -.5, 0).withTimeout(1),
      new IntakeFast(_tower).withTimeout(3),//, //Should be IntakeFast, but it is reversed. TODO:
      new customTower(_tower, 0.0).withTimeout(0.1)
      //new customDrive(_driveTrain, .5, 0).withTimeout(2.5)
    );
  }
}
