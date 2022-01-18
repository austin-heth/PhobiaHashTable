
public class Phobias {
private String name;
private String description;
public Phobias()
{
	name = description = "none yet";	
}
//getters and setters below
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
//toString method overrides built in method and prints the name and description together
public String toString()
{
	return this.name+": "+this.description;
}
//method that will return true if the names equal each other and so do the descriptions
public boolean equals(Phobias aPhobias)
{
	return this.name.equals(aPhobias.getName())&&
			this.description.equals(aPhobias.getDescription());
}

}
