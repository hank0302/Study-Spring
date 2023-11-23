package han.hellospring;

import han.hellospring.aop.TimeTraceAop;
import han.hellospring.repository.JdbcMemberRepository;
import han.hellospring.repository.JpaMemberRepository;
import han.hellospring.repository.MemberRepository;
import han.hellospring.repository.MemoryMemberRepository;
import han.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    private final DataSource dataSource;
//    private final EntityManager em;

//    @Autowired
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }



//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //return new JdbcMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
