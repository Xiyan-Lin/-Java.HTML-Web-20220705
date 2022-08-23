package jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.entity.Employee;
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
	
	// 新增 Employee
	public synchronized void addEmployee(Employee employee) {
		EntityTransaction etx = em.getTransaction(); // 取得交易物件(交易:新增,修改,刪除)
		etx.begin(); // 開始
		em.persist(employee);  // 存入 employee
		etx.commit(); // 提交
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
	
	// 查詢全部
	public List<Person> queryAllPerson() {
		//Query query = em.createQuery("select p from Person p"); // JPQL
		//Query query = em.createQuery("from Person p", Person.class); // JPQL
		
		Query query = em.createNamedQuery("Person.findAll");  // NamedQuery 版
		List<Person> list = query.getResultList();
		return list;
	}
	
	// 查詢多筆 by age
	public List<Person> queryPersonByAge(Integer age) {
		//String sql = "select p from Person p where p.age >= :ageValue";
		//Query query = em.createQuery(sql);
		//query.setParameter("ageValue", age);
	
		Query query = em.createNamedQuery("Person.findByAge")
						.setParameter("ageValue", age); // NamedQuery 版
		List<Person> list = query.getResultList();
		return list;
	}
	
	// 查詢多筆 by name
	public List<Person> findByName(String name) {
		return em.createNamedQuery("Person.findByName")
				.setParameter("nameValue", name)
				.getResultList();
	}
	
	// 查詢多筆 age 區間
	public List<Person> findByAgeBetween(Integer min, Integer max) {
		return em.createNamedQuery("Person.findByAgeBetween")
				 .setParameter("min", min)
				 .setParameter("max", max)
				 .getResultList();
	}
	
	// 修改
	public synchronized void updatePerson(Person person) {
		// 判斷是否有此資料 ?
		if (getPerson(person.getId()) == null) return;
		// 修改程序
		EntityTransaction etx = em.getTransaction(); // 取得交易物件(交易:新增,修改,刪除)
		etx.begin(); // 開始
		em.merge(person);  // 修改 person
		etx.commit(); // 提交
	}
	
	// 刪除
	public synchronized void deletePerson(Integer id) {
		// 判斷是否有此資料 ?
		Person person = getPerson(id); 
		if (person == null) return;
		// 修改程序
		EntityTransaction etx = em.getTransaction(); // 取得交易物件(交易:新增,修改,刪除)
		etx.begin(); // 開始
		em.remove(person);  // 刪除 person
		etx.commit(); // 提交
	}
}








