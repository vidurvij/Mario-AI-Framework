from abtclass_mario import *
import b3 as b3

def Mario_agent(sensor,state):
    aug_leaf.sensor = sensor
    aug_leaf.fire = state
    obstacle = 100
    enemy = 1
    control = {'right': 3, 'fire': 5, 'jump': 4}
    tree = b3.BehaviorTree()
    #--------------------------C1----------------------#
    n0 = mario_state_condition()
    n1 = mario_leaf_condition(2,4,enemy)
    n2 = mario_leaf_action(control['fire'])
    c1 = b3.Sequence([n0,n1,n2])

    #--------------------------C4-----------------------#
    n5 = mario_leaf_condition(3,1,obstacle)
    n6 = mario_leaf_condition(3,2,obstacle)
    i1 = b3.Inverter(n5)
    i2 = b3.Inverter(n6)
    c4 = b3.Sequence([i1,i2])

    #--------------------------C3------------------------#
    n3 = mario_leaf_condition(2,2,obstacle)
    n4 = mario_leaf_condition(1,3,obstacle)
    c3 = b3.Priority([n3,n4,c4])

    #--------------------------C2-----------------------#
    n7 = mario_leaf_action(control['jump'])
    c2 = b3.Sequence([c3,n7])

    #--------------------------Root----------------------#
    n8 = mario_leaf_action(control['right'])
    root = b3.Priority([c1,c2,n8])
    ###################################################################
    tree.root = root

    return tree
