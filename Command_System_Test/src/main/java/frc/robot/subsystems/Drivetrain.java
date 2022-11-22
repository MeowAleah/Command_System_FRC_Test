package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{

    private MotorType mType = MotorType.kBrushless;
    private final CANSparkMax flMotor = new CANSparkMax(Constants.flMotorCANID, mType);
    private final CANSparkMax frMotor = new CANSparkMax(Constants.frMotorCANID, mType);
    private final CANSparkMax blMotor = new CANSparkMax(Constants.blMotorCANID, mType);
    private final CANSparkMax brMotor = new CANSparkMax(Constants.brMotorCANID, mType);

    private final MotorControllerGroup leftMotors = new MotorControllerGroup(flMotor, blMotor);
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(frMotor, brMotor);

    private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors,rightMotors);

    public Drivetrain() {
        this.flMotor.setInverted(Constants.flMotorIsInverted);
        this.frMotor.setInverted(Constants.frMotorIsInverted);
        this.blMotor.setInverted(Constants.blMotorIsInverted);
        this.brMotor.setInverted(Constants.brMotorIsInverted); 
    }


    public void tankDrive(double left, double right){
        this.differentialDrive.tankDrive(left, right);
    }

    public void arcadeDrive(double forward, double rotation){
        this.differentialDrive.arcadeDrive(forward, rotation);
    }

    public void stopMotors(){
        this.differentialDrive.stopMotor();
    }
}
