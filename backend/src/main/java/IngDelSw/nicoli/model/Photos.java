// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

/************************************************************/
package IngDelSw.nicoli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "photos")
public class Photos {
	/**
	 * 
	 */
	@Id
	@Column(name = "id")
	private Integer id;
	/**
	 * 
	 */
	@Column(name = "visit_id")
	private Integer visit_id;
	/**
	 * 
	 */
	@Column(name = "image")
	private String image;
	/**
	 * 
	 */
	@Column(name = "localization_view_id")
	private Integer localization_view_id;
	/**
	 * 
	 */
	@Column(name = "status")
	private String status;
	/**
	 * 
	 */
	@Column(name = "rejected_note")
	private String rejected_note;
}
