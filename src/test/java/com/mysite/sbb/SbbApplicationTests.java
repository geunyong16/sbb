package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
//import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

//    @Autowired
//    private AnswerRepository answerRepository;

    @Test
    void testJpa(){
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요");
//        q1.setContent("sbb에 대해서 알고 싶습니다");
//        q1.setCreatDate(LocalDateTime.now());
//        this.questionRepository.save(q1);
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다");
//        q2.setContent("id는 자동으로 생성되나요");
//        q2.setCreatDate(LocalDateTime.now());
//        this.questionRepository.save(q2);
        /// ////////////////////////////
//        List<Question> all = this.questionRepository.findAll();
//        assertEquals(4, all.size());
//
//        Question q=all.get(0);
//        assertEquals("sbb가 무엇인가요",q.getSubject());
        /// ///////////////////////////////
//        Optional<Question> op = questionRepository.findById(1);
//        if(op.isPresent()){
//            Question question = op.get();
//            assertEquals("sbb가 무엇인가요", question.getSubject());
//        }
        /// ////////////////////////////////
//        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요");
//        assertEquals(1,q.getId());
        ///   /////////////////////////////
        Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요", "sbb에 대해서 알고 싶습니다");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpa2(){
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question question = qList.get(0);
//        assertEquals("sbb가 무엇인가요", question.getSubject());
        /// /////////////////////////////////
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        q.setSubject("수정된 제목");
//        this.questionRepository.save(q);
    /// ////////////////////////////////////////
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }

    @Test
    void testJpa3(){
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다");
//        a.setQuestion(q);
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);
        /// ///////////////////////////////////////
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2,a.getQuestion().getId());
        /// /////////////////////////////////////
    }

    @Test
    @Transactional
    void testJpa4(){
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnwserList();
        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다", answerList.getFirst().getContent());
    }

    @Test
    void contextLoads() {
    }

}
