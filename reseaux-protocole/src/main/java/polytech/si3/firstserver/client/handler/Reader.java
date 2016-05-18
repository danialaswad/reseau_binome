package si3.firstserver.client.handler;

import si3.User;
import si3.replies.*;
import si3.replies.Error;

/**
 * Created by danialaswad on 10/05/2016.
 */
public class Reader {

    /**
     * Error type message reader
     * Prints error message
     * @param object
     */
    public void error(Object object){
        Error e = (Error) object;
        System.out.print(e.errorType().toString() + " " + e.reason() + "\n" );
    }

    /**
     * Idea List type message reader
     * Prints the list of idea
     * format : [idea id: [id] title: [title] status: [status] ]
     * @param object
     */
    public void idealistreply(Object object){
        IdeaListReply ideaList = (IdeaListReply) object;
        for (IdeaPreviewReply idea : ideaList.ideas()){
            System.out.println("[idea id : "+ idea.id() + " title : " + idea.title() + " status : " + idea.status()+" ]");
        }
    }

    /**
     * Idea preview type message reader
     * Prints the information of an idea
     * format: [idea id : [id] ],[author : [name] ], [manager : [name] ], [status : [status] ], [title : [title] ]
     * @param object
     */
    public void ideapreviewreader(Object object){
        IdeaPreviewReply idea = (IdeaPreviewReply) object;
        System.out.println("[idea id : " +idea.id() +" ], [author : " + idea.author().name() + " ], [manager : " + idea.manager().name()
                +  " ], [status : " + idea.status() + " ], [title : " + idea.title()+" ]");
    }

    /**
     * Idea type message reader
     * Prints the information of an idea including description, interested and participants
     * format : idea preview
     *          description :
     *          interested :
     *          participants:
     * @param object
     */
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

    /**
     * Idea creation message reply
     * Prints a confirmation that the idea has been created
     * @param object
     */
    public void ideaid(Object object){
        IdeaId idea = (IdeaId) object;
        System.out.println("Idea [id "+ idea.id()+ "] has been created");
    }

    /**
     * User type message reply
     * Prints the id and the name of a user
     * format : [id : [id] ], [name : [name] ]
     * @param object
     */
    public void usereply(Object object){
        User user = (User) object;
        System.out.print("\t\t[id : " + user.id() + "], [name : " + user.name()+"]");
    }

    /**
     * User list type message reply
     * Prints a list of users
     * format : cf usereply()
     * @param object
     */
    public void userlistreply(Object object){
        UserListReply users = (UserListReply) object;
        for (User u : users.users()){
            usereply(u);
            System.out.println();
        }
    }

    /**
     * Success type message reply
     * @param object
     */
    public void success(Object object){
        Success success = (Success) object;
    }

}

