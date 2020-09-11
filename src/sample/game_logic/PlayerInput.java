package sample.game_logic;
import sample.characters.Player;
import sample.utility.DetailsBar;

import java.util.ArrayList;

public class PlayerInput{

    Player player;
    Process process;
    ArrayList<DetailsBar>detailsBars;
    public PlayerInput(Player player,Process process,ArrayList<DetailsBar>detailsBars){
        this.player = player;
        this.process = process;
        this.detailsBars = detailsBars;
    }

    public void swordAttack(){
        if(player.swordAttackLimit>1){
            player.swordAttackLimit--;
            double damage = player.swordAttackDamage ;
            process.playerResponse(Process.Option.SwordAttack,damage,player.defBuff);
            detailsBars.get(0).message = "Damage: "+player.swordAttackDamage+"\nTurns: "+player.swordAttackLimit;
        }else{
            detailsBars.get(0).message ="No Turns left";
        }
    }
    public void magicAttack(){
        if(player.magicAttackLimit>1){
            player.magicAttackLimit--;
            double damage =  player.magicAttackDamage;
            process.playerResponse(Process.Option.MagicAttack,damage,player.defBuff);
            detailsBars.get(1).message = "Damage: "+player.magicAttackDamage+"\nTurns: "+player.magicAttackLimit;
        }else {
            detailsBars.get(1).message ="No Turns left";
        }
    }
    public void buffAttack(){
        if(player.atkBuffLimit>1){
            player.atkBuffLimit--;
            player.swordAttackDamage = player.swordAttackDamage + player.swordAttackDamage*.20;
            player.magicAttackDamage =  player.magicAttackDamage + player.magicAttackDamage*.20;
            process.playerResponse(Process.Option.PowerUP,0,player.defBuff);
            detailsBars.get(2).message = "Damage boost: 20%\nTurns: "+player.atkBuffLimit;
            detailsBars.get(0).message = "Damage: "+player.swordAttackDamage+"\nTurns: "+player.swordAttackLimit;
            detailsBars.get(1).message = "Damage: "+player.magicAttackDamage+"\nTurns: "+player.magicAttackLimit;
        }else {
            detailsBars.get(2).message ="No Turns left";
        }
    }
    public void buffDefense(){
        if(player.defBuffLimit>1){
            player.defBuffLimit--;
            player.defBuff+=.15;
            process.playerResponse(Process.Option.DefenseUP,0,player.defBuff);
            detailsBars.get(3).message ="Defence boost: 20%\nTurns: "+player.defBuffLimit;
        }else{
            detailsBars.get(3).message ="No Turns left";
        }
    }
    public void block(){
        if(player.blockLimit>1){
            player.blockLimit--;
            process.playerResponse(Process.Option.Block,0,player.defBuff);
            detailsBars.get(4).message ="Turns: "+player.blockLimit;
        }else{
            detailsBars.get(4).message ="No Turns left";
        }
    }

}
