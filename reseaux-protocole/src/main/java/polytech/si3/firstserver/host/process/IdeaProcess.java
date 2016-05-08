package polytech.si3.firstserver.host.process;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.Users;
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

        return new IdeaReply(idea.id(),idea.status(),author,manager,idea.title(),idea.description());
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

}
