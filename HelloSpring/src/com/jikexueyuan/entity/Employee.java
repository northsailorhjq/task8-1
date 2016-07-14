package com.jikexueyuan.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	/**
	 * 员工类。
	 */
		private Integer id;
		private String name;
		private Integer age;
		private String gender;
		
		public Employee() {
			super();
		}
		
		public Employee(Integer id, String name, Integer age, String gender) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.gender = gender;
		}
		
		public Employee(String name, Integer age, String gender) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

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
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", age=" + age
					+ ", gender=" + gender + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
}
