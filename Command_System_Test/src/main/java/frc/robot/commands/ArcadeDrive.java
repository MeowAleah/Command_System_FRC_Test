package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final DoubleSupplier x;
    private final DoubleSupplier r;

    public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier x, DoubleSupplier r){
        this.drivetrain = drivetrain;
        this.x = x;
        this.r = r;
        addRequirements(this.drivetrain);
    }

    @Override
    public void execute(){
        this.drivetrain.arcadeDrive(this.x.getAsDouble(),this.r.getAsDouble());
    }
}
