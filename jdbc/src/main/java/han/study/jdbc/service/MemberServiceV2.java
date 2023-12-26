package han.study.jdbc.service;

import han.study.jdbc.domain.Member;
import han.study.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepository;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException{
        Connection conn = dataSource.getConnection();
        try{
            conn.setAutoCommit(false);
            bizLogic(conn, fromId, toId, money);
            conn.commit();
        }catch (Exception e){
            conn.rollback();
            throw new IllegalStateException(e);
        }finally {
            release(conn);
        }
    }

    private void bizLogic(Connection conn, String fromId, String toId, int money) throws SQLException{
        Member fromMember = memberRepository.findById(conn, fromId);
        Member toMember = memberRepository.findById(conn, toId);

        memberRepository.update(conn, fromId, fromMember.getMoney()-money);
        validation(toMember);
        memberRepository.update(conn,toId, toMember.getMoney()+money);
    }

    private void release(Connection conn){
        if (conn !=null){
            try{
                conn.setAutoCommit(true);
                conn.close();
            }catch (Exception e){
                log.info("error", e);
            }
        }
    }

    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

}
