using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpiderPatrolScript : SpiderBase
{


    GameObject[] wayPoints;
    int currentPosition;
    
    
    private void Awake() {
        wayPoints = GameObject.FindGameObjectsWithTag("WayPoint");
        for(int i=0;i<wayPoints.Length;i++){
        Debug.Log(wayPoints[i]);

        }
    }
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
       base.OnStateEnter(animator,stateInfo,layerIndex);
       currentPosition = 0;
       Debug.Log(currentPosition);
    }

    
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
       if(wayPoints.Length==0){
           return;
       } if(Vector3.Distance(wayPoints[currentPosition].transform.position, enemy.transform.position) < 3.0f){
            currentPosition++;
            if(currentPosition >= wayPoints.Length){
                currentPosition =0;
            }
        }
        agent.SetDestination(wayPoints[currentPosition].transform.position);
    
    
    
    
    
    
    
    
    
    

    
    
    }

    
    
    
    
    

    
    
    
    
    

    
    
    
    
    
}
