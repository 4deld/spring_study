package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member rst = repository.findById(member.getId()).get();
        Assertions.assertEquals(member,rst);
    }

    @Test
    public void findByName(){
        Member m1 = new Member();
        m1.setName("spring1");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("spring2");
        repository.save(m2);

        Member rst = repository.findByName("spring2").get();
        Assertions.assertEquals(m2,rst);
    }

    @Test
    public void findAll(){
        Member m1 = new Member();
        m1.setName("spring1");
        repository.save(m1);

        Member m2 = new Member();
        m2.setName("spring2");
        repository.save(m2);

        List<Member> rst = repository.findAll();

        Assertions.assertEquals(rst.size(),2);
    }
}
