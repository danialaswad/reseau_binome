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
public class IdeaCreationProcess extends Process {

    private Ideas ideas;
    private Idea idea;

    public IdeaCreationProcess(Users users, String adress, Ideas ideas, IdeaCreationRequest idea) {
        super(users, adress);
        this.ideas=ideas;
        this.idea=new Idea(idea);
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

    @Override
    public Reply process() {

        if(!checkAuthentified())
            return error = new Error(ErrorType.NOT_AUTHENTICATED,"User with adress " + adress +" is not connected!");

        if(users.findID(idea.managerId()) == null)
            return error = new Error(ErrorType.INVALID_MANAGER, "No user was found with id " + idea.managerId());

        if(ideas.contains(idea))
            return error = new Error(ErrorType.IDEA_HAS_BEEN_STARTED,"Idea has already been started by manager " + ideas.find(idea).managerId());

        if(idea.title().length()==0)
            return error = new Error(ErrorType.INVALID_TITLE,"Title " + idea.title() + " is not valid");

        if(ideas.size() >= ideas.MAX_SIZE)
            return error = new Error(ErrorType.TOO_MANY_IDEAS,"Max size " + ideas.MAX_SIZE + " has been reached for ideas");

        ideas.add(idea);
        return ideaReply();
    }

}
