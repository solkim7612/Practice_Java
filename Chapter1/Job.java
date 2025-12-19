package Chapter1;

public enum Job {
    WARRIOR(1, "전사", "물리적인 힘과 무구로 최전선에서 전투를 벌이는 클래스"),
    ROGUE(2, "도적", "방어력은 낮지만 치명적인 기습 능력과 각종 야바위로 분투하는 클래스"),
    WIZRD(3, "마법사", "육체적인 허약함을 방대한 지식과 강력한 마법으로 보완하는 클래스"),
    CLERIC(4, "성직자", "신앙에 기반하여 사용할 수 있는 보조,치유 마법을 구사하는 클래스");

    private final int code;
    private final String classes;
    private final String desc;

    Job(int code, String classes, String desc) {
        this.code = code;
        this.classes = classes;
        this.desc = desc;
    }

    public static Job fromCode(int code) {
        for (Job job : Job.values()) {
            if (job.code == code) {
                return job;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 직업입니다.");
    }

    public String getClasses(){
        return classes;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s: %s", code, classes, desc);
    }
}
