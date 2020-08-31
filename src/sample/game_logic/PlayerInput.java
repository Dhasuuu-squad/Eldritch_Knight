package sample.game_logic;
import javafx.scene.control.Button;
import sample.characters.Player;
import sample.screens.BattleScreen;
import sample.utility.DetailsBar;

public class PlayerInput{

    Process process;
    public PlayerInput(Process process){
        this.process = process;
    }

    Player player = new Player();
    DetailsBar detailsBar = new DetailsBar();
    double swordAttackDamage = 30;
    double magicAttackDamage = 70;
    double defBuff = 0;
    int swordAttackLimit =200;
    int magicAttackLimit =5;
    int atkBuffLimit =4;
    int defBuffLimit =4;
    int blockLimit = 5;

    public void swordAttack(Button button){
        if(swordAttackLimit>1){
            swordAttackLimit--;
            double damage = swordAttackDamage ;
            process.playerResponse(Process.Option.SwordAttack,damage,defBuff);
        }else{
            detailsBar.createDetailsBar(button,player.optionDetails[0],BattleScreen.pane,"No Turns left",BattleScreen.grid);
        }
    }
    public void magicAttack(Button button){
        if(magicAttackLimit>1){
            magicAttackLimit--;
            double damage =  magicAttackDamage;
            process.playerResponse(Process.Option.MagicAttack,damage,defBuff);
        }else {
            detailsBar.createDetailsBar(button,player.optionDetails[1],BattleScreen.pane,"No Turns left",BattleScreen.grid);
        }
    }
    public void buffAttack(Button button){
        if(atkBuffLimit>1){
            atkBuffLimit--;
            swordAttackDamage = swordAttackDamage + swordAttackDamage*.20;
            magicAttackDamage =  magicAttackDamage + magicAttackDamage*.20;
            process.playerResponse(Process.Option.PowerUP,0,defBuff);
        }else {
            detailsBar.createDetailsBar(button,player.optionDetails[2],BattleScreen.pane,"No Turns left",BattleScreen.grid);
        }
    }
    public void buffDefense(Button button){
        if(defBuffLimit>1){
            defBuffLimit--;
            defBuff+=.15;
            process.playerResponse(Process.Option.DefenseUP,0,defBuff);
        }else{
            detailsBar.createDetailsBar(button,player.optionDetails[3],BattleScreen.pane,"No Turns left",BattleScreen.grid);
        }
    }
    public void block(Button button){
        if(blockLimit>1){
            blockLimit--;
            process.playerResponse(Process.Option.Block,0,defBuff);
        }else{
            detailsBar.createDetailsBar(button,player.optionDetails[4],BattleScreen.pane,"No Turns left",BattleScreen.grid);
        }
    }

}
