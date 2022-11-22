package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Input;

public class ArcadeDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final Input input;

    public ArcadeDrive(Drivetrain drivetrain, Input input){
        this.drivetrain = drivetrain;
        this.input = input;
        addRequirements(this.drivetrain);
        addRequirements(this.input);
    }

    @Override
    public void execute(){
        this.drivetrain.arcadeDrive(this.input.getY(),this.input.getX());
    }
}
