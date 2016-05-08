package polytech.si3.firstserver.host.process;

import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.firstserver.host.process.IdeaProcess;
import polytech.si3.replies.Error;
import polytech.si3.replies.ErrorType;
import polytech.si3.replies.Reply;
import polytech.si3.replies.Success;

/**
 * Created by david on 08/05/2016.
 */
public class UserParticipationProcess extends IdeaProcess {
    private int id;

    public UserParticipationProcess(Users users, String adress, Ideas ideas, int id) {
        super(users, adress, ideas, ideas.findID(id));
        this.id = id;
    }

    @Override
    public Reply process() {
        if(!checkAuthentified())
            return error = new Error(ErrorType.NOT_AUTHENTICATED,"User with adress " + adress +" is not connected!");

        if(idea == null)
            return error = new Error(ErrorType.IDEA_NOT_FOUND, "No idea with id " + id + " was found");

        if(idea.status() == 1)
            return error = new Error(ErrorType.IDEA_HAS_BEEN_STARTED,"Idea " + id + " has already been started by manager " + idea.managerId());

        if(userData.getStatus() == 1)
            return error = new Error(ErrorType.NO_PERMISSION,"You are already interested for an idea : " + userData.getParticipationId());

        if(idea.managerId().equals(userData.id()) || idea.authorId().equals(userData.id()) || userData.getStatus() == 2)
            return error = new Error(ErrorType.NO_PERMISSION,"You are already involved in this idea");

        userData.setParticipationId(""+idea.id());
        idea.addParticipant(userData.id());
        userData.setStatus(1);
        return new Success();
    }
}
