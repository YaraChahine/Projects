using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Panda;
using UnityEngine.AI;

public class EnemyAI : MonoBehaviour
{

    Animator animator;
    Animation animation1;
    public NavMeshAgent agent;
    
    
    public GameObject player;

    
    void Start()
    {
         agent = this.gameObject.GetComponent<NavMeshAgent>();
         animation1=this.gameObject.GetComponent<Animation>();
         animator=this.gameObject.GetComponent<Animator>();
        player = GameObject.FindGameObjectWithTag("Player");
    }

    
    void Update()
    {
        
    }
    [Task]
    
    public void ChooseRandom(){
        Vector3 destination = new Vector3(Random.Range(-20,50),1,Random.Range(-772,-768));
        agent.SetDestination(destination);
        Task.current.Succeed();
    }
    
    
    
    
    
    
    [Task]
    public void MoveToDest(){
        animator.SetFloat("Walk",1);
        animator.SetBool("Hit2",false);
        if(Task.isInspected){
            if(agent.remainingDistance <= agent.stoppingDistance && !agent.pathPending){
                Task.current.Succeed();
            }
        }
    }

        [Task]
    public bool SeePlayer(){
        Vector3 distance = player.transform.position - this.transform.position;
        RaycastHit hitInfo;
        bool SeeWall = false;
        if(Physics.Raycast(this.transform.position,distance, out hitInfo)){
            if(hitInfo.collider.gameObject.tag=="Wall"){
                SeeWall = true;
            }
        }if(Task.isInspected){
        }
        if(distance.magnitude < 10.0f && !SeeWall){
            return true;
        }else{
            return false;
        }
        
        
        
        
        
        }
                [Task]

        public void FollowPlayer(){
        animator.SetFloat("Walk",1);
        animator.SetBool("Hit2",false);
            if(Task.isInspected){
                    agent.SetDestination(player.transform.position);
                    Task.current.Succeed();
            }
        }

            [Task]
    public bool PlayerClose(){
        Vector3 distance = player.transform.position - this.transform.position;
        if(Task.isInspected){
        }
        if(distance.magnitude < 3.0f){
            return true;
        }else{
            return false;
        }
        
        
        
        
        
        }


        [Task]
        public void AttackPlayer(){
        animator.SetFloat("Walk",0);
        animator.SetBool("Hit2",true);          
        agent.stoppingDistance = 3.0f;  
        if(Task.isInspected){
                    agent.SetDestination(player.transform.position);
                    Task.current.Succeed();
            }
        }
    void OnDrawGizmos(){
        Gizmos.color = Color.magenta;
        Gizmos.DrawCube(this.gameObject.transform.position,new Vector3(5, 10, 5));
    }

}
