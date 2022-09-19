// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class DriveConstants {
        public static final int DRIVE_LEFT_NEO_1 = 3;
        public static final int DRIVE_LEFT_NEO_2 = 4;
        public static final int DRIVE_RIGHT_NEO_1 = 1;
        public static final int DRIVE_RIGHT_NEO_2 = 2;
        public static final double maxSpeed = 0.5;
        public static final double maxTurnSpeed = 0.5;
        public static final double speedWhenIntaking = 0.4;
    }
    public static final class TowerConstants {
        public static final double slowSpeed = 0.3;
        public static final double fastSpeed = 1.0;
        public static final int SparkMaxPort = 5;
    }
    public static final class ControlConstants {
        public static final int driveControllerPort = 0;
        public static final int vroomstickPort = 1;
        public static final int speedUpTowerButton = XboxController.Button.kA.value;
    }
    public static final class AutoConstants {
        public static final double dineAndDashTurnSpeed = 0.3;
    }
    public static final class ClimberConstants {
        public static final int SparkPort1 = 0; 
        public static final int SparkPort2 = 1;
        public static final double extendingSpeed = .75;
        public static final double extendingDefaultSpeed = 0.1;
        public static final int RotatingClimberSparkMax = 6;
        public static final double rotatingSpeed = 1.0;
        public static final double rotatingDefaultSpeed = 0;
    }
}
