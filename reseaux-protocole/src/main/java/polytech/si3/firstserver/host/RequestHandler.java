package polytech.si3.firstserver.host;

import polytech.si3.User;
import polytech.si3.firstserver.host.data.Idea;
import polytech.si3.firstserver.host.data.Ideas;
import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.firstserver.host.process.*;
import polytech.si3.replies.*;
import polytech.si3.replies.Error;
import polytech.si3.requests.*;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class RequestHandler {

    private static Users users = new Users();
    private static Ideas ideas = new Ideas();

    private Request request;
    private Reply response;

    private String clientIP;

    private RequestType requestType;

    public RequestHandler(Object object, String clientIP){
        this.request = (Request) object;
        this.clientIP = clientIP;
    }

    /**
     * Method call for interpreting the request
     */
    public void readRequest(){
        // To do
        requestType = request.requestType();
       // System.out.println(users);

        switch(requestType){
            case USER_AUTHENTIFICATION:
                UserData userData = new UserData((((UserAuthentificationRequest) request).user()));
                response =  new Authentification(userData,users,clientIP).process();

                break;

            case IDEA_CREATION:
                IdeaCreationRequest idea =(IdeaCreationRequest) request;
                IdeaCreationProcess p = new IdeaCreationProcess(users,clientIP,ideas,idea);
                response = p.process();
               // p.printError();
                break;

            case IDEA_LIST:
                IdeaListProcess ideaListProcess = new IdeaListProcess(users,clientIP,ideas);
                response = ideaListProcess.process();
                break;

            case IDEA_INFOROMATION:
                int id = ((IdeaInformationRequest) request).ideaId();
                IdeaInformationProcess ideaInformationProcess = new IdeaInformationProcess(users,clientIP,ideas,id);
                response = ideaInformationProcess.process();
                break;

            case USER_PARTICIPATION:
                int participationId = ((UserParticipationRequest) request).ideaId();
                UserParticipationProcess userParticipationProcess = new UserParticipationProcess(users,clientIP,ideas,participationId);
                response = userParticipationProcess.process();
                break;

            case USER_LIST_FROM_IDEA:
                response = new Success();
                break;

            case IDEA_VALIDATION:
                int ideaId = ((IdeaValidateRequest) request).ideaId();
                IdeaValidateProcess ideaValidateProcess = new IdeaValidateProcess(users,clientIP,ideas,ideaId);
                response = ideaValidateProcess.process();
                break;

            case IDEA_DENY:
                int denyId = ((IdeaDeniedRequest) request).ideaId();
                String denyReason = ((IdeaDeniedRequest) request).reason();
                IdeaDeniedProcess ideaDeniedProcess = new IdeaDeniedProcess(users,clientIP,ideas,denyId,denyReason);
                response = ideaDeniedProcess.process();
                break;

            case ACCEPT_USER:
                response = new Success();
                break;

            case DENY_USER:
                response = new Success();
                break;

            default:
                response  = new Error(ErrorType.NO_PERMISSION,"Unknown request");
                break;


        }

      //  System.out.println(requestType);
    }

    /**
     * Method call for response
     * @return Reply response to the request
     */
    public Object response(){
        System.out.println(users);
        return response;
    }
}
