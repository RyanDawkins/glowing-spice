package com.ryanddawkins.glowing_spice;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import com.ryanddawkins.glowing_spice.Response;
import com.ryanddawkins.glowing_spice.NullJsonException;
import com.ryanddawkins.glowing_spice.JsonCommandNotFoundException;

/**
 * Class to handle and deal with the various commands sent to the server.
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 */
public class Request
{

	private String command;
	private Response response;
	private String json;

	/**
	 * Takes JSON String and decides what to do in the parse
	 *
	 * @param String json
	 */
	public Request(String json)
	{
		this.json = json;
		this.command = null;
		this.response = null;
	}

	/**
	 * Class to parse the JSON string into useable data
	 *
	 * @throws NullJsonException
	 * @throws JsonCommandNotFoundException
	 * @return Request this
	 */
	public Request parse() throws NullJsonException, JsonCommandNotFoundException
	{
		JsonElement parentElement = new JsonParser().parse(this.json);
		if(parentElement.isJsonObject())
		{
			JsonObject jobject = parentElement.getAsJsonObject();
			if(jobject.has("command"))
			{
				this.command = jobject.get("command").getAsString();
			}
			else
			{
				throw new JsonCommandNotFoundException("No Command in JSON String");
			}
		}
		else if(parentElement.isJsonArray())
		{
			JsonArray jarray = parentElement.getAsJsonArray();
			JsonObject jobject = getCommandJsonObject(jarray);
			if(jobject != null && jobject.has("command"))
			{
				this.command = jobject.getAsString();
			}
			else
			{
				throw new JsonCommandNotFoundException("Json Command not Found");
			}
		}
		else if(parentElement.isJsonNull())
		{	
			throw new NullJsonException("Parent node in JSON is null");
		}
		return this;
	}

	/**
	 * Recursive method to find the command json object
	 *
	 * @param JsonArray je
	 * @return JsonObject commandObject
	 */
	public JsonObject getCommandJsonObject(JsonArray je)
	{
		for(int x = 0; x < je.size(); x++)
		{
			if(je.isJsonObject() && je.getAsJsonObject().has("command"))
			{
				return je.getAsJsonObject();
			}
			else if(je.isJsonArray())
			{
				return getCommandJsonObject(je);
			}
		}
		return null;
	}

	/**
	 * Traditional getter to grab which command
	 *
	 * @return String command
	 */
	public String getCommand()
	{
		return this.command;
	}

	/**
	 * Sets command to the object
	 *
	 * @param String command
	 * @return Request
	 */
	public Request setCommand(String command)
	{
		this.command = command;
		return this;
	}

	/**
	 * Returns json string we save on initialization
	 *
	 * @return String json
	 */
	public String getJsonString()
	{
		return this.json;
	}

	/**
	 * Chainable setter for the jsonstring
	 *
	 * @param String jsonString
	 * @return Request this
	 */
	public Request setJsonString(String jsonString)
	{
		this.json = jsonString;
		return this;
	}

}