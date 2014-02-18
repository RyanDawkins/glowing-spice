package com.ryanddawkins.glowing_spice;

/**
 * Class to hold a media file
 *
 * @author Ryan Dawkins
 * @since 0.3
 * @package com.ryanddawkins.glowing_spice
 */
public abstract class MediaFile <T extends MediaFile<T>>
{

	private String name;
	private String fileName;
	private boolean isDirectory;

	/**
	 * Method that should return this
	 *
	 * @return T this
	 */
	protected abstract T getThis();

	/**
	 * Constructor to create a movie instance and store it's "movie name"
	 *
	 * @param String fileName
	 */
	public MediaFile(String fileName)
	{
		// Removes file extension
		if(fileName.lastIndexOf('.') > -1)
		{
			this.name = fileName.substring(0, fileName.lastIndexOf('.'));
		}
		else
		{
			this.name = fileName;
		}
	}

	/**
     * Movie to set if is a directory
     * @param isDirectory
     * @return false
     */
    public T setIsDirectory(boolean isDirectory)
    {
        this.isDirectory = isDirectory;
        return getThis();
    }

	/**
     * Method to check if directory to make another request to grab more movie files
     *
     * @return boolean
     */
    public boolean isDirectory()
    {
        return this.isDirectory;
    }

	/**
	 * Chainable method to set file path
	 *
	 * @param String filePath
	 * @return Movie this
	 */
	public T setFilePath(String filePath)
	{
		this.fileName = filePath;
		return getThis();
	}

	/**
	 * Getter for filepath
	 *
	 * @return String filePath
	 */
	public String getFilePath()
	{
		return this.fileName;
	}

	/**
	 * Sets name of the movie and returns this
	 *
	 * @param String name
	 * @return Movie this
	 */
	public T setName(String name)
	{
		this.name = name;
		return getThis();
	}

	/**
	 * Returns name of the movie object
	 *
	 * @return String movie
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Sets file name and returns this for chainability
	 *
	 * @param String fileName
	 * @return Movie this
	 */
	public T setFileName(String fileName)
	{
		this.fileName = fileName;
		return getThis();
	}

	/**
	 * Returns fileName
	 *
	 * @return String fileName
	 */
	public String getFileName()
	{
		return this.fileName;
	}
}