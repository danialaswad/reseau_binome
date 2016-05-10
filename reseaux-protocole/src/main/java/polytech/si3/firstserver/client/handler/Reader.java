package polytech.si3.firstserver.client.handler;

import polytech.si3.User;
import polytech.si3.replies.*;
import polytech.si3.replies.Error;

/**
 * Created by danialaswad on 10/05/2016.
 */
public class Reader {

    public void error(Object object){
        Error e = (Error) object;
        System.out.print(e.errorType().toString() + " " + e.reason() + "\n" );
    }

    public void idealistreply(Object object){
        IdeaListReply ideaList = (IdeaListReply) object;
        for (IdeaPreviewReply idea : ideaList.ideas()){
            System.out.println("idea id : "+ idea.id() + " title : " + idea.title() + " status : " + idea.status());
        }
    }

    public void ideapreviewreader(Object object){
        IdeaPreviewReply idea = (IdeaPreviewReply) object;
        System.out.println("[idea id : " +idea.id() +"], [author : " + idea.author().name() + "], [manager : " + idea.manager().name()
                +  "], [status : " + idea.status() + "], [title : " + idea.title()+"]");
    }

    public void ideareply(Object object){
        IdeaReply idea = (IdeaReply) object;
        ideapreviewreader(idea);
        System.out.println("description : " + idea.description());
        System.out.println("interested : ");
        for (User u : idea.interested()){
            usereply(u);
            System.out.println();
        }
        System.out.println("participant : ");
        for (User u : idea.participants()){
            usereply(u);
            System.out.println();
        }
    }

    public void ideaid(Object object){
        IdeaId idea = (IdeaId) object;
        System.out.println("Idea has been created");
    }

    public void usereply(Object object){
        User user = (User) object;
        System.out.print("\t\t[id : " + user.id() + "], [name : " + user.name()+"]");
    }

    public void userlistreply(Object object){
        UserListReply users = (UserListReply) object;
        for (User u : users.users()){
            usereply(u);
            System.out.println();
        }
    }

    public void success(Object object){
        Success success = (Success) object;
    }

}

