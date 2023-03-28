package questJpa.entites;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "salle")
public class Salle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salle_id")
	private Long id;
	@Column(name = "salle_nom")
	private String nom;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "salle_numero_rue", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "salle_rue")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "salle_cp", length = 50)),
			@AttributeOverride(name = "ville", column = @Column(name = "salle_ville")) })
	private Adresse adresse;
	@OneToOne
	@JoinColumn(name = "salle_video_id", foreignKey = @ForeignKey(name = "salle_video_id_fk"))
	private VideoProjecteur videoProjecteur;

	public Salle() {

	}

	public Salle(String nom, Adresse adresse, VideoProjecteur videoProjecteur) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.videoProjecteur = videoProjecteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public VideoProjecteur getVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(VideoProjecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		return Objects.equals(id, other.id);
	}

}
