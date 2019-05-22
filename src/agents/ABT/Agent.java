package agents.ABT;
import org.python.util.PythonInterpreter;
import org.python.core.*;
import java.io.*;
/**
 * Interface for agents that want to play in the framework
 * @author AhmedKhalifa
 */
public class Agent implements MarioAgent {
    /**
     * initialize and prepare the agent before the game starts
     * @param model a forward model object so the agent can simulate or initialize some parameters based on it.
     * @param timer amount of time before the agent has to return
     */
    void initialize(MarioForwardModel model, MarioTimer timer){
    /**
     * get mario current actions
     * @param model a forward model object so the agent can simulate the future.
     * @param timer amount of time before the agent has to return the actions.
     * @return an array of the state of the buttons on the controller
     */
     interp = new PythonInterpreter();
     interp.exec("from main import *");
   }
    boolean[] getActions(MarioForwardModel model, MarioTimer timer){
    /**
     * Return the name of the agent that will be displayed in debug purposes
     * @return
     */
     int[][] sensor = model.getScreenCompleteObservation(2,2);
     boolean fire = (model.gerMarioMode() == 2) ? true : false;
     interp.set("result", new PyArray());
     interp.set("sensor", sensor);
     interp.set("fire", fire);
     interp.exec("result = Mario_agent(sensor,fire)");
     PyArray action = (PyArray)interp.get("result");
   }
    String getAgentName();
}
