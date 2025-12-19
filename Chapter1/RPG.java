package Chapter1;

public interface RPG {
//    캐릭터 상태 업데이트(레벨업과 스탯지정)
    void update(int level, double hp, double mp, double atk, double def);

//    결투 승리 여부(유효타격: 내 공격력-적 방어력, mp*25% 사용 시 atk*2 타격, 상대 hp가 0이 될 때 종료, 10판 내에 결정되지 않으면 hp 많이 남은 유저 or 몬스터가 승리)
    void isWin();

//    결투 중 사망했을 때 exp_current=0
    void isAlive();
    

}
