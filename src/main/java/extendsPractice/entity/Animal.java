package extendsPractice.entity;

/**
 * Created by ZQ.
 *
 * @date 2021/2/25$ 9:47$
 */
public class Animal {
    private int healthValue;

    public int getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(int healthValue) {
        this.healthValue = healthValue;
    }

    public void eat(){
        healthValue += 1;
        System.out.println("吃完");
    }

    public void drink(){
        healthValue += 1;
        System.out.println("喝完");
    }

    public void run(){
        System.out.println("准备运动");
        healthValue -= 1;
        System.out.println("运动完成");
        if(LiveOrDie(healthValue)){
            System.out.println("还活着");
        }else {
            System.out.println("能量耗尽，已死");
        }
    }

    public Boolean LiveOrDie(int healthValue){
        if(healthValue<=0){
            return false;
        }else{
            return true;
        }
    }


}
