package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase{

    private MotorType mType = MotorType.kBrushless;
    private final CANSparkMax flMotor = new CANSparkMax(Constants.flMotorCANID, mType);
    private final CANSparkMax frMotor = new CANSparkMax(Constants.frMotorCANID, mType);
    private final CANSparkMax blMotor = new CANSparkMax(Constants.blMotorCANID, mType);
    private final CANSparkMax brMotor = new CANSparkMax(Constants.brMotorCANID, mType);
    private static final SparkMaxAlternateEncoder.Type kAltEncType = SparkMaxAlternateEncoder.Type.kQuadrature;
    private static final int kCPR = 8192;
    private RelativeEncoder m_Encoder = flMotor.getEncoder();

    

    private final MotorControllerGroup leftMotors = new MotorControllerGroup(flMotor, blMotor);
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(frMotor, brMotor);

    private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors,rightMotors);

    private double speed;

    public Drivetrain() {
        this.flMotor.setInverted(true);
        this.frMotor.setInverted(Constants.frMotorIsInverted);
        this.blMotor.setInverted(true);  
        this.brMotor.setInverted(Constants.brMotorIsInverted); 
        
    }


    public void tankDrive(double left, double right){
        this.differentialDrive.tankDrive(left, right);
    }

    public void arcadeDrive(double forward, double rotation){
        this.differentialDrive.arcadeDrive(forward * speed, rotation * speed);
        SmartDashboard.putNumber("encoder get position", m_Encoder.getPosition());
        SmartDashboard.putNumber("encoder get counts/rev", m_Encoder.getCountsPerRevolution());
        
    }

    public void stopMotors(){
        this.differentialDrive.stopMotor();
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }
}
