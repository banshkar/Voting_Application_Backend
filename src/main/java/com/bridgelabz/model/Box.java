package com.bridgelabz.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Box {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "box")
	private List<Vote> votes;
	@OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
	@JoinColumn(name="condidateModel_id")
	private CondidateModel condidateModel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	public CondidateModel getCondidateModel() {
		return condidateModel;
	}
	public void setCondidateModel(CondidateModel condidateModel) {
		this.condidateModel = condidateModel;
	}
	@Override
	public String toString() {
		return "Box [id=" + id + ", votes=" + votes + ", condidateModel=" + condidateModel + "]";
	}
	

}
