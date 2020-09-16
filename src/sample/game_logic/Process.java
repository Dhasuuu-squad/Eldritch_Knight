package sample.game_logic;
import sample.characters.EnemyAnimation;
import sample.characters.PlayerAnimation;
import sample.screens.BattleScreen;



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

        try {
            battleProcess();
        }catch (Exception exception){
            System.out.print(exception.getMessage());
        }
    }

    public void enemyResponse(Option option,double damage,double buff){
        enemyOption = option;
        enemyDamage = damage;
        enemyBuff = buff;

    }

    PlayerAnimation playerAnimation = new PlayerAnimation();
    EnemyAnimation enemyAnimation = new EnemyAnimation();
//    ExecutorService service = Executors.newSingleThreadExecutor();

    void battleProcess() throws InterruptedException {
        if(playerOption==Option.Block){
            if(enemyOption==Option.Block){
                playerAnimation.selectOption(PlayerAnimation.Options.Block);
                enemyAnimation.selectOption(EnemyAnimation.Options.Block);

                playerAnimation.block();
                enemyAnimation.block();
//                service.execute(playerAnimation);
//                service.execute(enemyAnimation);
//
//                service.shutdown();


//                Thread playerThread = new Thread(playerAnimation);
//                playerThread.start();
//                playerThread.join();
//                playerThread.setDaemon(true);

//
//                Thread enemyThread = new Thread(enemyAnimation);
//                enemyThread.start();
//                enemyThread.join();
//                enemyThread.setDaemon(true);

                //playerBlock animation
                //enemyBlock animation
            }else if(enemyOption==Option.PowerUP){
                //playerBlock animation
                //enemyPowerUp animation
            }else if(enemyOption==Option.DefenseUP){
                //playerBlock animation
                //enemyDefenseUp animation
            }else if(enemyOption==Option.SwordAttack||enemyOption==Option.MagicAttack){
                //playerBlock animation
                //enemyMove animation
            }
        }else if(enemyOption==Option.Block){
            if(playerOption==Option.PowerUP){
                //enemyBlock animation
                //playerPowerUp animation
            }else if(playerOption==Option.DefenseUP){
                //enemyBlock animation
                //playeDefenseUp animation
            }else if(playerOption==Option.SwordAttack||playerOption==Option.MagicAttack){
                //enemyBlock animation
                //playerMove animation
            }
        }

//        choiceBox.setVisible(true);

        screen.showChoices();


        
    }

}
