package polytech.si3.firstserver.host.process;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.IdeaReply;
import polytech.si3.replies.Reply;

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

}
