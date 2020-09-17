package sample.game_logic;
import sample.characters.EnemyAnimation;
import sample.characters.PlayerAnimation;
import sample.screens.BattleScreen;

import java.util.Random;


public class Process {

    BattleScreen screen;
    public Process(BattleScreen screen){
        this.screen = screen;

    }


    double playerDamage;
    double enemyDamage;
    double playerBuff;
    double enemyBuff;
    Option playerOption;
    Option enemyOption;

    enum Option{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    public void playerResponse(Option option,double damage,double buff) {
        playerOption = option;
        playerDamage = damage;
        playerBuff = buff;


        battleProcess();

    }

    public void enemyResponse(Option option,double damage,double buff){
        enemyOption = Option.DefenseUP;
        enemyDamage = damage;
        enemyBuff = buff;

    }
    EnemyAnimation enemyAnimation = new EnemyAnimation();
    PlayerAnimation playerAnimation = new PlayerAnimation(enemyAnimation);

    Random random = new Random();

    void battleProcess() {

        int turn = random.nextInt(2);
        if(playerOption==Option.Block){
            if(enemyOption==Option.Block){

                playerAnimation.selectOption(PlayerAnimation.Options.Block,screen,turn);
                enemyAnimation.selectOption(EnemyAnimation.Options.Block,screen,playerAnimation,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();


            }else if(enemyOption==Option.PowerUP){

                playerAnimation.selectOption(PlayerAnimation.Options.Block,screen,turn);
                enemyAnimation.selectOption(EnemyAnimation.Options.PowerUP,screen,playerAnimation,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }else if(enemyOption==Option.DefenseUP){

                playerAnimation.selectOption(PlayerAnimation.Options.Block,screen,turn);
                enemyAnimation.selectOption(EnemyAnimation.Options.DefenseUP,screen,playerAnimation,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }else if(enemyOption==Option.SwordAttack){

                playerAnimation.selectOption(PlayerAnimation.Options.Block,screen,turn);
                enemyAnimation.selectOption(EnemyAnimation.Options.SwordAttack,screen,playerAnimation,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }else if(enemyOption==Option.MagicAttack){

                playerAnimation.selectOption(PlayerAnimation.Options.Block,screen,turn);
                enemyAnimation.selectOption(EnemyAnimation.Options.MagicAttack,screen,playerAnimation,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();
            }
        }else if(enemyOption==Option.Block){
            if(playerOption==Option.PowerUP){

                enemyAnimation.selectOption(EnemyAnimation.Options.Block,screen,playerAnimation,turn);
                playerAnimation.selectOption(PlayerAnimation.Options.PowerUP,screen,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }else if(playerOption==Option.DefenseUP){

                enemyAnimation.selectOption(EnemyAnimation.Options.Block,screen,playerAnimation,turn);
                playerAnimation.selectOption(PlayerAnimation.Options.DefenseUP,screen,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }else if(playerOption==Option.SwordAttack){

                enemyAnimation.selectOption(EnemyAnimation.Options.Block,screen,playerAnimation,turn);
                playerAnimation.selectOption(PlayerAnimation.Options.SwordAttack,screen,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }else if(playerOption==Option.MagicAttack){

                enemyAnimation.selectOption(EnemyAnimation.Options.Block,screen,playerAnimation,turn);
                playerAnimation.selectOption(PlayerAnimation.Options.MagicAttack,screen,turn);

                if(turn == 0){
                    playerAnimation.run();
                }else enemyAnimation.run();

            }
        }

        
    }

}
