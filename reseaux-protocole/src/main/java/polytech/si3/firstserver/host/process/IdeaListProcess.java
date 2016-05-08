package polytech.si3.firstserver.host.process;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.*;
import polytech.si3.replies.Error;
import polytech.si3.requests.IdeaListRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 08/05/2016.
 */
public class IdeaListProcess extends Process {
    private Ideas ideas;


    public IdeaListProcess(Users users, String adress, Ideas ideas) {
        super(users, adress);
        this.ideas = ideas;
    }

    public IdeaListReply ideaListReply(){
        List<IdeaPreviewReply> list = new ArrayList();

        for(int i = 0; i < ideas.size(); i++){
            Idea idea = ideas.get(i);
            IdeaPreviewReply ideaPreviewReply = new IdeaPreviewReply(idea.id(),idea.status(),
                                                idea.author(users),idea.manager(users),idea.title());
            list.add(ideaPreviewReply);
        }

        return new IdeaListReply(list);
    }

    @Override
    public Reply process() {
        if(!checkAuthentified())
            return error = new Error(ErrorType.NOT_AUTHENTICATED,"User with adress " + adress +" is not connected!");

        return ideaListReply();
    }
}
