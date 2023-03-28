package questJpa.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("video")
public class VideoProjecteur extends Materiel {

	@Column(name = "video_resolution")
	private String resolution;
	@OneToOne(mappedBy = "videoProjecteur")
	private Salle salle;

	public VideoProjecteur() {

	}

	public VideoProjecteur(String code, String resolution) {
		super(code);
		this.resolution = resolution;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
