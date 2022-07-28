using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Shooting : MonoBehaviour
{
    public Animator animator;
    public float range = 1000f;
    public GameObject hitEffect;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetMouseButton(0)){
            animator.SetBool("aim",true);
        }if(Input.GetMouseButtonUp(0)){
            animator.SetBool("aim",false);
        }
    }
}
