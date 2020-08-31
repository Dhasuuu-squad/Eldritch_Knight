package sample.game_logic;

public class Process {

    double playerDamage;
    double enemyDamage;
    double playerBuff;
    double enemyBuff;
    Option playerOption;
    Option enemyOption;

    enum Option{
        SwordAttack,MagicAttack,PowerUP,DefenseUP,Block
    }

    public void playerResponse(Option option,double damage,double buff){
        playerOption = option;
        playerDamage = damage;
        playerBuff = buff;

        battleProcess();
    }

    public void enemyResponse(Option option,double damage,double buff){
        enemyOption = option;
        enemyDamage = damage;
        enemyBuff = buff;

    }

    void battleProcess(){

    }

}
