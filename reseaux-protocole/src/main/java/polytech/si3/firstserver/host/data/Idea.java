package polytech.si3.firstserver.host.data;

import polytech.si3.User;
import polytech.si3.replies.IdeaReply;
import polytech.si3.requests.IdeaCreationRequest;

/**
 * Created by david on 07/05/2016.
 */
public class Idea {
    private String title, description;
    private String managerId, authorId;
    private int id, status;
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

    public void reset(){
        this.status = 0;
    }

    public void validate(){
        this.status = 1;
    }

    public void deny(){
        this.status = 2;
    }

    public User author(Users users){
        UserData authorData = users.findID(this.authorId);
        User author;
        try{
            author = new User(authorData.type(),authorData.name(),authorData.surname(),authorData.email(),authorData.id());
        }
        catch(Exception e){
            author = null;
        }

        return author;
    }

    public User manager(Users users){
        UserData managerData = users.findID(this.managerId);
        User manager;
        try{
            manager = new User(managerData.type(),managerData.name(),managerData.surname(),managerData.email(),managerData.id());
        }
        catch(Exception e){
            manager = null;
        }

        return manager;
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
