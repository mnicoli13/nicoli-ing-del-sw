// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

/************************************************************/
package IngDelSw.nicoli.model;

import IngDelSw.nicoli.model.enums.Gender;

import jakarta.persistence.*;

@Entity
@Table(name = "localization")
public class Localization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Id
	@Column(name = "localization_id")
	private Integer localizationId;

	@Column (name = "gender")
	private Gender gender;

	@Column(name = "description")
	private String description;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLocalizationId() {
		return localizationId;
	}

	public void setLocalizationId(Integer localization_id) {
		this.localizationId = localization_id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}