package kr.bit.model;

// JDBC -> Mybatis, JPA
// DAO : Data access object

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MemberDAO {

    // JDBC -> MyBatis
    // JDBC 연결을 위해 필요했던 Connection, PreparedStatement, ResultSet은
    // MyBatis API 안에 포장되어 연결됨
    // 다른 class가 필요함
    // docs 보고,, xml로 부터 어떤 객체 하나를 만들어야 함
    // SqlSessionFactory
    // config.xml 로 부터 SqlSessionFactory 를 만들어 내는 작업
    // Mybatis 에서는 connection 을 sqlSession이라고 부른다
    // sql session들이 여러개 모어져 있는 곳이 SqlSessionFactory

    private static SqlSessionFactory sqlSessionFactory;
    // sqlSessionFactory 안에는 sqlSession 여러개가 들어있음
    // 이것들이 db연결을 위한 각각의 객체

    // 초기화 블럭 - 프로그램 실행 시 딱 한번만 실행되는 코드
    static {
        try {
            String resource = "kr/bit/mybatis/config.xml";
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource); // 읽기
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            }

    public List<MemberVO> memberList() {
        SqlSession session = sqlSessionFactory.openSession();
//        session은 config.xml파일을 가지고 만들었고, 이 xml 파일 내에는
//        mapper 의 경로 및 이름 까지 지정이 되어 있음
//        자기가 실행해야 될 sql이 들어있는 태그의 id를 지정해 주는 것
        List<MemberVO> memberList = session.selectList("memberList");
        session.close(); // 반납
        return memberList;
        }

    public int memberInsert(MemberVO vo) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.insert("memberInsert", vo);
        session.commit();
        session.close();
        return cnt;
    }

    public int memberDelete(int num) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.delete("memberDelete", num);
        session.commit();
        session.close();
        return cnt;
    }

    public MemberVO memberContent(int num) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberVO memberVO = session.selectOne("memberContent", num);
            // selectOne이 내가 해야될 작업, 쿼리 날리고, db에서 한사람 가져와서 vo로 묶어주는 작업을
            // 알아서 다 해줌
        session.close();
        return memberVO;
    }

    public int memberUpdate(MemberVO memberVO) {
        SqlSession session = sqlSessionFactory.openSession();
        int cnt = session.update("memberUpdate", memberVO);
        session.commit();
        session.close();
        return cnt;
    }

    public String memberLogin(MemberVO memberVO) {
        SqlSession session = sqlSessionFactory.openSession();
        String memberName = session.selectOne("memberLogin", memberVO);
        session.close();
        return memberName;
    }


    public String memberDbcheck(String memberId) {
        SqlSession session = sqlSessionFactory.openSession();
        String chkdId = session.selectOne("memberDbcheck", memberId);
        System.out.println("chkdId = " + chkdId);
        session.close();
        String isDouble = "NO";
        if (chkdId != null) {
            //!= -> null 이 아니다.
            isDouble = "YES";
        }
        return isDouble;
    }
}


