using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpiderAttack : SpiderBase
{
    
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        base.OnStateEnter(animator,stateInfo,layerIndex);

    }

    
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        
         agent.stoppingDistance = 3;
         agent.SetDestination(player.transform.position);
    
    
    }
    }