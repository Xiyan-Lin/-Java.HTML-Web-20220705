package jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.entity.Person;

public class JPAService {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public JPAService() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}
	
	// 新增
	public synchronized void addPerson(Person person) {
		EntityTransaction etx = em.getTransaction(); // 取得交易物件(交易:新增,修改,刪除)
		etx.begin(); // 開始
		em.persist(person);  // 存入 person
		etx.commit(); // 提交
	}
	
	// 查詢單筆
	public Person getPerson(Integer id) {
		return em.find(Person.class, id);
	}
	
}
