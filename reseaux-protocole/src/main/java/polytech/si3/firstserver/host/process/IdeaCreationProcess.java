package polytech.si3.firstserver.host.process;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.*;
import polytech.si3.replies.Error;
import polytech.si3.requests.IdeaCreationRequest;

/**
 * Created by david on 07/05/2016.
 */
public class IdeaCreationProcess extends IdeaProcess {

    public IdeaCreationProcess(Users users, String adress, Ideas ideas, IdeaCreationRequest idea) {
        super(users, adress,ideas,new Idea(idea));
    }


    @Override
    public Reply process() {

        if(!checkAuthentified())
            return error = new Error(ErrorType.NOT_AUTHENTICATED,"User with adress " + adress +" is not connected!");

        if(users.findID(idea.managerId()) == null)
            return error = new Error(ErrorType.INVALID_MANAGER, "No user was found with id " + idea.managerId());

        if(ideas.contains(idea))
            return error = new Error(ErrorType.NO_PERMISSION,"Idea has already been created by " + ideas.find(idea).authorId());

        if(idea.title().length()==0)
            return error = new Error(ErrorType.INVALID_TITLE,"Title " + idea.title() + " is not valid");

        if(ideas.size() >= ideas.MAX_SIZE)
            return error = new Error(ErrorType.TOO_MANY_IDEAS,"Max size " + ideas.MAX_SIZE + " has been reached for ideas");

        idea.setAuthorId(users.findAdress(adress).id());
        ideas.add(idea);
        //System.out.println(idea.authorId());
        return ideaId();
        //return ideaReply();
    }

}
