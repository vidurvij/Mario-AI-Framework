package agents.abt;


import engine.core.MarioAgent;
import engine.core.MarioTimer;
import engine.core.MarioForwardModel;



import org.python.util.PythonInterpreter;
import org.python.core.PyArray;
import org.python.core.*;
import java.io.*;


public class Agent implements MarioAgent {
    /**
     * initialize and prepare the agent before the game starts
     * @param model a forward model object so the agent can simulate or initialize some parameters based on it.
     * @param timer amount of time before the agent has to return
     */
    public  PythonInterpreter interp = new PythonInterpreter();
    public void initialize(MarioForwardModel model, MarioTimer timer){
    /**
     * get mario current actions
     * @param model a forward model object so the agent can simulate the future.
     * @param timer amount of time before the agent has to return the actions.
     * @return an array of the state of the buttons on the controller
     */

     interp.exec("from main import *");
   }
    public boolean[] getActions(MarioForwardModel model, MarioTimer timer){
    /**
     * Return the name of the agent that will be displayed in debug purposes
     * @return
     */
     int[][] sensor = model.getScreenCompleteObservation(2,2);
     boolean fire = (model.getMarioMode() == 2) ? true : false;
     // interp.set("result", new PyArray());
     interp.set("sensor", sensor);
     interp.set("fire", fire);
     interp.exec("result = Mario_agent(sensor,fire)");
     PyArray action = (PyArray)interp.get("result");
     boolean[] res = (boolean[]) action.getArray();
     // int a = action.__tojava__()[0];
     return res;
   }
    public String getAgentName(){
      return "ABT-Agent";
    }
}
