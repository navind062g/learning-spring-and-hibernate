package com.coding.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "course")
public class Course {

	// define our fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@OneToMany(mappedBy = "course", cascade = { CascadeType.ALL} )
	private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	// adding a convenience method
	public void addReview(Review theReview) {
		if(reviews == null) {
			this.reviews = new ArrayList<Review>();
		}
		
		this.reviews.add(theReview);
	}

	// define constructors
	public Course() {

	}

	public Course(String title) {
		this.title = title;
	}
	
	public Course(String title, Instructor theInstructor) {
		this.title = title;
		this.instructor = theInstructor;
	}

	// define getters and setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	// apply the annotations to the fields
	@Override
	public String toString() {
		return "Course [Id=" + Id + ", title=" + title + "]";
	}

}
