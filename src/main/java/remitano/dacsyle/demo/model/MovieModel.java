package remitano.dacsyle.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
public class MovieModel implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;
	private String youtubeUrl;
	private String description;
	private String embedId;
	private Date createdDate;
	private String createdBy;

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getEmbedId()
	{
		return embedId;
	}

	public void setEmbedId(String embedId)
	{
		this.embedId = embedId;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getYoutubeUrl()
	{
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl)
	{
		this.youtubeUrl = youtubeUrl;
	}

	@Override
	public String toString()
	{
		return "MovieModel{" + "id=" + id + ", title='" + title + '\'' + ", youtubeUrl='" + youtubeUrl + '\'' + ", description='"
				+ description + '\'' + ", embedId='" + embedId + '\'' + ", createdDate=" + createdDate + ", createdBy='" + createdBy
				+ '\'' + '}';
	}
}
