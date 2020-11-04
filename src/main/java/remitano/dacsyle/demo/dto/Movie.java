package remitano.dacsyle.demo.dto;

import java.util.Date;


public class Movie
{
	private String title;
	private String youtubeUrl;
	private String description;
	private String embedId;
	private Date createdDate;
	private String createdBy;

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

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}
}
