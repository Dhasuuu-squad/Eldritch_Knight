package sample.game_logic;

import java.util.Random;

public class EnemyInput {

    Process process;
    public EnemyInput(Process process){
        this.process = process;
    }

    double swordAttackDamage = 30;
    double magicAttackDamage = 70;
    double defBuff = 0;
    int swordAttackLimit =200;
    int magicAttackLimit =5;
    int atkBuffLimit =4;
    int defBuffLimit =4;
    int blockLimit = 5;

    Random random = new Random();

    public void optionSelector(){
        int option = random.nextInt(22);
        if (option < 8) {
            if(swordAttackLimit>1)
                swordAttack();
            else optionSelector();

        } else if (option < 14) {
            if(magicAttackLimit>1)
                magicAttack();
            else optionSelector();

        } else if (option < 17) {
            if(atkBuffLimit>1)
                buffAttack();
            else optionSelector();

        }else if(option<19){
            if(blockLimit>1)
                block();
            else optionSelector();

        }else if (option < 22) {
            if(defBuffLimit>1)
                buffDefense();
            else optionSelector();

        }
    }

    void swordAttack(){
        atkBuffLimit--;
        double damage = swordAttackDamage;
        process.enemyResponse(Process.Option.SwordAttack,damage,defBuff);
    }

    void magicAttack(){
        magicAttackLimit--;
        double damage = magicAttackDamage;
        process.enemyResponse(Process.Option.MagicAttack,damage,defBuff);

    }
    void buffAttack(){
        atkBuffLimit--;
        swordAttackDamage = swordAttackDamage + swordAttackDamage*.20;
        magicAttackDamage =  magicAttackDamage + magicAttackDamage*.20;
        process.enemyResponse(Process.Option.PowerUP,0,defBuff);

    }

    void buffDefense(){
        defBuffLimit--;
        defBuff+=.15;
        process.enemyResponse(Process.Option.DefenseUP,0,defBuff);
    }

    void block(){
        blockLimit--;
        process.enemyResponse(Process.Option.Block,0,defBuff);
    }
}
