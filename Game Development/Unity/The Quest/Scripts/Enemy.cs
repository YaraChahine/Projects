using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{
    private GameObject player;

    Animator animator;

    

    private void OnCollisionEnter(Collision other) {
        if (other.gameObject.tag=="bullet"){
            this.gameObject.SetActive(false);
        }
    }
    public GameObject GetPlayer(){
        return player;
    }
    // Start is called before the first frame update
    void Start()
    {
        animator = GetComponent<Animator>();
        player=GameObject.FindGameObjectWithTag("Player");
    }

    // Update is called once per frame
    void Update()
    {
        animator.SetFloat("distance",Vector3.Distance(transform.position, player.transform.position));
    }


    void OnDrawGizmos(){
        Gizmos.color = Color.red;
        Gizmos.DrawCube(this.gameObject.transform.position,new Vector3(4, 4, 4));
    }

}
