package extendsPractice.entity;

/**
 * Created by ZQ.
 *
 * @date 2021/2/25$ 9:54$
 */
public class Dog extends Animal {
    private int healthValue;

    public void lookGate(){
        System.out.println("正在看家");
        healthValue -=  2;
        if(LiveOrDie(healthValue)){
            System.out.println("还活着");
        }else {
            System.out.println("能量耗尽，已死");
        }
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

}
