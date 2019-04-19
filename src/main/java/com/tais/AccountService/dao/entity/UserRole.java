package com.tais.AccountService.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "ROLE_ID")
	private String id;

	@Column(name = "ROLE_NAME", length = 255)
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleName name;	
	
//	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    private List<UserProfile> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	

//	public List<UserProfile> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserProfile> users) {
//		this.users = users;
//	}

}
