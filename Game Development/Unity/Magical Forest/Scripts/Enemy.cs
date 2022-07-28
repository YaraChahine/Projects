using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;
using TMPro;

public class Enemy : MonoBehaviour
{    NavMeshAgent agent;
private Animation anim;
    [SerializeField]  Transform target;


        
    float distance;
    GameObject myPlayer;
    [SerializeField] 
    TMP_Text enemyText;

    float alpha;
    float alertDistance = 50f;
    [SerializeField] 
    int health = 100;
    // Start is called before the first frame update
    void Start()
    {
       // myPlayer = GameObject.FindWithTag("Player");
        alpha = enemyText.alpha;
       agent= GetComponent<NavMeshAgent>();
       anim=GetComponent<Animation>();
    
        //anim.Play();
      
    }

    // Update is called once per frame
    void Update()
    {


        distance = Vector3.Distance(target.position, transform.position);
        if (distance <= alertDistance)
         {      agent.destination=target.position;

                anim.Play();
             StartCoroutine(appearAndDisappear());
             
      
         }else{
             StopAllCoroutines();
             enemyText.alpha=0;
         }
    }
    
    public int getHealth(){
        return health;
    }

    public void setHealth(int h){
        health = h;
    }

    IEnumerator appear(int x){
    for(float y = alpha; alpha<=x ; alpha+=0.1f*Time.deltaTime){
        enemyText.alpha =alpha;
        yield return null;
        }
    }

    IEnumerator disappear(int y){
    for(float i = alpha; alpha>=y ; alpha-=0.1f*Time.deltaTime){
        enemyText.alpha = alpha;
        yield return null;
        }
    }

    IEnumerator appearAndDisappear(){
        yield return StartCoroutine(appear(1));
        yield return new WaitForSeconds(1f);
        yield return StartCoroutine(disappear(0));
    }
}

