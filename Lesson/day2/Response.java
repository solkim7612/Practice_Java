package Lesson.day2;

// get 요청
public class Response {
    private String name;
    private String email;
    private long id;
    private String tempPassword;

    public Response(Entity entity){
        this.name=entity.getName();
        this.email=entity.getEmail();
        this.id=entity.getId();
    }

    // 조건 검색 후 Response의 email로 반환
    public Response(String email){
        this.email=email;
    }


    // Getter: 이름, 이메일, id
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
}
