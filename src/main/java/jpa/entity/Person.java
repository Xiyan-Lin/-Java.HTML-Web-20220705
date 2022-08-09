package jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@NamedQueries({
	@NamedQuery(name="Person.findAll", query="select p from Person p"),
	@NamedQuery(name="Person.findByAge", query="select p from Person p where p.age >= :ageValue"),
	@NamedQuery(name="Person.findByName", query="select p from Person p where p.name like :nameValue"),
	@NamedQuery(name="Person.findByAgeBetween", query="select p from Person p where p.age between :min and :max"),
})
public class Person implements Serializable {
	
	@Id // 主鍵設定
	@GeneratedValue(strategy = GenerationType.AUTO) // 主鍵內容新增策略
	private Integer id;
	
	@Column(name = "name", length = 50, nullable = false, unique = true) // 資料欄位設定
	private String name; 
	
	@Column
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
