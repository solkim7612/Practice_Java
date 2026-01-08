package Lesson.day2;

import java.util.HashMap;

public class Service {

    //    DB 생성 (id 별 Entity 저장)
    private final HashMap<Long, Entity> repo = new HashMap<>();
    private long id = 1L;

    //    가입 (Requset 매개변수 -> Entity 형식으로 저장 -> db에 저장)
    public void register(Request req) {
        Entity entity = new Entity(req,id++);

        repo.put(entity.getId(), entity);
    }

    //    조회
    //    repo 에서 id에 해당하는 entity 불러오기 -> response 로 변환
    public Response find(long id) {
        Entity entity = repo.get(id);

        if (entity == null) {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }

        return new Response(entity);
    }

}
