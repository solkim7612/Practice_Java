package Chapter1;

public class Character {
    private String nickname;
//    job 4가지 enum 정의 
    private Job job;
//    Lv.1 부터 최대 Lv.30
    private int level;
    
//    생성 시 랜덤 수치
    private double hp;
    private double mp;
    private double atk;
    private double def;

//    몬스터 처치 시 경험치 level*3, 레벨업을 위한 경험치 level*10
    private double exp_current;
    private double exp_max;

//    유저에게 닉네임, 직업 받고 캐릭터 생성
    public Character(String nickname, Job job) {
        this.nickname = nickname;
        this.job = job;

        this.level = 1;
        this.hp = 10;
        this.mp = 10;
        this.atk = 10;
        this.def = 10;
        this.exp_current=0;
        this.exp_max = level*10;

        RandomStats();
    }

//레벨 받고 몬스터 생성
    public Character(int level){
        this.level=level;

        this.hp=8;
        this.mp=8;
        this.atk=8;
        this.def=8;

        RandomStats();
    }

    private void RandomStats() {
        this.hp = this.hp * (1 + Math.random())*this.level;
        this.mp = this.mp * (1 + Math.random())*this.level;
        this.atk = this.atk * (1 + Math.random())*this.level;
        this.def = this.def * (1 + Math.random())*this.level;
    }

    private void LevelUp(){
        if(exp_current>=exp_max){
            this.level+=1;
            this.exp_current-=this.exp_max;
        }

        RandomStats();
    }

    @Override
    public String toString() {
        return String.format("Lv.%d %s[%s]가 생성되었습니다. \nHP: %.1f, MP: %.1f, 공격력: %.1f, 방어력: %.1f",
                level, nickname, job.getClasses(), hp, mp, atk, def);
    }
}