package com.kienvu.Controller.EnemyWarrior;

import com.kienvu.Controller.ControllerManager;
import com.kienvu.GameConfig;

/**
 * Created by Trà Đá on 5/15/2016.
 */
public class EnemyWarriorControllerManager extends ControllerManager {

    private int c1 = 0;
    private int c2 = 0;

    private EnemyWarriorControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        c1++;
        c2++;
        if (GameConfig.getInst().durationInSeconds(c1) > 3) {
            c1 = 0;
            this.singleControllerVector.add(
                    EnemyWarriorController.create(1000, 100, EnemyWarriorType.DRAGON)
            );

        }
        if (GameConfig.getInst().durationInSeconds(c2) > 2) {
            c2 = 0;
            this.singleControllerVector.add(
                    EnemyWarriorController.create(1000, 400, EnemyWarriorType.LINH)
            );
        }
    }

    private static EnemyWarriorControllerManager inst;

    public static EnemyWarriorControllerManager getInst() {
        if (inst == null) {
            inst = new EnemyWarriorControllerManager();
        }

        return inst;
    }
}
