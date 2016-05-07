package polytech.si3.firstserver.host.data;

import polytech.si3.replies.IdeaReply;
import polytech.si3.requests.IdeaCreationRequest;

/**
 * Created by david on 07/05/2016.
 */
public class Idea {
    private String title, description;
    private String managerId, authorId;
    int id, status;
    private static int idNumber = 1;


    public Idea(String title, String description, String managerId){
        this.title = title;
        this.description = description;
        this.managerId = managerId;
        this.authorId = managerId;

        this.id = idNumber;
        idNumber++;

        this.status = 0; //status started
    }

    public Idea(IdeaCreationRequest ideaCreationRequest){
        this.title = ideaCreationRequest.title();
        this.description = ideaCreationRequest.description();
        this.managerId = ""+ideaCreationRequest.managerId();
        this.authorId = ""+ideaCreationRequest.managerId();

        this.id = idNumber;
        idNumber++;

        this.status = 0;
    }

    public String title(){
        return title;
    }

    public String description(){
        return description;
    }

    public String managerId(){
        return managerId;
    }

    public String authorId(){
        return authorId;
    }

    public int id(){
        return id;
    }

    public int status(){
        return status;
    }

    @Override
    public boolean equals(Object o){
        Idea idea = (Idea) o;
        return (this.title.equals(idea.title)
                && this.description.equals(idea.description));
    }

    @Override
    public String toString(){
        return title+" | " + description + " | " + managerId;
    }
}
