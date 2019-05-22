from abtclass_mario import *
from ABT_mario import *


state = True
sensor = [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,100,0,0,0],[0,0,0,0,0]]

def Mario_agent(sensor, state):
    model = Mario_agent(sensor,state)
    bb = b3.Blackboard()
    model.tick("MarioAgent", bb)
    return aug_leaf.action

# if __name__ == '__main__':
#     print(sensor[2][4])
#     model = Mario_agent(sensor,state)
#     bb = b3.Blackboard()
#     print("Kudi Punjaban")
#     # print aug_leaf.sensors
#     model.tick("MarioAgent", bb)
#     print(aug_leaf.action)
