import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      // 비영속
      Member member = new Member();
      member.setId(100L);
      member.setName("HelloJPA");

      // 영속
      System.out.println("=== Before ");
      em.persist(member);
      em.detach(member);
      System.out.println("After");
      List<Member> result = em.createQuery("select m from Member as m", Member.class)
          .setFirstResult(5)
          .setMaxResults(8)
          .getResultList();
      tx.begin();
      Member member1 = em.find(Member.class, 101L);
      Member member2 = em.find(Member.class, 101L);
      Member member3 = em.find(Member.class, 150L);
      List<Member> list = new ArrayList<>();
      list.add(member1);
      list.add(member2);
      list.add(member3);
      for (Member m: list) {
        tx.commit();
      }
      tx.commit();
      for (Member memb : result) {
        System.out.println("member.name = " + memb.getName());
      }
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
