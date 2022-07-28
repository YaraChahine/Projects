using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;
public class SpiderBase : StateMachineBehaviour
{
    public GameObject player;

    public GameObject enemy;

    public float speed = 2.0f;
    public float rotationSpeed = 2.0f;

    public float distance = 3.0f;

    public NavMeshAgent agent;
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        enemy = animator.gameObject;

        player = enemy.GetComponent<Enemy>().GetPlayer();

        agent = enemy.GetComponent<NavMeshAgent>();
    }

    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {

    }

    override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
       
    }

}
