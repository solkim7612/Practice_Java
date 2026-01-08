package Lesson.day2;

// post 요청
public class Request {
    private String name;
    private String email;
    private String password;

    // 사용자가 가입시 요청받는 데이터: 이름, 이메일, 패스워드
    public Request(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password=password;
    }


    // Getter: 이름, 이메일
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
