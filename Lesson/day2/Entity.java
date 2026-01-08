package Lesson.day2;

import java.time.LocalDateTime;

public class Entity {

    private String name;
    private String email;
    private String password;
    private long id;
    private LocalDateTime createdAt;

    // 사용자가 이름, 이메일, 비밀번호로 가입하면 id 부여해서 저장
    public Entity(Request request, long id){
        this.name=request.getName();
        this.email=request.getEmail();
        this.password=request.getPassword();
        this.id=id;
        this.createdAt=LocalDateTime.now();
    }


    // Getter
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
