package polytech.si3.firstserver.host.process;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.IdeaId;
import polytech.si3.replies.IdeaReply;
import polytech.si3.replies.Reply;
import polytech.si3.replies.UserListReply;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 08/05/2016.
 */
public abstract class IdeaProcess extends Process {
    protected Ideas ideas;
    protected Idea idea;

    public IdeaProcess(Users users, String adress, Ideas ideas, Idea idea) {
        super(users, adress);
        this.ideas = ideas;
        this.idea = idea;
    }

    /**
     * Utilisée uniquement si toutes les conditions de succes sont valides
     * C'est pourquoi on n'a pas besoin d'encore vérifier que les utilisateurs
     * auteurs et managers existent
     * @return
     */
    public IdeaReply ideaReply(){

        User author = idea.author(users);
        User manager = idea.manager(users);

        List<String> partInt = idea.getParticipantsID();
        List<User> participants = new ArrayList();
        List<User> interested = new ArrayList();

        for(int i = 0; i < partInt.size(); i++){
            String id = partInt.get(i);
            UserData userData = idea.getParticipant(id,users);
            User user = new User(userData.type(),userData.name(),userData.surname(),userData.email(),userData.id());
            if(userData.getStatus() == 1)
                interested.add(user);
            else
                participants.add(user);


        }

        return new IdeaReply(idea.id(),idea.status(),author,manager,idea.title(),idea.description(),interested,participants);
    }

    public UserListReply userListReply(){
        User author = idea.author(users);
        User manager = idea.manager(users);
        List<User> participants = idea.participants(users);

        List<User> reply = new ArrayList();

        reply.add(author);
        reply.add(manager);
        for(int i = 0; i < participants.size(); i++)
            reply.add(participants.get(i));

        return new UserListReply(reply);
    }

    public IdeaId ideaId(){
        return new IdeaId(idea.id());
    }

}
