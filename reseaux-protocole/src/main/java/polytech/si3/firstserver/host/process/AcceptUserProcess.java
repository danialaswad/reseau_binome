package polytech.si3.firstserver.host.process;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.Error;
import polytech.si3.replies.ErrorType;
import polytech.si3.replies.Reply;
import polytech.si3.replies.Success;

/**
 * Created by david on 08/05/2016.
 */
public class AcceptUserProcess extends IdeaProcess {
    private UserData userInterested;
    private int ideaId;
    private String userId;

    public AcceptUserProcess(Users users, String adress, Ideas ideas,String userId, int ideaId) {
        super(users, adress, ideas, ideas.findID(ideaId));
        userInterested = users.findID(userId);
        this.userId = userId;
        this.ideaId = ideaId;

    }

    @Override
    public Reply process() {

//        System.out.println(idea.authorId() + " : " + idea.managerId());
        if(!checkAuthentified())
            return error = new Error(ErrorType.NOT_AUTHENTICATED,"User with adress " + adress +" is not connected!");

        if(!idea.authorId().equals(users.findAdress(adress).id()) && !idea.managerId().equals(users.findAdress(adress).id()))
            return error = new Error(ErrorType.NO_PERMISSION,"You don't have the rights for this idea");

        if(idea.authorId().equals(userId) || idea.managerId().equals(userId))
            return error = new Error(ErrorType.NO_PERMISSION,"User " + userId + " is already involved in this idea");
        if(idea.getParticipant(userId,users) != null){

            if(idea.getParticipant(userId,users).getStatus() == 1){
                idea.getParticipant(userId,users).setStatus(2);
                return new Success();
            }

            return error = new Error(ErrorType.NO_PERMISSION,"User " + userId + " is already accepted for this idea");
        }

        return error = new Error(ErrorType.NO_PERMISSION,"User " + userId + " was not found in idea's interested users");
    }
}
