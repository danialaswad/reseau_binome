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
        int id;
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
                id = ((IdeaInformationRequest) request).ideaId();
                IdeaInformationProcess ideaInformationProcess = new IdeaInformationProcess(users,clientIP,ideas,id);
                response = ideaInformationProcess.process();
                break;

            case USER_PARTICIPATION:
                id = ((UserParticipationRequest) request).ideaId();
                UserParticipationProcess userParticipationProcess = new UserParticipationProcess(users,clientIP,ideas,id);
                response = userParticipationProcess.process();
                break;

            case USER_LIST_FROM_IDEA:
                id = ((UserListRequest) request).ideaId();
                UserListProcess userListProcess = new UserListProcess(users,clientIP,ideas,id);
                response = userListProcess.process();
                break;

            case IDEA_VALIDATION:
                id = ((IdeaValidateRequest) request).ideaId();
                IdeaValidateProcess ideaValidateProcess = new IdeaValidateProcess(users,clientIP,ideas,id);
                response = ideaValidateProcess.process();
                break;

            case IDEA_DENY:
                id = ((IdeaDeniedRequest) request).ideaId();
                String denyReason = ((IdeaDeniedRequest) request).reason();
                IdeaDeniedProcess ideaDeniedProcess = new IdeaDeniedProcess(users,clientIP,ideas,id,denyReason);
                response = ideaDeniedProcess.process();
                break;

            case ACCEPT_USER:
                String userId = ((AcceptUserRequest) request).userId()+"";
                id = ((AcceptUserRequest) request).ideaId();
                AcceptUserProcess acceptUserProcess = new AcceptUserProcess(users,clientIP,ideas,userId,id);
                response = acceptUserProcess.process();
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
