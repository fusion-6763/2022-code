package frc.robot.subsystems;
import com.revrobotics.*;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

public class Tower extends SubsystemBase {
    private final double fastSpeed = Constants.TowerConstants.fastSpeed;
    private final double slowSpeed = Constants.TowerConstants.slowSpeed;
    private final CANSparkMax motor = new CANSparkMax(Constants.TowerConstants.SparkMaxPort,MotorType.kBrushless);
    private final CANSparkMax motor2 = new CANSparkMax(7,MotorType.kBrushless);

    public Tower(){
        setDefaultCommand(new RunCommand(this::neutral,this));
    }

    public void run(Double forwardSpeed){
      motor.set(forwardSpeed);
        motor2.set(-forwardSpeed);
      SmartDashboard.putNumber("Intake Speed", motor.getEncoder().getVelocity());
    }
    public void intakeFast(){
        this.run(-fastSpeed);
    }
    public void intakeSlow(){
        this.run(-slowSpeed);
    }
    public void outtakeFast(){
        this.run(fastSpeed);
    }
    public void outtakeSlow(){
        this.run(slowSpeed);
    }

    public void neutral(){
        motor.stopMotor();
        motor2.stopMotor();
        SmartDashboard.putNumber("Intake Speed", motor.getEncoder().getVelocity());
    }
}