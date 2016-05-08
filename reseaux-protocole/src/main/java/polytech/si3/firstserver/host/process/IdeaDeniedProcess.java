package polytech.si3.firstserver.host.process;

import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.Error;
import polytech.si3.replies.ErrorType;
import polytech.si3.replies.Reply;
import polytech.si3.replies.Success;

/**
 * Created by david on 08/05/2016.
 */
public class IdeaDeniedProcess extends IdeaProcess {
    private int id;
    private String reason;

    public IdeaDeniedProcess(Users users, String adress, Ideas ideas, int id, String reason) {
        super(users, adress, ideas, ideas.findID(id));
        this.id = id;
        this.reason = reason;
    }

    @Override
    public Reply process() {
        if(!checkAuthentified())
            return error = new Error(ErrorType.NOT_AUTHENTICATED,"User with adress " + adress +" is not connected!");

        if(idea == null)
            return error = new Error(ErrorType.IDEA_NOT_FOUND, "No idea with id " + id + " was found");

        if(!idea.managerId().equals(userData.id()) && userData.type() == 0)
            return error = new Error(ErrorType.NO_PERMISSION,"You have no permission to deny this idea");

        idea.deny(reason);
        return new Success();
    }
}
